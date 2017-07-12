angular.module('app')
    .controller('homeController', function ($scope, authService, $location, toastr, homeService) {
      listarFeitos();

        function listarFeitos() {
            homeService.buscarFeitosConformePermissao().then(function (response) {
                $scope.feitos = response.data;
                console.log($scope.feitos);
            })
        }
    });