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
            .otherwise('/login');
    });