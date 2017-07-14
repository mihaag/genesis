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
                templateUrl: 'admin/admin.html',
                resolve: {
                    autenticado: function (authService) {
                        return authService.isAutenticadoPromise();
                    }
                }
            })
            .when('/feito/editar/:id', {
                controller: 'feitosEditarController',
                templateUrl: 'feitos/editarFeito.html',
                resolve: {
                    autenticado: function (authService) {
                        return authService.isAutenticadoPromise();
                    }
                }
            })
            .when('/feito/listar', {
                controller: 'feitosListarController',
                templateUrl: 'feitos/listarFeitos.html',
                resolve: {
                    autenticado: function (authService) {
                        return authService.isAutenticadoPromise();
                    }
                }
            })
            .when('/feito/criar', {
                controller: 'feitosController',
                templateUrl: 'feitos/criarFeito.html',
                resolve: {
                    autenticado: function (authService) {
                        return authService.isAutenticadoPromise();
                    }
                }
            })
            .when('/time/criar', {
                controller: 'criacaoTimeController',
                templateUrl: 'times/criarTime.html',
                resolve: {
                    autenticado: function (authService) {
                        return authService.isAutenticadoPromise();
                    }
                }
            })
            .when('/time/editar/:id', {
                controller: 'edicaoTimeController',
                templateUrl: 'times/editarTime.html',
                resolve: {
                    autenticado: function (authService) {
                        return authService.isAutenticadoPromise();
                    }
                }
            })
            .when('/colaborador/criar',{
                controller : 'colaboradorController',
                templateUrl: 'colaborador/criarColab.html',
                resolve: {
                    autenticado: function (authService) {
                        return authService.isAutenticadoPromise();
                    }
                }
            })
            .when('/colaborador/listar',{
                controller : 'colaboradorListarController',
                templateUrl: 'colaborador/listarColab.html',
                resolve: {
                    autenticado: function (authService) {
                        return authService.isAutenticadoPromise();
                    }
                }
            })
            .when('/colaborador/editar/:id',{
                controller : 'colaboradorEditarController',
                templateUrl: 'colaborador/editarColab.html',
                resolve: {
                    autenticado: function (authService) {
                        return authService.isAutenticadoPromise();
                    }
                }
            })
            .when('/perfil/:id',{
                controller : 'perfilController',
                templateUrl: 'perfil/perfil.html'
            })
            .when('/perfil/editar/:id',{
                controller : 'perfilEditarController',
                templateUrl: 'perfil/perfilEditar.html',
                resolve: {
                    autenticado: function (authService) {
                        return authService.isAutenticadoPromise();
                    }
                }
            })
            .when('/time/listar',{
                controller : 'listarTimeController',
                templateUrl: 'times/listarTimes.html',
                resolve: {
                    autenticado: function (authService) {
                        return authService.isAutenticadoPromise();
                    }
                }
            })
             .when('/time/visualizar/:id',{
                controller : 'timeController',
               templateUrl: 'times/time.html'
             })
            .when('/colaborador/vincular-feito/:id',{
               controller : 'colaboradorFeitoController',
               templateUrl: 'colaborador/colaboradorFeito.html',
               resolve: {
                    autenticado: function (authService) {
                        return authService.isAutenticadoPromise();
                    }
                }
             })
            .when('/pesquisa',{
                controller : 'pesquisaController',
               templateUrl: 'pesquisa/pesquisa.html'
             })
            .otherwise('/home');
    });
    