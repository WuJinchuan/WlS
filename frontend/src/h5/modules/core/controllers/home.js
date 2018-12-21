angular.module(
  'app'
).controller('core.HomeController', ['$scope', '$rootScope', '$http', 'restService', '$cookies', '$stateParams', function ($scope, $rootScope, $http, restService, $cookies, $stateParams) {
  let vm = $scope

  const init = () => {
    console.log($stateParams.id)
    vm.media= [
      {
        url: '../../images/aa.jpg'
      },
      {
        url: '../../images/bb.jpg'
      }
    ]
    
    restService.http({
      url: '/findAllRegion',
      method: 'GET',
      params: {}
    }).then((resp) => {
      if (resp.data && resp.data.statusCode == 200) {
        $rootScope.user = resp.data.data
        $cookies.putObject('seller', resp.data.data.seller)
        console.log(resp.data.data)
      }
    })
  }

  init()
}])