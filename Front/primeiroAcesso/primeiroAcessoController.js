angular.module('app')
    .controller('primeiroAcessoController', function ($scope, authService, $location, toastr, priemiroAcessoService) {
        $scope.mostrarSenha = mostrarSenha;
        $scope.acessar = acessar;
        $scope.tipo = "password";
        buscarUsuarioPrimeiroAcesso();

        //nao deixar mostrar a senha se não tiver senha
        function mostrarSenha() {
            $scope.tipo = $scope.tipo === "password" ? "text" : "password";
        }

        function acessar() {
            /*pegar service que da put no usuario*/
            primeiroAcessoService.acessoUsuario(user.senha)
                .then(function () {
                    toastr.succes('Bem vindo ao Gênesis CWI!');
                    $location.path('/home');
                })
            toastr.success('Bem vindo ao Gênesis CWI');
            $location.path('/home');
        }

        //efetua busca de usuario no back ao carregar a pagina
        function buscarUsuarioPrimeiroAcesso() {
            let email = $location.search().u;
            console.log(email);
            priemiroAcessoService.buscarUsuarioPorEmailCriptografado(email).then(function (response) {
                $scope.usuario = response.data;
            })
        }

        // metodo para cadastrar nova senha ao usuario passando a nova senha
        function cadastrarSenha(senha) {
            let dados = {senha:senha,email:$location.search().email};
            debugger;
            priemiroAcessoService.cadastrarNovaSenha(dados).then(function(response){
                toastr.succes("Senha cadastrada com sucesso","Cadastro Senha");
            })
         }
    });