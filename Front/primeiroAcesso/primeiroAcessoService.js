angular.module('app')

.factoty('priemiroAcessoService',function($http){
    let urlBase = 'http://localhost:9090/colaboradores/novo-acesso'

    function buscarUsuarioPorEmailCriptografado(email){
        return $http({
            url : urlBase,
            method:"post",
            data:email,
        });
    }

    function cadastrarNovaSenha(emailSenha){
        return $http({
            url:`${urlBase}/nova-senha`,
            method:'POST',
            data:emailSenha
        })
    }

    return{
        buscarUsuarioPorEmailCriptografado,
        cadastrarNovaSenha
    }
})

