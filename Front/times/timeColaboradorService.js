angular.module('app')
    .factory('timeColaboradorService', function ($http) {

        let urlBase = 'http://localhost:9090/times-colaboradores/';

        function procurarColaboradorTime(time){
            return $http({
                url:urlBase + time.id,
                method: 'GET'                
            })
        }

        function procurarColaboradorTimeId(id){
            return $http({
                url:urlBase + id,
                method: 'GET'                
            })
        }

        function colaboradorEhOwner() {
            return $http({
                url:urlBase + 'owner/verificar',
                method: 'GET'                
            })
        }

        return {
            procurarColaboradorTime: procurarColaboradorTime,
            procurarColaboradorTimeId : procurarColaboradorTimeId,
            colaboradorEhOwner : colaboradorEhOwner
        }
    });