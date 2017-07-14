angular.module('app')
  .factory('solicitacaoTrocaTimeService', function ($http) {
      let urlBase = 'http://localhost:9090/trocar-time/';

    function criarSolicitacao(solicitacao) {
      return $http({
        url: urlBase,
        method: 'POST',
        data: solicitacao
      });
    };

    function countSolicitacoes(idTime) {
      return $http({
        url: urlBase +'quant-solicitacoes/' +idTime,
        method: 'GET'
      });
    }

    function buscarSolicitacoes(idTime) {
      return $http({
        url: urlBase + idTime,
        method: 'GET'
      });
    }

    function aceitarSolicitacao(solicitacao) {
      return null;
    }

      return {
        criarSolicitacao : criarSolicitacao,
        countSolicitacoes : countSolicitacoes,
        buscarSolicitacoes : buscarSolicitacoes,
        aceitarSolicitacao : aceitarSolicitacao
    };
  });