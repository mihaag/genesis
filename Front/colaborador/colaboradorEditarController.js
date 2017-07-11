angular.module("app")

    .controller("colaboradorEditarController", function ($scope, $routeParams, $location, colaboradorService, toastr) {

        $scope.cadastrar = cadastrar;
        

       
    //   "id": 0,
    //   "email": "joao6@gmail.com", ----
    //   "nomecompleto": "joao",--
    //   "nascimento": "1991-01-22",--
    //   "admissao": "2016-01-01",--
    //   "demissao": null,
    //   "sede": 1,
    //   "ramal": null,
    //   "andar": null,
    //   "posicao": null,
    //   "descricao": null,
    //   "descricaoresumida": null,
    //   "situacao": "A",
    //   "senha": "1234",
    //   "possuiTime": "N", 
    //   "idPermissao": {--
    //       "id": 1--
    //   },
    //   "foto":"http://torcedores.uol.com.br/content/uploads/2016/04/Fabr%C3%ADcio-Cruzeiro.jpg"

        function cadastrar(colaborador) {
            colaborador.id = 0;
            colaborador.possuiTime = "N";
            if (typeof colaborador.descricaoresumida === 'undefined')
                colaborador.descricaoresumida = null;
            colaborador.andar = null;
            colaborador.posicao = null;
            colaborador.ramal = null;
            colaborador.descricao = null;
            colaborador.descricaoresuumida=null;
            colaborador.situacao = "A";
            colaborador.senha = null;
            colaborador.demissao = null;
            var countRepetidos = 0;
            var cadastrados =[];
            
            colaboradorService.buscarTodosOsColaboradores().then(function (response) {
                cadastrados = response.data;
                cadastrados.forEach(function(colab) {
                    if (colab.email === colaborador.email) {
                        countRepetidos++;
                    }

                }, this);

            if (countRepetidos > 0) {
                toastr.error('Email já cadastrado');
            }
            else{
                //colaboradorService.cadastrarColcaborador(colaborador).then(function (response) {
                    console.log(colaborador);
                    toastr.success('cadastrado com sucesso');
                //})
            }


            });
        }

    })