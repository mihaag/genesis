angular.module('app') 
    .controller('colaboradorListarController', function ($scope, authService, $location, toastr, colaboradorService) { 
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
            console.log($scope.colaborador);
        });
       };

       function vincularFeito(colaborador) {
           $location.patn('/colaborador/vincular-feito/' + colaborador.id);
       };

       function criarCadastrarColab() {
           $location.patn('/colaborador/criar')
       };

       function listarTimes() { 
           debugger;
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