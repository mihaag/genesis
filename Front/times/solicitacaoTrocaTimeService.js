angular.module('app')
  .factory('solicitacaoTrocaTimeService', function ($http) {
    let urlBase = 'http://localhost:9090/trocar-time/';
    let urlBaseTimeColaborador = 'http://localhost:9090/times-colaboradores/';

    function criarSolicitacao(solicitacao) {
      return $http({
        url: urlBase,
        method: 'POST',
        data: solicitacao
      });
    };

    function countSolicitacoes(idTime) {
      return $http({
        url: urlBase + 'quant-solicitacoes/' + idTime,
        method: 'GET'
      });
    }

    function buscarSolicitacoes(idTime) {
      return $http({
        url: urlBase + idTime,
        method: 'GET'
      });
    }

    function aceitarSolicitacao(Solicitacao) {
      return $http({
        url: `${urlBaseTimeColaborador}confirmar-troca`,
        method: 'POST',
        data: Solicitacao
      });
    }

    function deletarSolicitacao(solicitacao) {
      return $http.post(`${urlBase}remover-solicitacao`, solicitacao);
      
    }

    return {
      criarSolicitacao: criarSolicitacao,
      countSolicitacoes: countSolicitacoes,
      buscarSolicitacoes: buscarSolicitacoes,
      aceitarSolicitacao: aceitarSolicitacao,
      deletarSolicitacao:deletarSolicitacao
    };
  });