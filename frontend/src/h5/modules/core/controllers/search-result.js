angular.module(
  'app'
).controller('core.SearchResultController', ['$scope', '$rootScope', '$http', 'restService', '$cookies', '$state', function ($scope, $rootScope, $http, restService, $cookies, $state) {
  let vm = $scope

  const init = () => {
    if ($cookies.get('searchResult') == undefined && $cookies.get('searchParams') == undefined) {
      $state.go('searchRoute');
      return;
    }

    vm.companyList = $cookies.getObject('searchResult')['companyResourceList'];
    vm.searchParams = $cookies.getObject('searchParams');
    
    $cookies.remove('searchResult')
    $cookies.remove('searchParams')
  }

  init()
}])