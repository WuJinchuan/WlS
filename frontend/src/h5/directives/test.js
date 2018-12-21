module.exports = angular.module('app').directive("test", function() {
return {
    restrict : "AE",
    template : "<h1>自定义指令!</h1>"
};
});