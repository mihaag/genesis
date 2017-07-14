angular.module('app')
  .controller('loginController', function ($q, $scope, authService, $location, toastr, loginService, homeService) {

    $scope.login = login;
    $scope.solicitarAcesso = solicitarAcesso;
    $scope.estadoBotao = false;

    function login(usuario) {
      if ($scope.formLogin.$valid) {
        authService.login(usuario)
          .then(function (response) {
            toastr.success('Login com sucesso!');
            $location.path('/home');
          },
          function (response) {
            toastr.error('Login ou Senha inválidos!');
          });
      } else {
        toastr.error('Preencha todos os dados corretamente.', 'Dados inválidos!');
      }
    };

    function solicitarAcesso(user) {
      $scope.estadoBotao = habilitaDesabilitaBotao($scope.estadoBotao);
            
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
              }, this);

              if (countSolicitacoesComOEmail !== 0) {
                toastr.error('Email já está aguardando liberação');
                $scope.estadoBotao = habilitaDesabilitaBotao($scope.estadoBotao);
                $scope.desabilitarEnviarSolicitacao = true;
              } else {
                verificaSeNaoEhCadastrado(user.email).then(() => {
                  var solicitacaoAcesso = {
                    "id": 0,
                    "email": user.email
                  };
                  loginService.enviarSolicitacaoAcesso(solicitacaoAcesso)
                    .then(() => {
                      toastr.success('Solicitação enviada!', 'Aguarde o email de aprovação')
                      $location.path('/home');
                      $scope.user.email = "";
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
                  toastr.success('Solicitação enviada!', 'Aguarde o email de aprovação');
                  $location.path('/home');
                }, () => {
                });
            })
        } else {
          toastr.error('Insira um email da CWI');
          $scope.estadoBotao = habilitaDesabilitaBotao($scope.estadoBotao);
        }
      } else {
        toastr.error('Email invalido');
        $scope.estadoBotao = habilitaDesabilitaBotao($scope.estadoBotao);
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

    function habilitaDesabilitaBotao(estadoBotao){
        return !estadoBotao;
    }

  });