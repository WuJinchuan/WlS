angular.module(
  'app'
).controller('core.SearchResultController', ['$scope', '$rootScope', '$http', 'restService', '$cookies', '$state', function ($scope, $rootScope, $http, restService, $cookies, $state) {
  let vm = $scope

  const init = () => {
    if ($rootScope.searchResult != undefined && $rootScope.searchParams != undefined) {
      vm.companyList = $rootScope.searchResult['companyResourceList'];
      vm.searchParams = $rootScope.searchParams;
    }

  }

  vm.goBackSearchPage = () => {
    $state.go('searchRoute');
  }

  init()
}])