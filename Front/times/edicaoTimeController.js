angular.module('app').controller('edicaoTimeController', function ($scope, authService, $location, toastr, 
    $routeParams, timesService, colaboradorService, timeColaboradorService) {
    
    $scope.atualizarTime = atualizarTime;
    $scope.pesquisar = pesquisar;
    $scope.adicionarMembros = adicionarMembros;
    $scope.adicionarOwner = adicionarOwner;

    buscarTime($routeParams.id);

    function buscarTime(id){
        timesService.buscarTimePorId(id).then(response => {
            $scope.time = response.data;

            $scope.membrosTime = [];
            $scope.ownersTime = [];
           
            timeColaboradorService.procurarColaboradorTime($scope.time)
                .then(function (response) {
                    var colabs = response.data;
                    colabs.forEach(function(colab) {
                        if(colab.tipo === "M"){
                            $scope.membrosTime.push(colab);
                            membrosDoTime.push(colab.idColaborador.id)
                        } else if(colab.tipo === "O"){
                            $scope.ownersTime.push(colab);
                            ownersDoTime.push(colab.idColaborador.id)
                        }
                    }, this);
            })
        })
    };

    function atualizarTime(time) {
            time.membros = membrosDoTime;
            time.owners = ownersDoTime;
            
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

    var membrosDoTime = [];
    
    function adicionarMembros(membros) {
        debugger;
        
        membrosDoTime.push(membros.id);
        $scope.pesquisa = {};
    };

    var ownersDoTime = [];
    
    function adicionarOwner(owners) {
        debugger;
        ownersDoTime.push(owners.id);
        $scope.pesquisa = {};
    };
});