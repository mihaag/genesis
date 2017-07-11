angular.module('app')
    .controller('adminController', function ($scope, authService, $location, toastr, feitosService, timesService, timeColaboradorService, colaboradorService) {
        $scope.irParaHome = irParaHome;
        $scope.listarTimes = listarTimes;
        $scope.listarFeitos = listarFeitos;
        $scope.listarColaboradores = listarColaboradores;

        function irParaHome() {
            $location.path('/home');
        }

        function listarFeitos() {
            feitosService.buscarFeitos().then(function (response) {
                $scope.feitos = response.data;
                $scope.listfeitos = true;
                console.log($scope.feitos);
            });
        }

        function listarTimes() {
            timesService.buscarTimes().then(function (response) {
                $scope.times = response.data;
                console.log($scope.times);
            });
        }

        function listarColaboradores() {
            colaboradorService.buscarTodosOsColaboradores().then(function (response) {
                $scope.colaboradores = response.data;
                console.log($scope.colaboradores);
            });
        }




    });