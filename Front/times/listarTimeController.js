angular.module('app')
  .controller('listarTimeController', function ($scope, authService, $location, toastr, $routeParams, timesService, timeColaboradorService) {
          debugger;
          listarTimes(); 
 
        function listarTimes() { 
            debugger;
            timesService.buscarTimesComFoto().then(function (response) { 
                debugger;
                $scope.times = response.data; 
            }); 
        } 
});