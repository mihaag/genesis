angular.module('app')
  .controller('pesquisaController', function ($routeParams, $scope, authService, $location, toastr, loginService, 
  homeService, pesquisaService, colaboradorService, timesService, tagsService) {
      $scope.pesquisaTime=true;
      $scope.irParaHome = irParaHome;

      pesquisa();

      function pesquisa() {
          var tipo = pesquisaService.getTipo();
         if(tipo === 'time')
            pesquisarTime();
          else if(tipo === 'colaborador')
                     pesquisarColaborador();
                else if(tipo === 'tag')
                         pesquisarTag();
      }

      function pesquisarColaborador() {
        debugger;
        var nomeColab = pesquisaService.getTermo();
        colaboradorService.buscarColaboradorPorNome(nomeColab)
            .then(function (response) {
               $scope.pesquisa = response.data;
               $scope.pesquisarColaboradores = true;
            })
    };

    function pesquisarTime(){
         var nomeTime = pesquisaService.getTermo();
        timesService.procurarTimePorNome(nomeTime).then(function (response) {
            $scope.pesquisa = response.data;
            $scope.pesquisarTimes = true;
        })
    };

    function pesquisarTag(){
         var descricaoTag = pesquisaService.getTermo();
        tagsService.buscarTagsPorPesquisa(descricaoTag).then(function (response) {
            $scope.pesquisa = response.data;
            $scope.pesquisarTags = true;
        })
    };

    function irParaHome() {
            $location.path('/home');
    };
  });