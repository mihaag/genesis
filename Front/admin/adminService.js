angular.module('app')
  .factory('adminService', function ($http) {

    let urlBase = 'http://localhost:9090/feitos';


    function buscarFeitos() {
      return $http({
        url: urlBase,
        method: 'GET'
      });
    };

    function criarFeito() {
        return $http({
        url: urlBase,
        method: 'POST'
      });
    }

    return {
        buscarFeitos : buscarFeitos,
        criarFeito : criarFeito
    };
  });