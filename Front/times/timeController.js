angular.module('app')
  .controller('timeController', function ($scope, authService, $location, toastr, $routeParams, timesService, timeColaboradorService) {
    $scope.user = {
      "nome": "Alana Lange Weiss"
    };
    $scope.buscarTime = buscarTime;
    $scope.status = {
      isopen: false
    };

    $scope.membrosTime = [];
    $scope.ownersTime = [];

    buscarTime($routeParams.id);
    console.log($routeParams.id);

    function buscarTime(id) {
      timesService.buscarTimePorId(id).then(function (response) {
        $scope.time = response.data;
      })
      timeColaboradorService.procurarColaboradorTimeId(id).then(function name(response) {
        var colabs = response.data;
        console.log(colabs);
        colabs.forEach(function (colab) {
          if (colab.tipo === "M") {
            $scope.membrosTime.push(colab);
          } else if (colab.tipo === "O") {
            $scope.ownersTime.push(colab);
          }
        }, this);
        console.log("membros", $scope.membrosTime);
        console.log("owners", $scope.ownersTime);
      })
    };

  });