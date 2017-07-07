angular.module('app')
  .factory('loginService', function ($http) {

    let urlBase = 'http://localhost:9090/solicitacao-acesso';

    function enviarSolicitacaoAcesso(solicitacaoAcesso) {
      return $http({
        url: urlBase,
        method: 'POST',
        data: solicitacaoAcesso
      });
    };

    function buscarSolicitacoesAcesso() {
      return $http({
        url: urlBase,
        method: 'GET'
      });
    };

    return {
        enviarSolicitacaoAcesso : enviarSolicitacaoAcesso,
        buscarSolicitacoesAcesso : buscarSolicitacoesAcesso
    };
  });