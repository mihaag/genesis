angular.module('app')
  .controller('loginController', function ($scope, authService, $location, toastr) {

    $scope.login = function (usuario) {

      if ($scope.formLogin.$valid) {
        authService.login(usuario)
          .then(function (response) {
              toastr.success('Login com sucesso!');
            },
            function (response) {
              toastr.success('Login ou Senha inválidos!');
            });
      } else {
        toastr.error('Preencha todos os dados corretamente.', 'Dados inválidos!');
      }
    };

  });