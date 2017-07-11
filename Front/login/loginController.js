angular.module('app')
  .controller('loginController', function ($q, $scope, authService, $location, toastr, loginService, homeService) {

    $scope.login = login;
    $scope.solicitarAcesso = solicitarAcesso;

    function login(usuario) {
      if ($scope.formLogin.$valid) {
        authService.login(usuario)
          .then(function (response) {
            toastr.success('Login com sucesso!');
            $location.path('/admin')
          },
          function (response) {
            toastr.error('Login ou Senha inválidos!');
          });
      } else {
        toastr.error('Preencha todos os dados corretamente.', 'Dados inválidos!');
      }
    };

    function solicitarAcesso(user) {
      debugger
      if ($scope.formSolicitarAcesso.$valid) {
        var emailEhCwi = new RegExp("@cwi.");
        if (emailEhCwi.test(user.email)) {
          loginService.buscarSolicitacoesAcesso()

            .then(function successCallback(response) {
              var solicitacoes = response.data;
              var countSolicitacoesComOEmail = 0;
              solicitacoes.forEach(function (solicitacao) {
                if (user.email === solicitacao.email)
                  countSolicitacoesComOEmail++;
                console.log("count", countSolicitacoesComOEmail);
              }, this);

              if (countSolicitacoesComOEmail !== 0) {
                toastr.error('Email já está aguardando liberação');
                $scope.desabilitarEnviarSolicitacao = true;
              } else {
                verificaSeNaoEhCadastrado(user.email).then(() => {
                  debugger;
                  var solicitacaoAcesso = {
                    "id": 0,
                    "email": user.email
                  };
                  loginService.enviarSolicitacaoAcesso(solicitacaoAcesso)
                    .then(() => {
                      toastr.success('Solicitação enviada!', 'Aguarde o email de aprovação')
                    });
                })
              }
            }, function errorCallback(response) {
              var solicitacaoAcesso = {
                "id": 0,
                "email": user.email
              };
              loginService.enviarSolicitacaoAcesso(solicitacaoAcesso)
                .then(() => {
                  debugger;
                  toastr.success('Solicitação enviada!', 'Aguarde o email de aprovação')
                }, () => {
                  debugger;
                });
            })
        } else toastr.error('Insira um email da CWI');
      } else {
        toastr.error('Email invalido');
      }
    }

    function verificaSeNaoEhCadastrado(email) {
      var deferred = $q.defer();

      homeService.buscarUsuariosCadastrados()
        .then(function (response) {
          var cadastrados = response.data;
          var countCadastradosComOEmail = 0;
          cadastrados.forEach(function (cadastrado) {
            if (cadastrado.email === email)
              countCadastradosComOEmail++;
          }, this);
          if (countCadastradosComOEmail > 0) {
            toastr.error('Email já cadastrado');
            deferred.reject();
          } else {
            deferred.resolve();
          };
        })
      return deferred.promise;
    }
  });