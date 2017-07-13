angular.module('app')
  .factory('solicitacaoTrocaTimeService', function ($http) {
      let urlBase = 'http://localhost:9090/trocar-time';


    function criarSolicitacao(solicitacao) {
      return $http({
        url: urlBase,
        method: 'POST',
        data: solicitacao
      });
    };

      return {
        criarSolicitacao : criarSolicitacao
    };
  });