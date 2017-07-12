angular.module('app')
    .config(function ($routeProvider) {
        $routeProvider
            .when('/solicitar', {
                controller: 'loginController',
                templateUrl: 'login/solicitacao.html'
            })
            .when('/login', {
                controller: 'loginController',
                templateUrl: 'login/login.html'
            })
            .when('/primeiroAcesso', {
                controller: 'primeiroAcessoController',
                templateUrl: 'primeiroAcesso/primeiroAcesso.html'
            })
            .when('/home', {
                controller: 'homeController',
                templateUrl: 'home/home.html'
            })
            .when('/admin', {
                controller: 'adminController',
                templateUrl: 'admin/admin.html'
            })
            .when('/feito/editar/:id', {
                controller: 'feitosEditarController',
                templateUrl: 'feitos/editarFeito.html'
            })
            .when('/feito/listar', {
                controller: 'feitosListarController',
                templateUrl: 'feitos/listarFeitos.html'
            })
            .when('/feito/criar', {
                controller: 'feitosController',
                templateUrl: 'feitos/criarFeito.html'
            })
            .when('/time/criar', {
                controller: 'criacaoTimeController',
                templateUrl: 'times/criarTime.html'
            })
            .when('/time/editar/:id', {
                controller: 'edicaoTimeController',
                templateUrl: 'times/editarTime.html'
            })
            .when('/colaborador/criar',{
                controller : 'colaboradorController',
                templateUrl: 'colaborador/criarColab.html'
            })
            .when('/colaborador/listar',{
                controller : 'colaboradorListarController',
                templateUrl: 'colaborador/listarColab.html'
            })
            .when('/colaborador/editar/:id',{
                controller : 'colaboradorEditarController',
                templateUrl: 'colaborador/editarColab.html'
            })
            .when('/perfil/:id',{
                controller : 'perfilController',
                templateUrl: 'perfil/perfil.html'
            })
            .when('/time/listar',{
                controller : 'listarTimeController',
                templateUrl: 'times/listarTimes.html'
            })
             .when('/time/visualizar/:id',{
                controller : 'timeController',
               templateUrl: 'times/time.html'
             })
            .when('/colaborador/vincular-feito/:id',{
                controller : 'colaboradorFeitoController',
               templateUrl: 'colaborador/colaboradorFeito.html'
             })
            .otherwise('/login');
    });
    