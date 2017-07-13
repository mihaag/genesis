angular.module('app')
  .controller('listarTimeController', function ($scope, authService, $location, toastr, $routeParams, timesService, timeColaboradorService) {
          $scope.editar = editar;
          $scope.listarFeitos = listarFeitos;
          $scope.listarColaboradores =listarColaboradores;
          $scope.criarTime = criarTime;
          $scope.inativar = inativar;
          $scope.irParaHome = irParaHome;
          $scope.logout = logout;
          listarTimes(); 
 
        function listarTimes() { 
            debugger;
            timesService.buscarTimesComFoto().then(function (response) { 
                $scope.times = response.data; 
                console.log($scope.times);
                $scope.times.forEach(function(time) {
                    if (time.time.situacao === "I") {
                        time.exibirBotoes = false;
                    }
                    else{ 
                        time.exibirBotoes = true;
                    }
                }, this);
            }); 
        };

        function editar(time) {
            $location.path('/time/editar/'+ time.time.id);
        };

        function listarFeitos() {
            $location.path('/feito/listar');
        };

        function criarTime() {
            $location.path('/time/criar');
        };

        function listarColaboradores() {
            $location.path('/colaborador/listar');
        };

        function inativar(time) {
            debugger;
            timesService.inativarTime(time.id).then(function () {
                toastr.success('Time inativado com sucesso');
                listarTimes();
            });
        };

        function irParaHome() {
            $location.path('/home');
        };

        function logout(){
            authService.logout();
            $location.path('/home');
        };
});