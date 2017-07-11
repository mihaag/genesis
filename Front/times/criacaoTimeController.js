angular.module('app').controller('criacaoTimeController', function ($scope, authService, $location, toastr, $routeParams,
    timesService, colaboradorService) {

    $scope.criarTime = criarTime;
    $scope.pesquisar = pesquisar;
    $scope.adicionarMembros = adicionarMembros;
    $scope.adicionarOwner = adicionarOwner;

    function criarTime(time) {
            time.membros = membrosDoTime;
            time.owners = ownersDoTime;
            time.situacao = "A";    
            timesService.criarTimes(time)
                .then(function () {
                    toastr.success('Time cadastrado');
                    $location.path('/admin');
                })
    };

    function pesquisar(nomeColab) {
        colaboradorService.buscarColaboradorPorNome(nomeColab)
            .then(function (response) {
                $scope.pesquisa = response.data;
            })
    };

    var membrosDoTime = [];
    
    function adicionarMembros(membros) {
        membrosDoTime.push(membros.id);
        $scope.pesquisa = {};
    };

    var ownersDoTime = [];
    
    function adicionarOwner(owners) {
        ownersDoTime.push(owners.id);
        $scope.pesquisa = {};
    };

});