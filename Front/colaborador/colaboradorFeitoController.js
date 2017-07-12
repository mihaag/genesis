angular.module('app')
    .controller('colaboradorFeitoController', function ($scope, authService, $location,
        toastr, colaboradorService, $routeParams, feitosService) {
            $scope.vincular = vincular;
        colaboradorEFeitos($routeParams.id);

        function colaboradorEFeitos(id) {
            colaboradorService.buscarDadosColaborador(id).then(function (response) {
                $scope.colaborador = response.data;
                feitosService.buscarFeitos().then(function (response) {
                    $scope.feitos = response.data;
                })
            });
        }

        function vincular(feitoColaborador) {
            feitoColaborador.id=0;
            feitoColaborador.idColaborador = $scope.colaborador;
            feitosService.vincularFeito(feitoColaborador).then(function () {
                toastr.success('Feito Vinculado com sucesso');
                $location.path('/colaborador/listar');
            })
            console.log(feitoColaborador);
        }
    });