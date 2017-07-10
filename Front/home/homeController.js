angular.module('app')
    .controller('homeController', function ($scope, authService, $location, toastr) {
        $scope.telaAdmin = telaAdmin;

        function telaAdmin() {
            debugger;
            $location.path('/admin');
        }

        $scope.feitos = [{
                "nome": "tetse",
                "imagem": "http://files.softicons.com/download/web-icons/services-flat-icons-by-jozef-krajcovic/png/512x512/consult.png"
            },
            {
                "nome": "teste 2",
                "imagem": "http://files.softicons.com/download/web-icons/services-flat-icons-by-jozef-krajcovic/png/512x512/consult.png"
            },
            {
                "nome": "tetse 3",
                "imagem": "http://files.softicons.com/download/web-icons/services-flat-icons-by-jozef-krajcovic/png/512x512/consult.png"
            }

        ]

    });