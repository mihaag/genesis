angular.module('app')
    .controller('adminController', function ($scope, authService, $location, toastr, feitosService, timesService, timeColaboradorService,colaboradorService) {
        $scope.isCollapsed = true;
        $scope.irParaHome = irParaHome;
        $scope.mostrarAdicaoFeito = mostrarAdicaoFeito;
        $scope.criarFeito = criarFeito;
        $scope.clicouEditarFeito = clicouEditarFeito;
        $scope.clicouEditarTime = clicouEditarTime;
        $scope.fecharEditar = fecharEditar;
        $scope.atualizarFeito = atualizarFeito;
        $scope.excluirFeito = excluirFeito;
        $scope.pesquisar = pesquisar;
        $scope.pesquisarOwner = pesquisarOwner;
        $scope.criarTime = criarTime;
        $scope.cadastrarTime = cadastrarTime;

        listarFeitos();
        listarTimes();

        function irParaHome() {
            $location.path('/home');
        }

        $scope.clicouTime = false;

        function mostrarAdicaoFeito() {
            $scope.clicouFeito = true;
            $scope.clicouTime = false;
            $scope.clicouEditarTime = false;
        }

        function listarFeitos() {
            feitosService.buscarFeitos()
                .then(function (response) {
                    $scope.feitosExistentes = response.data;
                });
        }

        function criarFeito(feito) {
            if ($scope.feito === 'undefined')
                $scope.desabilitarBotao = true;
            feito.idPermissao = {
                "id": feito.idPermissao
            };
            feito.id = 0;
            if (typeof feito.descricaoresumida === 'undefined')
                feito.descricaoresumida = null;

            var countFeitosDuplicados = 0;
            $scope.feitosExistentes.forEach(function (feitoExistente) {
                if (feitoExistente.nome === feito.nome) {
                    countFeitosDuplicados++;
                }
            }, this);
            if (countFeitosDuplicados > 0)
                toastr.error('Ops...', 'Esse feito já existe');
            else {
                feitosService.criarFeito(feito)
                    .then(function () {
                        toastr.success('Feito cadastrado');
                        $scope.feito = {};
                        $scope.clicouFeito = false;
                        listarFeitos();
                    })
            }
        }

        function clicouEditarFeito(feito) {
            $scope.editarFeito = true;
            $scope.clicouTime = false;
            $scope.clicouEditarTime = false;
            $scope.feito = feito;
        }

        function fecharEditar() {
            $scope.editarFeito = false;
        }

        function atualizarFeito() {
            feitosService.atualizarFeito($scope.feito)
                .then(function () {
                    toastr.success('Feito atualizado');
                    $scope.feito = {}
                    $scope.editarFeito = false;
                }, function () {
                    toastr.error('Ops... Algo deu errado');
                })
        }

        function excluirFeito(feito) {
            var id = {
                "id": feito.id
            }
            feitosService.excluirFeito(id)
                .then(function () {
                    toastr.success('Feito deletado com sucesso');
                }, function () {
                    toastr.error('Ops... Algo deu errado');
                })
        }

        function listarTimes() {
            timesService.buscarTimes()
                .then(function (response) {
                    $scope.times = response.data;
                })
        }

        function cadastrarTime() {
            $location.path('/time/criar');
        }

        function criarTime(time) {
            time.membros = membrosDoTime;
            time.owners = ownersDoTime;
            time.situacao = "A";    
            timesService.criarTimes(time)
                .then(function () {
                    toastr.success('Time cadastrado');
                    $scope.clicouTime = false;
                    listarTimes();
                    membrosDoTime = [];
                    ownersDoTime = [];
                })
        }

        function pesquisar(nomeColab) {
            colaboradorService.buscarColaboradorPorNome(nomeColab)
            .then(function (response) {
                $scope.pesquisa = response.data;
                console.log($scope.pesquisa);
            })
        }
        function pesquisarOwner(owner) {
            colaboradorService.buscarColaboradorPorNome(owner)
            .then(function (response) {
                $scope.pesquisaOwner = response.data;
                console.log($scope.pesquisaOwner);
            })
        }
        var membrosDoTime = [];
        $scope.adicionarMembros = function (membros) {
                membrosDoTime.push(membros.id);
           $scope.pesquisa = {};
            console.log("membros",membrosDoTime);
        }

        var ownersDoTime = [];
        $scope.adicionarOwner = function (owners) {
                ownersDoTime.push(owners.id);
                $scope.pesquisa = {};
            console.log("owners",ownersDoTime);
        }

        function clicouEditarTime(time) {
            $scope.editarTime = true;
            console.log(time);
            $scope.time = time;
            $scope.membrosTime = [];
            $scope.ownersTime = [];
           
            timeColaboradorService.procurarColaboradorTime(time)
            .then(function (response) {
                var colabs = response.data;
                 console.log(colabs);
                colabs.forEach(function(colab) {
                    if(colab.tipo === "M"){
                        $scope.membrosTime.push(colab);
                        membrosDoTime.push(colab.idColaborador.id)
                    }
                    else if(colab.tipo === "O"){
                        $scope.ownersTime.push(colab);
                        ownersDoTime.push(colab.idColaborador.id)
                    }
                }, this);
                console.log($scope.membrosTime);
            })
        }

        function atualizarTime() {
            timesService.atualizarTimes($scope.time)
                .then(function () {
                    toastr.success('Time atualizado');
                    $scope.editarTime = false;
                }, function () {
                    toastr.error('Ops... Algo deu errado');
                })
        }

    });