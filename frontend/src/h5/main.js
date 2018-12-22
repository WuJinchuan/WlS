import jquery from 'jquery'
import angular from 'angular'
import uiRouter from 'angular-ui-router'
import angularCookies from 'angular-cookies'
import 'bootstrap/dist/css/bootstrap.css'
import 'bootstrap/dist/css/bootstrap.min.css'
import './vendors/swiper/swiper.min.css'
import swiper from './vendors/swiper/swiper.min.js'

require('lib-flexible')

const config = require('./config.js')

window.$ = jquery
window.config = config
window.Swiper = swiper

const app = angular.module('app', [uiRouter, angularCookies])


app.config([
  '$stateProvider',
  '$urlRouterProvider',
  '$locationProvider',
  '$httpProvider',
  (
    $stateProvider,
    $urlRouterProvider,
    $locationProvider,
    $httpProvider
  ) => {
    $locationProvider.html5Mode({enabled: true, requireBase: false})

    $urlRouterProvider.when(config.urlPrefix, `${config.urlPrefix}${config.homePage}`)
      .when(`${config.urlPrefix}/`, `${config.urlPrefix}${config.homePage}`)
      .when(`${config.urlPrefix}/index.html`, `${config.urlPrefix}${config.homePage}`)

    // 404
    $urlRouterProvider.otherwise(`${config.urlPrefix}${config.forbiddenPage}`)

    // loads modules/xxx/config.js
    let configs = (r => r.keys().map(key => r(key)))(require.context('./modules/', true, /config\.js$/))

    configs.forEach((moduleCfg) => {
      let moduleName = moduleCfg.name
      let titles = moduleCfg.titles
      let needLoginMap = moduleCfg.needLogin
      let urlMap = {}

      for (let key in moduleCfg.states) {
        let state = moduleCfg.states[key]

        // setups routers
        let subStates = []
        let ctrlPrefixes = [moduleName]
        let ctrlName = ''
        let ctrlAs = ''
        let url = config.urlPrefix
        let stateName = `${moduleName}-${key}`
        let title = titles[key] ? titles[key] : '全网物流'
        let templateUrl = `./${moduleName}/partials`
        let needLogin = !!needLoginMap[key]

        if (moduleName == 'core') {
          stateName = key
        } else {
          url += `/${moduleName}`
        }

        if (/(\(([-\w]+)\)?|(\{\w+\})|\w+)/g.test(state)) {
          state.match(/(\(([-\w]+)\)?|(\{\w+\})|\w+)/g).forEach((roughSubState) => {
            let match = /^\(?([-\w]+)\)?$/.exec(roughSubState)
            let subState = match ? match[1] : roughSubState

            subStates.push(subState)
          })
        } else {
          subStates.push(state)
        }

        subStates.forEach((subState) => {
          let match = /{(\w+)}/.exec(subState)

          if (match) {
            url += `/:${match[1]}`
          } else {
            ctrlName = subState
            url += `/${subState}`

            templateUrl += `/${subState}`

            let ctrlPrefix = ''
            subState.split('-').forEach((word) => {
              ctrlPrefix += word.charAt(0).toUpperCase() + word.substring(1)
            })
            ctrlPrefix = ctrlPrefix.charAt(0).toLowerCase() + ctrlPrefix.substring(1)

            ctrlPrefixes.push(ctrlPrefix)
          }
        })

        if (key.indexOf('.') > -1) {
          key.split('.').slice(0, -1).forEach((subKey) => {
            let subUrl = urlMap[subKey]
            if (subUrl && url.startsWith(subUrl)) {
              url = url.substring(subUrl.length)
            }
          })
        }

        ctrlPrefixes.pop()

        let ctrlNameHump = ''
        ctrlName.split('-').forEach((word) => {
          ctrlNameHump += word.charAt(0).toUpperCase() + word.substring(1)
        })
        ctrlAs = `${ctrlNameHump.charAt(0).toLowerCase()}${ctrlNameHump.substring(1)}`
        ctrlName = `${ctrlNameHump}Controller`

        let ctrl = ctrlPrefixes.slice(0, ctrlPrefixes.length).join('.') + `.${ctrlName}`

        templateUrl += '.html'

        $stateProvider.state(stateName, {
          url: url,
          title: title,
          controller: ctrl,
          controllerAs: ctrlAs,
          template: partialsMap[templateUrl],
          needLogin: needLogin
        })

        urlMap[key] = url
      }
    })
  }
]).run([
  '$state',
  '$rootScope',
  '$location',
  '$window',
  '$timeout',
  '$transitions',
  'urlService',
  '$cookies',
  (
    $state,
    $rootScope,
    $location,
    $window,
    $timeout,
    $transitions,
    urlService,
    $cookies
  ) => {
    const rvm = $rootScope

    rvm.$on('$locationChangeStart', (event, next) => {
      let url = $location.url()

      if (!url.startsWith(config.urlPrefix)) {
        $location.url(urlService.getUrl(url))
      }
    })

    $transitions.onStart({}, (transition) => {
      let title = transition.to().title
      if (title) {
        $window.document.title = title
      }
    })
  }
]);

// loads modules/xxx/controllers/xxx.js
(r => r.keys().map(key => r(key)))(require.context("./modules/", true, /controllers(\/[-\w]+)*\/[-\w]+\.js$/));

// loads modules/xxx/styles/xxx.js
(r => r.keys().map(key => r(key)))(require.context("./modules/", true, /styles(\/[-\w]+)*\/[-\w]+\.(css|scss|sass)$/));

// loads modules/xxx/partials/xxx.html
let partialsMap = ((r) => {
  let map = {}
  r.keys().forEach((key) => {
    map[key] = r(key)
  })

  return map
})(require.context("./modules/", true, /partials(\/[-\w]+)*\/[-\w]+\.html$/));

// loads directives/xxx.js
(r => r.keys().map(key => r(key)))(require.context("./directives/", true, /([-\w]+\/)*[-\w]+\.js$/));

// loads services/xxx.js
(r => r.keys().map(key => r(key)))(require.context("./services/", true, /([-\w]+\/)*[-\w]+\.js$/));

// loads styles/xxx.scss
(r => r.keys().map(key => r(key)))(require.context("./styles/", true, /([-\w]+\/)*[-\w]+\.(css|scss|sass)$/));
