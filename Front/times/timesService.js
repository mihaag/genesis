angular.module('app')
  .factory('timesService', function ($http) {

    let urlBase = 'http://localhost:9090/times/';


    function buscarTimes() {
      return $http({
        url: urlBase,
        method: 'GET'
      });
    };

    function buscarTimesComFoto() {
      return $http({
        url: urlBase +'buscar-times',
        method: 'GET'
      });
    };

    function buscarTimePorIdComFoto(id) {
      return $http({
        url: urlBase +'buscar-time/' + id,
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

    function procurarTimePorNome(termo) {
      return $http({
        url: urlBase + 'procurar?termo=' + termo,
        method: 'GET'
      });
    }

    function atualizarTimes(time) {
        return $http({
        url: urlBase,
        method: 'PUT',
        data: time
      });
    }

    function buscarTimePorId(time) {
        return $http({
        url: urlBase + time,
        method: 'GET',
        data: time
      });
    }

    function inativarTime(id) {
      return $http({
        url: urlBase + '/inativar/' + id,
        method: 'POST'
      });
    }


    return {
        buscarTimes : buscarTimes,
        criarTimes : criarTimes,
        atualizarTimes : atualizarTimes,
        buscarTimePorId : buscarTimePorId,
        inativarTime:inativarTime,
        buscarTimesComFoto :buscarTimesComFoto,
        buscarTimePorIdComFoto: buscarTimePorIdComFoto,
        procurarTimePorNome : procurarTimePorNome
    };
  });