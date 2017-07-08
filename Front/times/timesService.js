angular.module('app')
  .factory('timesService', function ($http) {

    let urlBase = 'http://localhost:9090/times';


    function buscarTimes() {
      return $http({
        url: urlBase,
        method: 'GET'
      });
    };

    function criarTimes(time) {
        return $http({
        url: urlBase,
        method: 'POST',
        data: time
      });
    }

    function atualizarTimes(time) {
        return $http({
        url: urlBase,
        method: 'PUT',
        data: time
      });
    }

    return {
        buscarTimes : buscarTimes,
        criarTimes : criarTimes,
        atualizarTimes : atualizarTimes
    };
  });