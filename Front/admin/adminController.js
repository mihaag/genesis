angular.module('app')
    .controller('adminController', function ($scope, authService, $location, toastr, adminService) {
      $scope.isCollapsed = true;
      $scope.irParaHome = irParaHome;
      $scope.mostrarAdicaoFeito = mostrarAdicaoFeito;
      $scope.criarFeito = criarFeito;
      $scope.clicouEditarFeito = clicouEditarFeito;
      $scope.fecharEditar = fecharEditar;

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
          if($scope.feito === 'undefined')
            $scope.desabilitarBotao=true;
          feito.idPermissao = {"id": feito.idPermissao};
          feito.id = 0;
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
                        $scope.feito ={};
                        $scope.clicouFeito =false;
                    })
            }
          console.log(feito);
      }

      function clicouEditarFeito(feito) {
          $scope.editarFeito = true;
          console.log(feito);
          $scope.feito = feito;
      }

      function fecharEditar() {
          $scope.editarFeito = false;
      }

      function atualizarFeito() {
          adminService.atualizarFeito($scope.feito)
            .then(function () {
                toastr.success('Feito atualizado');
                $scope.feito = {}
                $scope.editarFeito = false;
            },function () {
                toastr.error('Ops... Algo deu errado');
            })
      }

      function exluirFeito(feito) {
          adminService.excluirFeito(feito)
          .then(function () {
              toastr.success('Feito deletado com sucesso');
          }, function () {
              toastr.error('Ops... Algo deu errado');
          })
      }
});