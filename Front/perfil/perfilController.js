angular.module('app')
  .controller('perfilController', function ($scope, authService, $location, toastr, loginService, homeService) {
    $scope.colaborador = [{
      "id": 0,
      "email": "alana.weiss@cwi.com.br",
      "nomecompleto": "Alana Lange Weiss",
      "nascimento": "1998-01-22",
      "admissao": "2017-01-01",
      "demissao": null,
      "sede": 1,
      "ramal": null,
      "andar": null,
      "posicao": null,
      "descricao": null,
      "descricaoresumida": null,
      "situacao": "A",
      "senha": "1111",
      "idPermissao": {
        "id": 1
      }
    }]
    $scope.feitos = [{
        "nome": "tetse",
        "imagem": "http://files.softicons.com/download/web-icons/services-flat-icons-by-jozef-krajcovic/png/512x512/consult.png"
      },
      {
        "nome": "teste 2",
        "imagem": "http://files.softicons.com/download/web-icons/services-flat-icons-by-jozef-krajcovic/png/512x512/consult.png"
      },
      {
        "nome": "tetse 3",
        "imagem": "http://files.softicons.com/download/web-icons/services-flat-icons-by-jozef-krajcovic/png/512x512/consult.png"
      }
    ]

    $scope.loadMovies = function(query) {
    return ["alana","mirela","jabel", "rafael" ]
  };
  });