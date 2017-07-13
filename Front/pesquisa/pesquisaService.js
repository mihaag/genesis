angular.module('app')
    .service('pesquisaService', function () {
        var tipoPesquisa = '';
        var termoPesquisa = '';

        return {
            getTipo: function () {
                return tipoPesquisa;
            },
            setPesquisa: function(pesquisa) {
                tipoPesquisa = pesquisa.tipo;
                termoPesquisa = pesquisa.termo;
            },
            getTermo: function () {
                return termoPesquisa;
            }
        };
    });