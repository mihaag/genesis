angular.module('app')
  .controller('loginController', function ($scope, authService, $location, toastr, loginService) {

    $scope.login = login;
    $scope.solicitarAcesso = solicitarAcesso;

    function login(usuario) {
      if ($scope.formLogin.$valid) {
        authService.login(usuario)
          .then(function (response) {
              toastr.success('Login com sucesso!');
              $location.path('/solicitar')
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
          loginService.buscarSolicitacoesAcesso()
            .then(function (response) {
              var solicitacoes = response.data;
              var countSolicitacoesComOEmail = 0;
              solicitacoes.forEach(function (solicitacao) {
                if (user.email === solicitacao.email)
                  countSolicitacoesComOEmail++;
              }, this);
              if (countSolicitacoesComOEmail !== 0) {
                toastr.error('Email já está aguardando liberação');
                $scope.desabilitarEnviarSolicitacao = true;
              } else {
                var solicitacaoAcesso = {
                  "id": 0,
                  "email": user.email
                };
                /*loginService.enviarSolicitacaoAcesso(solicitacaoAcesso)
                .then( toastr.success('Solicitação enviada!', 'Aguarde o email de aprovação'));*/
                toastr.success('Solicitação enviada!', 'Aguarde o email de aprovação');
              }
            });
        } else toastr.error('Insira um email da CWI');
      } else {
        toastr.error('Email invalido');
      }
    }
  });