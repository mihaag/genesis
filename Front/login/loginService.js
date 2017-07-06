angular.module('app')
  .factory('loginService', function ($http) {

    let urlBase = 'http://localhost:9090/';

    function enviarSolicitacaoAcesso(solicitacaoAcesso) {
      return $http({
        url: urlBase + 'solicitacaoAcesso',
        method: 'POST',
        data: solicitacaoAcesso
      });
    };

    function buscarSolicitacoesAcesso() {
      return $http({
        url: urlBase + 'solicitacaoAcesso',
        method: 'GET'
      });
    };

    return {
        enviarSolicitacaoAcesso : enviarSolicitacaoAcesso,
        buscarSolicitacoesAcesso : buscarSolicitacoesAcesso
    };
  });