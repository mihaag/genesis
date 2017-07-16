angular.module('app')

    .factory('colaboradorService', function ($http) {
        let urlBase = 'http://localhost:9090/colaboradores/';

        function cadastrarColaborador(colaborador) {
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

        function procurarColaborador(nome) {
            return $http({
                url: `${urlBase}procurar/${nome}`,
                method: 'GET'
            })
        }

        function buscarColaboradorComFiltro(nome) {
            return $http({
                url: `${urlBase}buscarPorNomeComFiltro/${nome}`,
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
        function atualizarColaborardor(colaborador) {
            return $http({
                url: urlBase,
                method: 'PUT',
                data: colaborador
            })
        }

        function atualizarSenha(colaborador) {
            return $http({
                url: urlBase +'/atualizar-senha',
                method: 'PUT',
                data:colaborador                
            })
        }

        return {
            cadastrarColaborador: cadastrarColaborador,
            atualizarColaborador : atualizarColaborador,
            buscarColaboradorPorNome : procurarColaborador,
            buscarTodosOsColaboradores : buscarTodosOsColaboradores,
            buscarDadosColaborador : buscarDadosColaborador,
            atualizarSenha : atualizarSenha,
            buscarColaboradorComFiltro:buscarColaboradorComFiltro
        }

    })