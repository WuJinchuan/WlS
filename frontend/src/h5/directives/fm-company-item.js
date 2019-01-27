module.exports = angular.module('app').directive('fmCompanyItem', [
    '$state',
    '$http',
    'restService',
    ($state, $http, restService) => {

      return {
        restrict: 'E',
        scope: {
          companyDetail: '=company',
        },
        replace: true,
        template: require('./partials/fm-company-item.html'),
        link: (scope, elem, attrs) => {
          let vm = scope
          const NON_STOP_CODE = 1;

          vm.isNotEmpty = (key) => {
            return !(key == null || key == undefined || angular.equals("", key.trim()));
          }
      
          const init = () => {

            vm.nonStopPlaces = '';
            vm.transferPlaces = '';
            angular.forEach(vm.companyDetail.mathcerList, (matcher) => {
              let place = matcher.arName;
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
      
          init();

          scope.goToCompanyDetail = (companyId) => {
            $state.go('companyDetail', {id: companyId})
          }
        }
      }
    }
  ])
  
  require('./styles/fm-company-item.scss')