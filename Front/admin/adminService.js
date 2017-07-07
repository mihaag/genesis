angular.module('app')
  .factory('adminService', function ($http) {

    let urlBase = 'http://localhost:9090/feitos';


    function buscarFeitos() {
      return $http({
        url: urlBase,
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
        return $http({
        url: urlBase,
        method: 'DELETE',
        data: feito
      });
    }

    return {
        buscarFeitos : buscarFeitos,
        criarFeito : criarFeito,
        atualizarFeito : atualizarFeito,
        excluirFeito : excluirFeito
    };
  });