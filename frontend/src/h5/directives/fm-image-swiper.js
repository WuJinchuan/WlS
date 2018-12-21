module.exports = angular.module('app').directive('fmImageSwiper', [
  '$location',
  '$timeout',
  '$rootScope',
  ($location, $timeout, $rootScope) => {

    return {
      restrict: 'E',
      scope: {
        media: '=',
        paginationType: '@',
      },
      replace: true,
      template: require('./partials/fm-image-swiper.html'),
      link: (scope, elem, attrs) => {
        let swiper = null

        $timeout(() => {
          swiper = new Swiper('.fm-image-swiper', {
            direction: 'horizontal',
            pagination: {
              el: '.fm-image-swiper .swiper-pagination',
              type: scope.paginationType ? scope.paginationType : 'bullets'
            },
            observer: true,
            observerParents: true
          })
        }, 100)

        scope.click = (medium) => {
          if (!medium.link) {
            return
          }
          if (medium.link == '/view/view-images') {
            let images = scope.media;
            let index = 0;
            for (let i in images) {
              if (medium.url == images[i].url) {
                index = i;
                break;
              }
            }
            $rootScope.goodsDetailImages = {
              index: index,
              images: scope.media,
            }
            $location.url(medium.link)
            return
          }
          if (!medium.type || medium.type.toLowerCase() == 'image') {
            if (/:\/\//.test(medium.link)) {
              window.location.href = medium.link
            } else {
              $location.url(medium.link)
            }
          }
        }

        scope.isImage = (type) => {
          return type && type.toLowerCase().indexOf('image') != -1
        }
      }
    }
  }
])

require('./styles/fm-image-swiper.scss')