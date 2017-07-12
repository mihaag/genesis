angular.module('app').controller('edicaoTimeController', function ($scope, authService, $location, toastr,
    $routeParams, timesService, colaboradorService, timeColaboradorService) {

    $scope.atualizarTime = atualizarTime;
    $scope.pesquisar = pesquisar;
    $scope.adicionarMembros = adicionarMembros;
    $scope.adicionarOwner = adicionarOwner;
    $scope.removerMenbroDoGrupo = removerMenbroDoGrupo;
    $scope.removerOwnerDoGrupo = removerOwnerDoGrupo;
    var membrosOwners = {};
    var timeAtualizado = {};
    membrosOwners['membros'] = [];
    membrosOwners['owners'] = [];


    buscarTime($routeParams.id);

    function buscarTime(id) {

        timesService.buscarTimePorId(id).then(response => {
            $scope.time = response.data;
            $scope.membrosTime = [];
            $scope.ownersTime = [];

            timeColaboradorService.procurarColaboradorTime($scope.time)
                .then(function (response) {
                    var colabs = response.data;
                    colabs.forEach(function (colab) {
                        if (colab.tipo === "M") {
                            $scope.membrosTime.push(colab);
                            membrosOwners['membros'].push(colab.idColaborador.id)
                        } else if (colab.tipo === "O") {
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
        console.log($scope.$routeParamsfomularioEditarTime);
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
        verificaOwner()
    }

    function tornarOwner(colaborador) {
        let dados = {};
        dados['idColaborador'] = colaborador;
        removerMenbroDoGrupo(colaborador);
        membrosOwners['owners'].push(colaborador.idColaborador.id);
        $scope.ownersTime.push(dados);
    }

    function tornarMembro(owner) {
        let dados = {};
        dados['idColaborador'] = owner;
        removerOwnerDoGrupo(owner);
        membrosOwners['membros'].push(owner.idColaborador.id);
        $scope.membrosTime.push(owner);
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