angular.module('app') 
    .controller('colaboradorListarController', function ($scope, authService, $location, toastr, colaboradorService) { 
       $scope.usuarioLogado = authService.getUsuario();
    
        if($scope.usuarioLogado.idPermissao.id !== 1){
            $location.path('/home');
        };
       
       $scope.vincularFeito = vincularFeito;
       $scope.criarCadastrarColab = criarCadastrarColab;
       $scope.editar = editar;
       $scope.listarFeitos = listarFeitos;
       $scope.listarTimes = listarTimes;
       $scope.irParaHome = irParaHome;
       $scope.logout = logout;

       listarColaboradores();
       
       function listarColaboradores() {
        colaboradorService.buscarTodosOsColaboradores().then(function (response) {
            $scope.colaboradores = response.data;
        });
       };

       function vincularFeito(colaborador) {
           $location.path('/colaborador/vincular-feito/' + colaborador.id);
       };

       function criarCadastrarColab() {
           $location.path('/colaborador/criar');
       };

       function listarTimes() { 
            $location.path('/time/listar'); 
        };

        function listarFeitos() {
            $location.path('/feito/listar');
        };

        function editar(colaborador) {
            $location.path('/colaborador/editar/' + colaborador.id);
        };

        function logout(){
            authService.logout();
            $location.path('/home');
        };

        function irParaHome() {
            $location.path('/home');
        };
    });