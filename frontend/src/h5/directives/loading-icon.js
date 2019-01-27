module.exports = angular.module('app').directive('loadingIcon', [
  '$state',
  ($state) => {
    return {
      restrict: 'E',
      scope: {
        showLoadingIcon: '=',
        percent: '=',
      },
      replace: true,
      template: require('./partials/loading-icon.html'),
      link: (scope, elem, attrs) => {

      }
    }
  }
])

require('./styles/loading-icon.scss')