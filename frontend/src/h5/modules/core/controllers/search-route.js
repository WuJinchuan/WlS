angular.module(
    'app'
  ).controller('core.SearchRouteController', ['$scope', '$rootScope', '$http', 'restService', '$cookies', '$stateParams', '$timeout', function ($scope, $rootScope, $http, restService, $cookies, $stateParams, $timeout) {
    $timeout(() => {
      swiper = new Swiper('.search-filter-container', {
        //direction: 'horizontal',
        //observer: true,
        //observerParents: true,
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
  }])