angular.module('app')
    .controller('feitosController', function ($scope, authService, $location, toastr, feitosService, timesService, timeColaboradorService,colaboradorService) {
        console.log("entrou");
        $scope.user=authService.getUsuario();
        $scope.criarFeito = criarFeito;
        listarFeitos();
        function listarFeitos() {
            feitosService.buscarFeitos()
                .then(function (response) {
                    $scope.feitosExistentes = response.data;
                });
        }

        function criarFeito(feito) {
            if ($scope.feito === 'undefined')
                $scope.desabilitarBotao = true;
            feito.idPermissao = {
                "id": feito.idPermissao
            };
            feito.id = 0;
            if (typeof feito.descricaoresumida === 'undefined')
                feito.descricaoresumida = null;

            var countFeitosDuplicados = 0;
            
            $scope.feitosExistentes.forEach(function (feitoExistente) {
                if (feitoExistente.nome === feito.nome) {
                    countFeitosDuplicados++;
                }
            }, this);
            if (countFeitosDuplicados > 0)
                toastr.error('Ops...', 'Esse feito já existe');
            else {
                feitosService.criarFeito(feito)
                    .then(function () {
                        toastr.success('Feito cadastrado');
                        $scope.feito = {};
                        $location.path("/admin");
                        listarFeitos();
                    })
            }
            console.log(feito);
        }
    });