angular.module('app').controller('criacaoTimeController', function ($scope, authService, $location, toastr, $routeParams,
    timesService, colaboradorService,) {

    $scope.criarTime = criarTime;
    $scope.pesquisar = pesquisar;
    $scope.adicionarMembros = adicionarMembros;
    $scope.adicionarOwner = adicionarOwner;
    $scope.removerMenbroDoGrupo = removerMenbroDoGrupo;
    $scope.removerOwnerDoGrupo = removerOwnerDoGrupo;
    $scope.tornarMembro = tornarMembro;
    $scope.tornarOwner = tornarOwner;
    $scope.verificaOwner = true;
    $scope.membrosTime = [];
    $scope.ownersTime = [];

    var membrosOwners = {};
    var timeAtualizado = {};
    membrosOwners['membros'] = [];
    membrosOwners['owners'] = [];

    function criarTime(time) {
            time.membros = membrosOwners['membros'];
            time.owners = membrosOwners['owners'];
            time.situacao = "A";    
            timesService.criarTimes(time)
                .then(function () {
                    toastr.success('Time cadastrado');
                    $location.path('/time/listar');
                })
    };

    function pesquisar(nomeColab) {
        colaboradorService.buscarColaboradorPorNome(nomeColab)
            .then(function (response) {
                $scope.pesquisa = response.data;
                $scope.nomeColab = "";
            })
    };    
    
    function adicionarMembros(membros) {
        debugger;
        let dados = {}
        let naoPodeAdicionar = membrosOwners['membros'].includes(membros.id) || membrosOwners['owners'].includes(membros.id);
        if (naoPodeAdicionar) {
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
        if (naoPodeAdicionar) {
            toastr.error('ja vinculado ao time');
            return;
        }

        dados['idColaborador'] = owners;
        membrosOwners['owners'].push(owners.id);
        $scope.ownersTime.push(dados);
        $scope.pesquisa = {};
        verificaOwner();
    };

     function verificaOwner() {       
        $scope.verificaOwner = membrosOwners['owners'].length <= 0;
    }

    function removerMenbroDoGrupo(colaborador) {
        debugger;
        $scope.membrosTime = $scope.membrosTime.filter(f => f.idColaborador.id != colaborador.idColaborador.id);
        membrosOwners['membros'] = membrosOwners['membros'].filter(f => f != colaborador.idColaborador.id);
    }

    function removerOwnerDoGrupo(owner) {
        $scope.ownersTime = $scope.ownersTime.filter(o => o.idColaborador.id != owner.idColaborador.id);
        membrosOwners['owners'] = membrosOwners['owners'].filter(f => f != owner.idColaborador.id);
        debugger;
        verificaOwner()
    }

    function tornarOwner(colaborador) {
        debugger;   
        let dados = {};        
        removerMenbroDoGrupo(colaborador);
        membrosOwners['owners'].push(colaborador.idColaborador.id);
        $scope.ownersTime.push(colaborador);        
        verificaOwner()
    }

    function tornarMembro(owner) {       
        removerOwnerDoGrupo(owner);
        membrosOwners['membros'].push(owner.idColaborador.id);
        $scope.membrosTime.push(owner);
        verificaOwner();
    }
    
});