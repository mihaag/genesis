angular.module('app')
  .controller('listarTimeController', function ($scope, authService, $location, toastr, $routeParams, timesService, timeColaboradorService) {
          $scope.editar = editar;
          $scope.listarFeitos = listarFeitos;
          $scope.listarColaboradores =listarColaboradores;
          $scope.criarTime = criarTime;
          listarTimes(); 
 
        function listarTimes() { 
            debugger;
            timesService.buscarTimesComFoto().then(function (response) { 
                $scope.times = response.data; 
                console.log($scope.times);
            }); 
        } 

        function editar(time) {
            $location.path('/time/editar/'+ time.time.id);
        }

        function listarFeitos() {
            $location.path('/feito/listar');
        }

        function criarTime() {
            $location.path('/time/criar');
        }

        function listarColaboradores() {
            $location.path('/colaborador/listar');
        }
});