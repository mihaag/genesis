angular.module('app')
    .controller('primeiroAcessoController', function ($scope, authService, $location, toastr) {
        $scope.mostrarSenha = mostrarSenha;
        $scope.acessar = acessar;
        $scope.tipo = "password";

        //nao deixar mostrar a senha se não tiver senha
        function mostrarSenha() {
            $scope.tipo = $scope.tipo === "password" ? "text" : "password";
        }

        function acessar() {
            return null;
        }
    });