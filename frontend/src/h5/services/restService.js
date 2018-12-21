const config = require('../config.js')

angular.module(
    'app'
  ).factory('restService', ['$http', ($http) => {
    const obj = {}
  
    obj.http = (httpConfig) => {
      let url = config.domain.api
      if (url.endsWith('/')) {
        url = url.substring(0, url.length - 1)
      }
      if (!httpConfig.url.startsWith('/')) {
        url += '/'
      }
      url += httpConfig.url
  
      httpConfig.url = url
  
      return $http(httpConfig)
    }
  
    return obj
  }])