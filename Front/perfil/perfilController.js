angular.module('app')
  .controller('perfilController', function ($scope, authService, $location, toastr, loginService, homeService) {
    $scope.teste = [{
      "email": "alana.weiss@cwi.com.br",
      "nomecompleto": "Alana Lange Weiss",
      "nascimento": "1998-01-22",
      "admissao": "2017-01-01"
    }];
    console.log($scope.colaborador);
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
    ];

    $scope.loadMovies = function(query) {
    return ["alana","mirela","jabel", "rafael" ]
  };
    $scope.tags = [{"nome":"java"}, {"nome":"dotNet"}];
    $scope.ehColab =false;
  });