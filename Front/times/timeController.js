angular.module('app')
  .controller('timeController', function ($scope, authService, $location, toastr, $routeParams, timesService, timeColaboradorService) {
    
    $scope.solicitarTroca = solicitarTroca;
    $scope.irParaHome = irParaHome;
  
    $scope.membrosTime = [];
    $scope.ownersTime = [];
    var membrosGeral = [];
    var user = authService.getUsuario();
     var countRepetidos = 0;

    buscarTime($routeParams.id);
  
    function buscarTime(id) {
       timesService.buscarTimePorIdComFoto(id).then(function (response) {
                $scope.time = response.data;
                $scope.situacaoTela = $scope.time.time.situacao === 'A' ? 'Ativo' : 'Inativo';

                timeColaboradorService.procurarColaboradorTimeId(id).then(function name(response) {
                  var colabs = response.data;
                  colabs.forEach(function (colab) {
                  if (colab.tipo === "M") {
                    $scope.membrosTime.push(colab);
                    membrosGeral.push(colab);
                  } else if (colab.tipo === "O") {
                    $scope.ownersTime.push(colab);
                    membrosGeral.push(colab);
                  }
                }, this);
                membrosGeral.forEach(function(membro) {
                  console.log(membrosGeral);
                  if(membro.idColaborador.id === user.id){
                   countRepetidos++;
                  }
                }, this);
                if(countRepetidos > 0){
                  $scope.jaEstaNoTime = true;
                }
              })
        }); 
    };

    function solicitarTroca(){

    }

    function irParaHome() {
      $location.path('/home');
    }

  });