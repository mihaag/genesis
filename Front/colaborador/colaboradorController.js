angular.module("app")
    .controller("colaboradorController", function ($scope, $routeParams, $location, colaboradorService, toastr) {
        $scope.cadastrar = cadastrar;

        function cadastrar(colaborador) {
            console.log("cliocu");
            colaborador.id = 0;
            colaborador.possuiTime = "N";
            colaborador.situacao = "A";
            colaborador.senha = null;
            colaborador.demissao = null;
            var countRepetidos = 0;
            var cadastrados = [];

            colaboradorService.buscarTodosOsColaboradores().then(function (response) {
                cadastrados = response.data;
                cadastrados.forEach(function (colab) {
                    if (colab.email === colaborador.email) {
                        countRepetidos++;
                    }
                }, this);
                if (countRepetidos > 0) {
                    toastr.error('Email já cadastrado');
                } else {
                    verificarSeCamposOpcionarsForamPreencidos(colaborador);
                    colaboradorService.cadastrarColaborador(colaborador).then(function (response) {
                        toastr.success('cadastrado com sucesso');
                        $location.path("/admin");
                    })
                }
            });
        }

        function verificarSeCamposOpcionarsForamPreencidos(colaborador) {
            if (typeof colaborador.descricaoresumida === 'undefined')
                colaborador.descricaoresumida = null;
            if (typeof colaborador.descricao === 'undefined')
                colaborador.descricao = null;
            if (typeof colaborador.andar === 'undefined')
                colaborador.andar = null;
            if (typeof colaborador.ramal === 'undefined')
                colaborador.ramal = null;
            if (typeof colaborador.posicao === 'undefined')
                colaborador.posicao = null;
        }
    });