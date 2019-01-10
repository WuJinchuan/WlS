angular.module(
    'app'
  ).controller('core.SearchRouteController', ['$scope', '$rootScope', '$http', 'restService', '$cookies', '$stateParams', '$timeout', '$state', function ($scope, $rootScope, $http, restService, $cookies, $stateParams, $timeout, $state) {
    let vm = $scope;
    const SEARCH_BY_KEYWORD = 0;
    const SEARCH_BY_POSITION = 1;
    let pageNum = 0;
    let pageSize = 20;
    let swiper;

    vm.searchParams = {
      keyword: '',
      arCode:'',
      arName: ''
    };

    $timeout(() => {
      swiper = new Swiper('.search-filter-container', {
        direction: 'horizontal',
        observer: true,
        observerParents: true,
        effect : 'flip',
        flipEffect: {
          slideShadows : true,
          limitRotation : true,
        },
        pagination : '.swiper-pagination',
        navigation: {
          nextEl: '.swiper-button-next',
          prevEl: '.swiper-button-prev',
        }
      })
    }, 100)

    vm.onSearchAction = () => {
      let params = {}
      if (swiper.activeIndex == SEARCH_BY_KEYWORD) {
        params = {
          keyword: vm.searchParams.keyword
        }
      } else {
        //暂时禁用此功能
        return;

        params = {
          arCode: vm.searchParams.arCode,
          arName: vm.searchParams.arName
        }
      }

      restService.http({
        url: `/search/${pageNum}/${pageSize}/company`,
        method: 'GET',
        params: params
      }).then((resp) => {
        if (resp.status == 200) {
          $cookies.putObject('searchResult', resp.data.result)
          $cookies.putObject('searchParams', params)
          $state.go('searchResult')
        }
      })
    }

    const init = () => {
      //get region
    }

    init()
  }])