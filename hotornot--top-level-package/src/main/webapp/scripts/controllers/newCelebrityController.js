
angular.module('hotornot--top-level-package').controller('NewCelebrityController', function ($scope, $location, locationParser, flash, CelebrityResource ) {
    $scope.disabled = false;
    $scope.$location = $location;
    $scope.celebrity = $scope.celebrity || {};
    
    $scope.genderList = [
        "Male",
        "Female"
    ];
    

    $scope.save = function() {
        var successCallback = function(data,responseHeaders){
            var id = locationParser(responseHeaders);
            flash.setMessage({'type':'success','text':'The celebrity was created successfully.'});
            $location.path('/Celebrities');
        };
        var errorCallback = function(response) {
            if(response && response.data) {
                flash.setMessage({'type': 'error', 'text': response.data.message || response.data}, true);
            } else {
                flash.setMessage({'type': 'error', 'text': 'Something broke. Retry, or cancel and start afresh.'}, true);
            }
        };
        CelebrityResource.save($scope.celebrity, successCallback, errorCallback);
    };
    
    $scope.cancel = function() {
        $location.path("/Celebrities");
    };
});