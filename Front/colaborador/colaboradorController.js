

angular.module("app")

    .controller("colaboradorController", function ($scope, $routeParams, $location, colaboradorService) {

        $routeParams.nome;
        $scope.cadastrar = cadastrar;
        $scope.atualizar = atualizar;
        $scope.buscar = buscar;
        $scope.colaborador = {};
        $scope.idPermissao = {};

        function cadastrar(colaborador) {
            colaborador.id = 0;
            //colaborador.idPermissao = ($scope.idPermissao.id  = {id:colaborador.idPermissao});   

            colaboradorService.cadastrarColcaborador(colaborador).then(function (response) {
                $scope.mensagem = 'cadastrado com sucesso';
            })
        }

        function atualizar(colaborador) {
            colaboradorService.atualizarColaborador(colaborador).then(function (Response) {
                $scope.mensagem = 'atualizado com sucesso';
            })
        }

        function buscar(nome) {
            colaboradorService.procurarColaborador(nome).then(function (response) {
                $scope.colaborador = response.data;
            })
        }
    })