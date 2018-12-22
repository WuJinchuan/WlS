angular.module(
  'app'
).controller('core.SearchResultController', ['$scope', '$rootScope', '$http', 'restService', '$cookies', '$state', function ($scope, $rootScope, $http, restService, $cookies, $state) {
  let vm = $scope

  vm.goToCompanyDetail = (companyId) => {
    $state.go('companyDetail', {id: companyId})
  }

  const init = () => {
    if ($cookies.get('searchResult') == undefined &&  $cookies.get('searchParams') == undefined) {
      $state.go('searchRoute')
    }

    $cookies.remove('searchResult')
    $cookies.remove('searchParams')

    vm.searchResult = $cookies.get('searchResult');
    vm.searchParams = $cookies.get('searchParams');

  }

  init()
}])