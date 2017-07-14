angular.module('app')
    .controller('adminController', function ($scope, authService, $location) {
        $scope.usuarioLogado = authService.getUsuario();
    
        if($scope.usuarioLogado.idPermissao.id !== 1){
            $location.path('/home');
        }
        
        $scope.irParaHome = irParaHome;
        $scope.listarTimes = listarTimes;
        $scope.listarFeitos = listarFeitos;
        $scope.listarColaboradores = listarColaboradores;
        $scope.logout = logout;

        function irParaHome() {
            $location.path('/home');
        };

        function listarFeitos() {
            $location.path('/feito/listar');
        };

        function listarTimes() {
            $location.path('/time/listar');
        };

        function listarColaboradores(){
            $location.path('/colaborador/listar');
        };

        function logout(){
            authService.logout();
            $location.path('/home');
        };
    });