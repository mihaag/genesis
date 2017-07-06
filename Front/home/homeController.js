angular.module('app')
    .controller('homeController', function ($scope, authService, $location, toastr) {
        $scope.telaAdmin = telaAdmin;

        function telaAdmin() {
            debugger;
            $location.path('/admin');
        }
    });