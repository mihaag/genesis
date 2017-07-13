angular.module('app')
  .factory('homeService', function ($http) {

    let urlBase = 'http://localhost:9090/';

    function buscarUsuariosCadastrados() {
      return $http({
        url: urlBase + 'colaboradores',
        method: 'GET'
      });
    };

    function buscarFeitos() {
      return $http({
        url: urlBase + 'colaboradores-feitos/home-aut',
        method: 'GET'
      });
    };

    function buscarFeitosPublicos(){
      return $http({
        url: urlBase + 'colaboradores-feitos/home-publica',
        method: 'GET'
      });
    };

    return {
      buscarFeitos: buscarFeitos,
      buscarFeitosPublicos: buscarFeitosPublicos, 
      buscarUsuariosCadastrados : buscarUsuariosCadastrados
    };
  });