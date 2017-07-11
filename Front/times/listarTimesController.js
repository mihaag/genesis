angular.module('app')
    .controller('listarTimesController', function ($scope, authService, $location, toastr, timesService) {
        listarTimes();

        function listarTimes() {
            timesService.buscarTimesComFoto().then(function (response) {
                $scope.times = response.data;
                console.log($scope.times);
            });
        }
});