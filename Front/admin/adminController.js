angular.module('app')
    .controller('adminController', function ($scope, authService, $location, toastr) {
      $scope.isCollapsed = true;
      $scope.irParaHome = irParaHome;

      function irParaHome() {
          $location.path('/home');
      }
});