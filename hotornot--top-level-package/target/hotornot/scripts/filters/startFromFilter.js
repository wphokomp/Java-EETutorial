'use strict';

angular.module('hotornot--top-level-package').filter('startFrom', function() {
    return function(input, start) {
        start = +start; //parse to int
        return input.slice(start);
    };
});