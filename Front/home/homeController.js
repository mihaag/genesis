angular.module('app')
    .controller('homeController', function ($scope, authService, $location, toastr, homeService, pesquisaService,
    timeColaboradorService, solicitacaoTrocaTimeService) {
        $scope.pesquisar = pesquisar;
        $scope.editar = editar;
        $scope.irParaPaginaTime = irParaPaginaTime;

        listarFeitos();

        function listarFeitos() {
            homeService.buscarFeitosConformePermissao().then(function (response) {
                debugger
                $scope.feitos = response.data;
                if (authService.isAutenticado()) {
                   $scope.naoAutenticado = false;
                   timeColaboradorService.colaboradorEhOwner().then(function (response) {
                       $scope.time = response.data;
                       console.log($scope.time);
                       if ($scope.time !== null) {
                            $scope.ehOwner = true;
                            solicitacaoTrocaTimeService.countSolicitacoes($scope.time.idTimecwi.id).then(function (response) {
                                $scope.solicitacao= response.data;
                                if($scope.solicitacao === 0 )
                                $scope.temSolicitacao = false;
                                else $scope.temSolicitacao = true;
                            })
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

        function irParaPaginaTime() {
            console.log($scope.time.idTimecwi.id);
            $location.path('/time/visualizar/' + $scope.time.idTimecwi.id);
        }
    });