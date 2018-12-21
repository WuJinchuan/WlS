angular.module(
    'app'
  ).controller('core.CompanyDetailController', ['$scope', '$rootScope', '$http', 'restService', '$cookies', '$stateParams', function ($scope, $rootScope, $http, restService, $cookies, $stateParams) {
    let vm = $scope
    vm.showShippingDetail = false;

    vm.clickShippingDetail = (showDetail) => {
      vm.showShippingDetail = !showDetail;
      $('.shipping-detail').slideToggle();
    }
  }])