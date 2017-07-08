angular.module('app')
    .controller('adminController', function ($scope, authService, $location, toastr, feitosService, timesService) {
      $scope.isCollapsed = true;
      $scope.irParaHome = irParaHome;
      $scope.mostrarAdicaoFeito = mostrarAdicaoFeito;
      $scope.criarFeito = criarFeito;
      $scope.clicouEditarFeito = clicouEditarFeito;
      $scope.fecharEditar = fecharEditar;
      $scope.atualizarFeito = atualizarFeito;
      $scope.excluirFeito = excluirFeito;

      listarFeitos();

      function irParaHome() {
          $location.path('/home');
      }

      $scope.clicouTime=false;

      function mostrarAdicaoFeito() {
          $scope.clicouFeito=true;
      }

      function listarFeitos() {
          feitosService.buscarFeitos()
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
                feitosService.criarFeito(feito)
                   .then(function(){
                        toastr.success('Feito cadastrado');
                        $scope.feito ={};
                        $scope.clicouFeito =false;
                        listarFeitos();
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
          feitosService.atualizarFeito($scope.feito)
            .then(function () {
                toastr.success('Feito atualizado');
                $scope.feito = {}
                $scope.editarFeito = false;
            },function () {
                toastr.error('Ops... Algo deu errado');
            })
      }

      function excluirFeito(feito) {
          var id = {"id":feito.id}
          feitosService.excluirFeito(id)
          .then(function () {
              toastr.success('Feito deletado com sucesso');
          }, function () {
              toastr.error('Ops... Algo deu errado');
          })
      }
});