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
            /*pegar service que da put no usuario*/
            primeiroAcessoService.acessoUsuario(user.senha)
            .then(function(){
                toastr.succes('Bem vindo ao Gênesis CWI!');
                $location.path('/home');
            })
            toastr.success('Bem vindo ao Gênesis CWI');
            $location.path('/home');
        }

        
    });