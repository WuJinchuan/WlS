const config = require('../config.js')

angular.module(
  'app'
).factory('urlService', () => {
  const obj = {}

  obj.getUrl = (url) => {
    return `${config.urlPrefix}/${url}`
  }

  return obj
})