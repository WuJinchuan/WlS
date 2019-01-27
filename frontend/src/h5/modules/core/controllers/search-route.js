angular.module(
    'app'
  ).controller('core.SearchRouteController', ['$scope', '$rootScope', '$http', 'restService', '$cookies', '$stateParams', '$timeout', '$state', function ($scope, $rootScope, $http, restService, $cookies, $stateParams, $timeout, $state) {
    let vm = $scope;
    const SEARCH_BY_KEYWORD = 0;
    const SEARCH_BY_POSITION = 1;
    let pageNum = 0;
    let pageSize = 20;
    let swiper;

    vm.showLoadingIcon = false;
    vm.searchParams = {
      keyword: '',
      arCode:'',
      arName: '',
      region: []      
    };

    vm.regionPickerOptions = {
      mustSelectAll: false,
      isShowPicker: false,
      outsidePickedRegionName: '未选定地区',
    }

    vm.triggerRegionPicker = () => {
      vm.regionPickerOptions.isShowPicker = true
    }

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
        let selectedRegions = vm.searchParams.region;
        if(selectedRegions.length > 0) {
          vm.searchParams.arCode = selectedRegions[selectedRegions.length - 1].rgid
        }
        params = {
          arCode: vm.searchParams.arCode
        }
      }

      vm.showLoadingIcon = true;
      restService.http({
        url: `/search/${pageNum}/${pageSize}/company`,
        method: 'GET',
        params: params
      }).then((resp) => {
        if (resp.status == 200) {
          $rootScope.searchResult = resp.data.result
          $rootScope.searchParams = params
        }
        $state.go('searchResult')
        vm.showLoadingIcon = false;
      })
    }

    const getADInfo = () => {
      restService.http({
        url: '/getAllAd',
        method: 'GET',
        params: {}
      }).then((resp) => {
        if (resp.status == 200) {
          $scope.adResult = resp.data.result
        }
      })
    }

    const init = () => {
      getADInfo()
    }

    init()
  }])