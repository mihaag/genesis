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
                templateUrl: 'feitos/editar.html'
            })
            .when('/feito/criar', {
                controller: 'feitosController',
                templateUrl: 'feitos/criar.html'
            })
            .when('/colaborador',{
                controller : 'colaboradorController',
                templateUrl: 'colaborador/teste.html'
            })
            .when('/colaborador/procurar',{
                controller : 'colaboradorController',
                templateUrl: 'colaborador/teste.html'
            })
            .when('/perfil',{
                controller : 'perfilController',
                templateUrl: 'perfil/perfil.html'
            })
            .when('/time/:id',{
                controller : 'timeController',
                templateUrl: 'times/time.html'
            })
            .otherwise('/login');
    });
    