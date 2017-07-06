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
                controller: 'acessoController',
                templateUrl: 'login/acesso.html'
            })
            .otherwise('/login');
    });