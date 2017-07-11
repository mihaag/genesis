angular.module('app')
    .controller('feitosListarController', function ($scope, authService, $location, toastr, feitosService) {
       $scope.inativar = inativar;
       $scope.editar = editar;

        listarFeitos();

        function listarFeitos() {
            feitosService.buscarFeitos().then(function (response) {
                $scope.feitos = response.data;
                $scope.listfeitos = true;
                console.log($scope.feitos);
            });
        }

        function inativar(feito) {
            return null;
        }

        function editar(feito) {
            $location.path('feito/editar/' + feito.id);
        }
});