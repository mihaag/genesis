angular.module("app")
    .controller("colaboradorEditarController", function ($scope, $routeParams, authService, $location, colaboradorService, toastr) {
        $scope.usuarioLogado = authService.getUsuario();
    
        if($scope.usuarioLogado.idPermissao.id !== 1){
            $location.path('/home');
        };
        
        $scope.editar = editar;
        $scope.irParaHome = irParaHome;
        buscarColaborador($routeParams.id);

        function buscarColaborador(id) {
            colaboradorService.buscarDadosColaborador(id).then(function (response) {
                $scope.colab = response.data;
                $scope.colab.admissao = converterParaDate($scope.colab.admissao);
                $scope.colab.nascimento = converterParaDate($scope.colab.nascimento);
            })
        };

        function converterParaDate(timestamp) {
            return new Date(timestamp);
        };

        function editar(colaborador) {
            colaborador.demissao = null;
            var countRepetidos = 0;
            var cadastrados = [];

            colaboradorService.buscarTodosOsColaboradores().then(function (response) {
                cadastrados = response.data;
                cadastrados.forEach(function (colab) {
                    if (colab.email === colaborador.email && colab.id !== colaborador.id) {
                        countRepetidos++;
                    }
                }, this);
                if (countRepetidos > 0) {
                    toastr.error('Email já cadastrado');
                } else {
                    verificarSeCamposOpcionarsForamPreencidos(colaborador);
                    colaboradorService.atualizarColaborardor(colaborador).then(function (response) {
                        toastr.success('Atualizado com sucesso');
                        $location.path("/colaborador/listar");
                    }, function () {
                        toastr.error('Ops... Houveram problemas');
                    })
                }
            });
        };

        function verificarSeCamposOpcionarsForamPreencidos(colaborador) {
            if (typeof colaborador.descricaoresumida === 'undefined')
                colaborador.descricaoresumida = null;
            if (typeof colaborador.descricao === 'undefined')
                colaborador.descricao = null;
            if (typeof colaborador.andar === 'undefined')
                colaborador.andar = null;
            if (typeof colaborador.ramal === 'undefined')
                colaborador.ramal = null;
            if (typeof colaborador.posicao === 'undefined')
                colaborador.posicao = null;
        };

        function irParaHome() {
            $location.path('/home');
        };
    })