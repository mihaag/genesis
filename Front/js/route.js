angular.module('app')
    .config(function ($routeProvider) {
        $routeProvider
        .when('/perfil', {
            controller: 'loginController',
            templateUrl: 'login/solicitacao.html'
        })
        .otherwise('/perfil');
});