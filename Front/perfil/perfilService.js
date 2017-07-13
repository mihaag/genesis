angular.module('app')
  .factory('perfilService', function ($http) {

    let urlBase = 'http://localhost:9090/colaboradores-feitos/';

    function buscarFeitosPublicosDoUsuario(id) {
      return $http({
        url: urlBase + 'perfil/' + id,
        method: 'GET'
      });
    };

    
    function buscarFeitosDoUsuarioPorPermissao(id) {
      return $http({
        url: urlBase + id,
        method: 'GET'
      });
    };

    return {
        buscarFeitosPublicosDoUsuario : buscarFeitosPublicosDoUsuario,
        buscarFeitosDoUsuarioPorPermissao : buscarFeitosDoUsuarioPorPermissao
    };
  });