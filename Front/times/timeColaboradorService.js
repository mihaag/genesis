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

        return {
            procurarColaboradorTime: procurarColaboradorTime,
            procurarColaboradorTimeId : procurarColaboradorTimeId
        }
    });