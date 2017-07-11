

angular.module("app")

    .controller("colaboradorController", function ($scope, $routeParams, $location, colaboradorService, toastr) {

        $routeParams.nome;
        $scope.cadastrar = cadastrar;
        $scope.atualizar = atualizar;
        $scope.buscar = buscar;
        $scope.colaborador = {};
        $scope.idPermissao = {};

        function cadastrar(colaborador) {
            colaborador.id = 0;
            colaboradorService.cadastrarColcaborador(colaborador).then(function (response) {
                 toastr.succsess('cadastrado com sucesso');
            })
        }

        function atualizar(colaborador) {
            colaborador.idPermissao = ($scope.idPermissao.id  = {id:colaborador.idPermissao});   
            colaboradorService.atualizarColaborador(colaborador).then(function (Response) {
               toastr.succsess('Atualizado com sucesso');
            })
        }

        function buscar(nome) {
            colaboradorService.procurarColaborador(nome).then(function (response) {
                $scope.colaborador = response.data;
            })
        }
    })