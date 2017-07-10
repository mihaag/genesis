angular.module('app')
  .controller('timeController', function ($scope, authService, $location, toastr) {
    $scope.user = {"nome": "Alana Lange Weiss"};

    $scope.status = {
    isopen: false
  };

  });