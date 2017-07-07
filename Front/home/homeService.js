angular.module('app')
  .factory('homeService', function ($http) {

    let urlBase = 'http://localhost:9090/';

    function buscarUsuariosCadastrados() {
      return $http({
        url: urlBase + 'colaboradores',
        method: 'GET'
      });
    };

    return {
        buscarUsuariosCadastrados : buscarUsuariosCadastrados
    };
  });