angular.module('app', ['ngRoute', 'auth', 'toastr','ui.bootstrap',
        'ngAnimate',
        'ngStorage',]);

// Configurações utilizadas pelo módulo de autenticação (authService)
//angular.module('app').constant('authConfig', {

    // Obrigatória - URL da API que retorna o usuário
   // urlUsuario: 'http://localhost:9090/api/usuario',

    // Obrigatória - URL da aplicação que possui o formulário de login
   // urlLogin: '/login',

    // Opcional - URL da aplicação para onde será redirecionado (se for informado) após o LOGIN com sucesso
   // urlPrivado: '/home',

    // Opcional - URL da aplicação para onde será redirecionado (se for informado) após o LOGOUT
   // urlLogout: '/login'
//});