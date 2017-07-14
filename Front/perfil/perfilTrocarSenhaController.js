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
            var colaborador = authService.getUsuario();
            colaborador.senha = senha.senha;
            colaboradorService.atualizarSenha(colaborador).then(function () {
                toastr.success('Senha alterada');
                $location.path('/perfil/'+colaborador.id);
            }, function () {
                toastr.error('Nao foi possivel alterar a senha');
            });
        }
    });