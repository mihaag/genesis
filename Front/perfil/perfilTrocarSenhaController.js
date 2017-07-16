angular.module('app')
  .controller('perfilTrocarSenhaController', function ($scope, authService, $location, toastr, $localStorage,
    colaboradorService, loginService, homeService, perfilService, $routeParams, $http, tagsService) {
        $scope.trocarSenha = trocarSenha;
        $scope.irParaHome = irParHome;

        function irParHome() {
            $location.path('/home');
        }

        function trocarSenha(senha) {
            senha.senha === senha.confirmacao ? $scope.camposNaoSaoIguais = false : $scope.camposNaoSaoIguais = true;
            
            if($scope.camposNaoSaoIguais){
                return;
            }
            
            var colaborador = authService.getUsuario();
            colaborador.senha = senha.senha;
            colaboradorService.atualizarSenha(colaborador).then(function () {
                toastr.success('Senha alterada');
                authService.logout();
            }, function () {
                toastr.error('Não foi possível alterar a senha');
            });
        }
    });