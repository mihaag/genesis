angular.module('app')
    .controller('homeController', function ($scope, authService, $location, toastr, homeService, pesquisaService,
        timeColaboradorService, solicitacaoTrocaTimeService) {
        $scope.pesquisar = pesquisar;
        $scope.editar = editar;
        $scope.irParaPaginaTime = irParaPaginaTime;
        $scope.login = login;
        $scope.logout = logout;
        $scope.irParaHome = irParaHome;
        $scope.verPerfil = verPerfil;
        $scope.solicitarAcesso = solicitarAcesso;
        $scope.irParaPaginaAdmin = irParaPaginaAdmin;

        $scope.usuarioAutenticado = authService.isAutenticado();
        $scope.usuarioLogado = authService.getUsuario();

        validaPermissaoUsuarioLogado($scope.usuarioLogado);
        listarFeitos();

        function listarFeitos() {
            if ($scope.usuarioAutenticado) {
                homeService.buscarFeitos().then(response => {
                    $scope.feitos = response.data;

                    timeColaboradorService.colaboradorEhOwner().then(function (response) {
                        $scope.time = response.data;
                        if ($scope.time !== "") {
                            $scope.ehOwner = true;
                            solicitacaoTrocaTimeService.countSolicitacoes($scope.time.idTimecwi.id).then(function (response) {
                                $scope.solicitacao = response.data;
                                if ($scope.solicitacao === 0)
                                    $scope.temSolicitacao = false;
                                else $scope.temSolicitacao = true;
                            })
                        }
                    });
                });
            } else {
                homeService.buscarFeitosPublicos().then(response => {
                    $scope.feitos = response.data;
                });
            }
        };

        function pesquisar(pesquisa) {
            pesquisaService.setPesquisa(pesquisa);
            console.log(pesquisaService.getTermo());
            console.log(pesquisaService.getTipo());
            $location.path('/pesquisa');
        };

        function editar() {
            console.log("clicou");
            var userLogado = authService.getUsuario();
            $location.path('/perfil/editar/' + userLogado.id);
        };

        function irParaPaginaTime() {
            console.log($scope.time.idTimecwi.id);
            $location.path('/time/visualizar/' + $scope.time.idTimecwi.id);
        };

        function validaPermissaoUsuarioLogado(usuario) {
            if (typeof usuario === 'undefined' || usuario === null) {
                $scope.permissaoAdministrador = false;
                $scope.permissaoColaborador = false;
                $scope.permissaoMaster = false;
                return;
            }

            switch (usuario.idPermissao.id) {
                case 1:
                    $scope.permissaoAdministrador = true;
                    $scope.permissaoColaborador = false;
                    $scope.permissaoMaster = false;
                    break;
                case 2:
                    $scope.permissaoColaborador = true;
                    $scope.permissaoAdministrador = false;
                    $scope.permissaoMaster = false;
                    break;
                case 3:
                    $scope.permissaoMaster = true;
                    $scope.permissaoAdministrador = false;
                    $scope.permissaoColaborador = false;
                    break;
                default:
                    $scope.permissaoAdministrador = false;
                    $scope.permissaoColaborador = false;
                    $scope.permissaoMaster = false;
            }
            return;
        };

        function login(){
            $location.path('/login');
        };

        function logout(){
            authService.logout();
            location.reload();
        };

        function irParaHome(){
            location.reload();
        };

        function verPerfil(){
            $location.path('/perfil/'+$scope.usuarioLogado.id);
        };

        function solicitarAcesso(){
            $location.path('/solicitar');
        };

        function irParaPaginaAdmin(){
            $location.path('/admin');
        };
    });