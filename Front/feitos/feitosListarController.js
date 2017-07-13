angular.module('app') 
    .controller('feitosListarController', function ($scope, authService, $location, toastr, feitosService) { 
       $scope.inativar = inativar; 
       $scope.editar = editar; 
       $scope.criarFeito = criarFeito; 
       $scope.listarTimes =irParaTimes;
       $scope.listarColaboradores = irParaColaboradores;
 
        listarFeitos(); 
 
        function listarFeitos() { 
            feitosService.buscarFeitos().then(function (response) { 
                $scope.feitos = response.data; 
                $scope.listfeitos = true; 
            }); 
        } 
 
        function criarFeito() { 
            $location.path('/feito/criar'); 
        } 
 
        function irParaTimes() { 
            $location.path('/time/listar'); 
        } 
 
        function irParaColaboradores() { 
            $location.path('/colaboradore/listar'); 
        } 
        function inativar(feito) { 
            return null; 
        } 
 
        function editar(feito) { 
            $location.path('feito/editar/' + feito.id); 
        } 
});