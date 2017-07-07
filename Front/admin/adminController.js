angular.module('app')
    .controller('adminController', function ($scope, authService, $location, toastr, adminService) {
      $scope.isCollapsed = true;
      $scope.irParaHome = irParaHome;
      $scope.mostrarAdicaoFeito = mostrarAdicaoFeito;
      $scope.criarFeito = criarFeito;

      listarFeitos();

      function irParaHome() {
          $location.path('/home');
      }

      $scope.clicouTime=false;

      function mostrarAdicaoFeito() {
          $scope.clicouFeito=true;
      }

      function listarFeitos() {
          adminService.buscarFeitos()
        .then(function (response) {
            $scope.feitosExistentes = response.data;
         });
      }
      function criarFeito(feito) {
          feito.idPermissao = {"idPermissao": feito.idPermissao};
          if(typeof feito.descricaoresumida === 'undefined')
            feito.descricaoresumida = null;
        
            var countFeitosDuplicados = 0;
            $scope.feitosExistentes.forEach(function(feitoExistente) {
                if (feitoExistente.nome === feito.nome) {
                    countFeitosDuplicados++;
                }
            }, this);
            if(countFeitosDuplicados > 0)
                toastr.error('Ops...' ,'Esse feito já existe');
            else{
                adminService.criarFeito(feito)
                   .then(function(){
                        toastr.success('Feito cadastrado');
                        feito ={};
                    })
            }
          console.log(feito);

      }
});