module.exports = angular.module('app').directive('fmRegionPicker', [
  '$state',
  '$http',
  'restService',
  ($state, $http, restService) => {

    return {
      restrict: 'E',
      scope: {
        ngModel: '=ngModel',
        mustSelectAll: '=',
        formatter: '&',
        update: '&',
        isShowPicker: '=',
        outsidePickedRegionName: '='
      },
      replace: true,
      template: require('./partials/fm-region-picker.html'),
      link: (scope, elem, attrs) => {
        scope.regions = []
        scope.pickList = []
        scope.pickedRegions = []
        scope.insidePickedRegionName = '请选择区域'
        scope.outsidePickedRegionName = scope.insidePickedRegionName
        scope.pickingRegionName = '请选择区域'
        scope.isShowPicker = false
        scope.isLoading = false

        scope.finish = () => {
          scope.insidePickedRegionName = scope.pickingRegionName
          scope.outsidePickedRegionName != undefined && (scope.outsidePickedRegionName = scope.insidePickedRegionName)
          scope.ngModel = scope.pickedRegions

          clearPicker()
          scope.isShowPicker = false
        }

        scope.pickRegion = (region) => {
          scope.pickedRegions.push(region)
          scope.pickingRegionName = formatRegions(scope.pickedRegions)

          if (!region.regions || region.regions.length < 1) {
            scope.insidePickedRegionName = scope.pickingRegionName
            scope.outsidePickedRegionName != undefined && (scope.outsidePickedRegionName = scope.insidePickedRegionName)
            scope.ngModel = scope.pickedRegions
            // 当前组件被用到嵌套指令中时必须通过方法向上传值
            if(attrs.update) {
              scope.update()({region: scope.ngModel})
            }

            clearPicker()
            scope.isShowPicker = false
          } else {
            scope.pickList = region.regions
          }
        }

        scope.triggerPicker = () => {
          scope.isShowPicker = true
        }

        scope.cancel = () => {
          clearPicker()
          scope.isShowPicker = false
        }

        const clearPicker = () => {
          scope.pickingRegionName = '请选择区域'
          scope.pickedRegions = []
          scope.pickList = scope.regions
        }

        const formatRegions = (regions) => {
          let regionName = ''
          if (attrs.formatter) {
            regionName = scope.formatter()(regions)
          } else {
            regions.forEach(region => {
              regionName += region.rg_Name
            })
          }

          return regionName
        }

        const loadRegions = () => {
          restService.http({
            url: '/findRegionTree',
            method: 'GET'
          }).then((resp) => {
            scope.regions = resp.data.result.regions
            scope.pickList = scope.regions
          }).catch((resp) => {
            console.log(resp)
          })
        }

        const init = () => {
          loadRegions()
          if (scope.ngModel) {
            scope.pickedRegions = scope.ngModel
            scope.insidePickedRegionName = formatRegions(scope.pickedRegions)
            clearPicker()
          }
        }

        init()
      }
    }
  }
])

require('./styles/fm-region-picker.scss')