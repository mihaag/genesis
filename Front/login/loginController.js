angular.module('app')
  .controller('loginController', function ($scope, authService, $location, toastr) {

    $scope.login = login;
    $scope.solicitarAcesso = solicitarAcesso;

    function login(usuario) {
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

    function solicitarAcesso(user) {
      if ($scope.formSolicitarAcesso.$valid) {
        var emailEhCwi = new RegExp("@cwi.");
        if (emailEhCwi.test(user.email)) {
          console.log(user.email);
          toastr.success('Solicitação enviada!', 'Aguarde o email de aprovação');
        } else toastr.error('Insira um email da CWI');
      } else {
        toastr.error('Email invalido');
      }
    }
  });