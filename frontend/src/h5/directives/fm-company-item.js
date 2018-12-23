module.exports = angular.module('app').directive('fmCompanyItem', [
    '$state',
    '$http',
    'restService',
    ($state, $http, restService) => {

      return {
        restrict: 'E',
        scope: {
          company: '=',
        },
        replace: true,
        template: require('./partials/fm-company-item.html'),
        link: (scope, elem, attrs) => {
          scope.goToCompanyDetail = (companyId) => {
            $state.go('companyDetail', {id: companyId})
          }
        }
      }
    }
  ])
  
  require('./styles/fm-company-item.scss')