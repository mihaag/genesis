angular.module('app')

    .factory('colaboradorService', function ($http) {
        let urlBase = 'http://localhost:9090/colaboradores/';

        function cadastrarColcaborador(colaborador) {
            return $http({
                url: urlBase,
                method: 'POST',
                data: colaborador
            });
        }

        function atualizarColaborador(colaborador) {          
            return $http({
                url: urlBase,
                method: 'PUT',
                data: colaborador
            })
        }

        function procurarColaborador(nome){
            return $http({
                url:`${urlBase}procurar/${nome}`,
                method: 'GET'                
            })
        }

        function buscarTodosOsColaboradores() {
            return $http({
                url: urlBase,
                method: 'GET'                
            })
        }

        function buscarDadosColaborador(id) {
            return $http({
                url: urlBase + 'perfil/' + id,
                method: 'GET'                
            })
        }

        return {
            cadastrarColcaborador: cadastrarColcaborador,
            atualizarColaborador : atualizarColaborador,
            buscarColaboradorPorNome : procurarColaborador,
            buscarTodosOsColaboradores : buscarTodosOsColaboradores,
            buscarDadosColaborador : buscarDadosColaborador
        }

    })