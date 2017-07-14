angular.module('app')
  .factory('tagsService', function ($http) {

    let urlBase = 'http://localhost:9090/colaborador-tag/';

    function buscarTags() {
      return $http({
        url: urlBase,
        method: 'GET'
      });
    };

    function criarTag(colabTag) {
        return $http({
        url: urlBase,
        method: 'POST',
        data: colabTag
      });
    }

    function buscarTagsColaborador(id) {
        return $http({
        url: urlBase + 'colaborador/' + id,
        method: 'GET'
      });
    }

    function removerTag(id) {
         return $http({
        url: urlBase + 'excluir/' + id,
        method: 'DELETE'
      });
    }

    function buscarTagsPorPesquisa(termo) {
        return $http({
        url: urlBase + 'procurar?termo=' + termo,
        method: 'GET'
      });
    }

    return {
        buscarTags: buscarTags,
        criarTag : criarTag,
        buscarTagsColaborador : buscarTagsColaborador,
        removerTag : removerTag,
        buscarTagsPorPesquisa : buscarTagsPorPesquisa
    };
  });