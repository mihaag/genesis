angular.module('app')
    .controller('adminController', function ($scope, authService, $location, toastr, feitosService, timesService, colaboradorService) {
        $scope.isCollapsed = true;
        $scope.irParaHome = irParaHome;
        $scope.mostrarAdicaoFeito = mostrarAdicaoFeito;
        $scope.criarFeito = criarFeito;
        $scope.clicouEditarFeito = clicouEditarFeito;
        $scope.fecharEditar = fecharEditar;
        $scope.atualizarFeito = atualizarFeito;
        $scope.excluirFeito = excluirFeito;
        $scope.mostrarAdicaoTime = mostrarAdicaoTime;
        $scope.pesquisar = pesquisar;
        $scope.criarTime = criarTime;

        listarFeitos();
        listarTimes();

        function irParaHome() {
            $location.path('/home');
        }

        $scope.clicouTime = false;

        function mostrarAdicaoFeito() {
            $scope.clicouFeito = true;
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
            console.log(feito);
        }

        function clicouEditarFeito(feito) {
            $scope.editarFeito = true;
            console.log(feito);
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
                    console.log($scope.times);
                })
        }

        function mostrarAdicaoTime() {
            $scope.clicouTime = true;
        }

        function criarTime(time) {
            console.log(time);
            time.membros = membrosDoTime;
            time.owners = ownersDoTime;
            console.log(time);
            timesService.criarTimes(time)
                .then(function () {
                    toastr.success('Time cadastrado');
                    $scope.clicouTime = false;
                    listarTimes();
                })
        }

        function pesquisar(nomeColab) {
            colaboradorService.buscarColaboradorPorNome(nomeColab)
            .then(function (response) {
                $scope.pesquisa = response.data;
                console.log($scope.pesquisa);
            })
        }
        var membrosDoTime = [];
        var  podeSerOwner = [];
        $scope.adicionarMembros = function (membros) {
            membros.forEach(function(membro) {
                membrosDoTime.push(membro.id);
                podeSerOwner.push(membro);
            }, this);
            $scope.possivelOwner = podeSerOwner;
            console.log("membros",membrosDoTime);
        }

        var ownersDoTime = [];
        $scope.adicionarOwner = function (owners) {
            owners.forEach(function(owner) {
                ownersDoTime.push(owner);
            }, this);
            console.log("owners",ownersDoTime);
        }

        function clicouEditarTime(time) {
            $scope.editarTime = true;
            console.log(time);
            $scope.time = time;
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