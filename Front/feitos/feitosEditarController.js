angular.module('app')
    .controller('feitosEditarController', function ($scope, authService, $location, toastr, $routeParams, feitosService) {

        $scope.usuarioLogado = authService.getUsuario();
    
        if($scope.usuarioLogado.idPermissao.id !== 1){
            $location.path('/home');
        }

        $scope.buscarFeito = buscarFeito;
        $scope.atualizarFeito =atualizarFeito;
        $scope.listarFeitos = listarFeitos;
        $scope.irParaHome = irParaHome;

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
                    $location.path("/feito/listar");
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

        function irParaHome() {
            $location.path('/home');
        };
});