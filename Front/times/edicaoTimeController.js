angular.module('app').controller('edicaoTimeController', function ($scope, authService, $location, toastr, 
    $routeParams, timesService, colaboradorService, timeColaboradorService) {
    
    $scope.atualizarTime = atualizarTime;
    $scope.pesquisar = pesquisar;
    $scope.adicionarMembros = adicionarMembros;
    $scope.adicionarOwner = adicionarOwner;       
    var membrosOwners = {};
    var timeAtualizado = {}; 
    membrosOwners['membros'] = [];
    membrosOwners['owners'] = [];  
    

    buscarTime($routeParams.id);

    function buscarTime(id){
        
        timesService.buscarTimePorId(id).then(response => {
            $scope.time = response.data;
            debugger;
            $scope.membrosTime = [];
            $scope.ownersTime = [];
           
            timeColaboradorService.procurarColaboradorTime($scope.time)
                .then(function (response) {
                    var colabs = response.data;
                    colabs.forEach(function(colab) {
                        if(colab.tipo === "M"){
                            $scope.membrosTime.push(colab);
                            membrosOwners['membros'].push(colab.idColaborador.id)
                        } else if(colab.tipo === "O"){
                            $scope.ownersTime.push(colab);
                            membrosOwners['owners'].push(colab.idColaborador.id)
                        }                         
                    }, this);
            })
        })
    };

    verificaOwner();

    function atualizarTime(time) {
            time.membros = membrosOwners['membros'];
            time.owners = membrosOwners['owners'];
            
            timesService.atualizarTimes(time)
                .then(function () {                    
                    toastr.success('Time atualizado');
                    $location.path('/admin')
                }, function () {
                    toastr.error('Ops... Algo deu errado');
                })
    };

    function pesquisar(nomeColab) {
        colaboradorService.buscarColaboradorPorNome(nomeColab)
            .then(function (response) {
                $scope.pesquisa = response.data;
            })
    };    
    
    
    function adicionarMembros(membros) {
        debugger;     
        let dados = {}
        let naoPodeAdicionar = membrosOwners['membros'].includes(membros.id) || membrosOwners['owners'].includes(membros.id);
        debugger;
        if(naoPodeAdicionar){
            toastr.error('ja vinculado ao time');
            return;
        }

        dados['idColaborador'] = membros;           
        membrosOwners['membros'].push(membros.id); 
        $scope.membrosTime.push(dados);       
        $scope.pesquisa = {};        
    };    
    
     
    function adicionarOwner(owners) {
        let dados = {}; 
        let naoPodeAdicionar = membrosOwners['owners'].includes(owners.id) || membrosOwners['membros'].includes(owners.id);
        debugger;
        if(naoPodeAdicionar){
            toastr.error('ja vinculado ao time');
            return;  
        }

        dados['idColaborador'] = owners;              
        membrosOwners['owners'].push(owners.id);
        $scope.ownersTime.push(dados);
        $scope.pesquisa = {};  
        verificaOwner();  
    };

    function verificaOwner(){        
        $scope.verificaOwner = membrosOwners['owners'].length <= 0 ;
        debugger
    }
});

// {
//        "id": 0,
//        "nome": "Teste Time",
//        "descricao": "Teste Time",
//        "descricaoresumida": "Teste",
//        "situacao": "A",
//        "owners": [1],
//        "membros": [23, 25]
// }