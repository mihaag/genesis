angular.module('app') 
    .controller('feitosListarController', function ($scope, authService, $location, toastr, feitosService) { 
       $scope.inativar = inativar; 
       $scope.editar = editar; 
       $scope.criarFeito = criarFeito; 
 
        listarFeitos(); 
 
        function listarFeitos() { 
            feitosService.buscarFeitos().then(function (response) { 
                $scope.feitos = response.data; 
                $scope.listfeitos = true; 
                console.log($scope.feitos); 
            }); 
        } 
 
        function criarFeito() { 
            $location.path('/feito/criar'); 
        } 
 
        function irParaTimes() { 
            $location.path('/times/listar'); 
        } 
 
        function irParaColaboradores() { 
            $location.path('/colaboradores/listar'); 
        } 
        function inativar(feito) { 
            return null; 
        } 
 
        function editar(feito) { 
            $location.path('feito/editar/' + feito.id); 
        } 
});