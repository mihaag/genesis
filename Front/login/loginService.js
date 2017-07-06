angular.module('app')
  .factory('loginService', function ($http) {

    let urlBase = 'http://localhost:9090/';

    function enviarSolicitacaoAcesso(email) {
      return $http({
        url: urlBase,
        method: 'POST'
        // headers: {
        //   Authorization: headerAuth
        // }
      });
    };

    return {
        enviarSolicitacaoAcesso : enviarSolicitacaoAcesso
    };
  });