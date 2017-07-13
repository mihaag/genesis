angular.module('app')
    .controller('homeController', function ($scope, authService, $location, toastr, homeService, pesquisaService) {
        $scope.pesquisar = pesquisar;
        $scope.editar = editar;

        listarFeitos();

        function listarFeitos() {
            homeService.buscarFeitosConformePermissao().then(function (response) {
                $scope.feitos = response.data;
                console.log($scope.feitos);

                if (authService.isAutenticado()) {
                   $scope.naoAutenticado = false;
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