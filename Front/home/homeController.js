angular.module('app')
    .controller('homeController', function ($scope, authService, $location, toastr, homeService, pesquisaService,
    timeColaboradorService) {
        $scope.pesquisar = pesquisar;
        $scope.editar = editar;

        listarFeitos();

        function listarFeitos() {
            homeService.buscarFeitosConformePermissao().then(function (response) {
                $scope.feitos = response.data;
                debugger;
                if (authService.isAutenticado()) {
                   $scope.naoAutenticado = false;
                   timeColaboradorService.colaboradorEhOwner().then(function (response) {
                       $scope.time = response.data;
                       console.log(response.data);
                       console.log(response.data.length);
                       if ($scope.time.length > 0) {
                           console.log("é owner");
                       }
                       else{
                           console.log("o que");
                       }
                   })
                }

            })
        }

        function pesquisar(pesquisa) {
            pesquisaService.setPesquisa(pesquisa);
            console.log(pesquisaService.getTermo());
            console.log(pesquisaService.getTipo());
            $location.path('/pesquisa');
        }

        function editar() {
            console.log("clicou");
            var userLogado = authService.getUsuario();
            $location.path('/perfil/editar/' + userLogado.id);
        }
    });