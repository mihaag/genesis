angular.module('app')
    .controller('adminController', function ($scope, authService, $location, toastr) {
      $scope.isCollapsed = true;
});