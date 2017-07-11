angular.module('app')
  .factory('feitosService', function ($http) {

    let urlBase = 'http://localhost:9090/feitos/';


    function buscarFeitos() {
      return $http({
        url: urlBase,
        method: 'GET'
      });
    };

    function buscarFeitoPorId(id) {
      return $http({
        url: urlBase + id,
        method: 'GET'
      });
    };

    function criarFeito(feito) {
        return $http({
        url: urlBase,
        method: 'POST',
        data: feito
      });
    }

    function atualizarFeito(feito) {
        return $http({
        url: urlBase,
        method: 'PUT',
        data: feito
      });
    }

    function excluirFeito(feito) {
      console.log(feito);
        return $http({
        url: urlBase + 'excluir',
        method: 'POST',
        data: feito
      });
    }

    return {
        buscarFeitos : buscarFeitos,
        criarFeito : criarFeito,
        atualizarFeito : atualizarFeito,
        excluirFeito : excluirFeito,
        buscarFeitoPorId:buscarFeitoPorId
    };
  });