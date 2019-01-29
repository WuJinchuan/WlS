angular.module(
    'app'
  ).controller('core.CompanyDetailController', ['$scope', '$rootScope', '$http', 'restService', '$cookies', '$stateParams', function ($scope, $rootScope, $http, restService, $cookies, $stateParams) {
    let vm = $scope
    vm.showShippingDetail = false;
    const NON_STOP_CODE = 1;

    vm.clickShippingDetail = (showDetail) => {
      vm.showShippingDetail = !showDetail;
      $('.shipping-detail').slideToggle();
    }

    vm.isNotEmpty = (key) => {
      return !(key == null || key == undefined || angular.equals("", key.trim()));
    }

    const init = () => {
      restService.http({
        url: '/company/detail',
        method: 'GET',
        params: {coid: $stateParams.id}
      }).then((resp) => {
        if (resp.status == 200) {
          vm.companyDetail = resp.data.result;
          vm.nonStopPlaces = '';
          vm.transferPlaces = '';
          angular.forEach(vm.companyDetail.mathcerList, (matcher) => {
            let place = matcher.arName;
            if (place == null) {
              return;
            }
            let placesArr = place.split("-");
            if (matcher.style == NON_STOP_CODE) {
              if (!vm.isNotEmpty(vm.nonStopPlaces)) {
                vm.nonStopPlaces += placesArr[placesArr.length-1]
              } else {
                vm.nonStopPlaces += ("," +placesArr[placesArr.length-1])
              }
            } else {
              if (!vm.isNotEmpty(vm.transferPlaces)) {
                vm.transferPlaces +=placesArr[placesArr.length-1]
              } else {
                vm.transferPlaces += (", " +placesArr[placesArr.length-1])
              }
            }
          });
        }
      })
    }

    init();
  }])