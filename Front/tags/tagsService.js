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

    return {
        buscarTags: buscarTags,
        criarTag : criarTag,
        buscarTagsColaborador : buscarTagsColaborador
    };
  });