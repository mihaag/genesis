angular.module('app')
    .controller('feitosEditarController', function ($scope, authService, $location, toastr, feitosService, $routeParams, feitosService) {
        $scope.buscarFeito = buscarFeito;
        $scope.atualizarFeito =atualizarFeito;
        $scope.listarFeitos = listarFeitos;

        buscarFeito($routeParams.id);
        listarFeitos();

        function buscarFeito(id){
            feitosService.buscarFeitoPorId(id).then(function (response) {
                $scope.feito = response.data;
            })
        }

        function atualizarFeito(feito) {
            
            if (verificarSeFeitoJaExiste(feito) > 0)
                toastr.error('Ops...', 'Esse feito já existe');
            else {
                feitosService.atualizarFeito(feito).then(function () {
                    toastr.success('Feito atualizado');
                    $location.path("/admin");
                }, function () {
                    toastr.error('Ops... Algo deu errado');
                })
            }
        }

        function verificarSeFeitoJaExiste(feito) {
            var countFeitosDuplicados = 0;
            $scope.feitosExistentes.forEach(function (feitoExistente) {
                if (feitoExistente.nome === feito.nome && feito.id !== feitoExistente.id) {
                    countFeitosDuplicados++;
                }
            }, this);
            return countFeitosDuplicados;
        }

        function listarFeitos() {
            feitosService.buscarFeitos()
                .then(function (response) {
                    $scope.feitosExistentes = response.data;
                });
        }
        console.log($scope.feito);
});