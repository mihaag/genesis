angular.module('app')
    .controller('feitosController', function ($scope, authService, $location, toastr, feitosService, timesService, timeColaboradorService, colaboradorService) {
        
        $scope.user = authService.getUsuario();
        $scope.irParaHome = irParaHome;
        $scope.criarFeito = criarFeito;
        listarFeitos();

        function listarFeitos() {
            feitosService.buscarFeitos()
                .then(function (response) {
                    $scope.feitosExistentes = response.data;
                });
        };

        function criarFeito(feito) {
            if ($scope.feito === 'undefined')
                $scope.desabilitarBotao = true;
            feito.idPermissao = {
                "id": feito.idPermissao
            };
            feito.id = 0;
            if (typeof feito.descricaoresumida === 'undefined')
                feito.descricaoresumida = null;
            if (verificarSeFeitoJaExiste(feito) > 0)
                toastr.error('Ops...', 'Esse feito já existe');
            else {
                feitosService.criarFeito(feito)
                    .then(function () {
                        toastr.success('Feito cadastrado');
                        $scope.feito = {};
                        $location.path("/feito/listar");
                        listarFeitos();
                    })
            }
        };

        function verificarSeFeitoJaExiste(feito) {
            var countFeitosDuplicados = 0;
            $scope.feitosExistentes.forEach(function (feitoExistente) {
                if (feitoExistente.nome === feito.nome) {
                    countFeitosDuplicados++;
                }
            }, this);
            return countFeitosDuplicados;
        };

        function irParaHome() {
            $location.path('/home');
        };
    });