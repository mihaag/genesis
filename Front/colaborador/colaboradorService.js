angular.module('app')
  .factory('colaboradorService', function ($http) {

    let urlBase = 'http://localhost:9090/colaboradores';

    function buscarColaboradorPorNome(nomeColab) {
      return $http({
        url: urlBase +'/procurar/' + nomeColab,
        method: 'GET'
      });
    };

    return {
        buscarColaboradorPorNome : buscarColaboradorPorNome};
  });