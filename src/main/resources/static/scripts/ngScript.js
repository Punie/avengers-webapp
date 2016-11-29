var myApp = angular.module("myApp", ["ngRoute"]);

myApp.config(function($routeProvider) {
    $routeProvider
        .when('/', {
            templateUrl: 'components/main.html'
        })
        .when('/avengers', {
            templateUrl: 'components/avengers.html'
        })
        .when('/agents', {
            templateUrl: 'components/agents.html'
        });
});

myApp.controller('dateController', ['$scope', function($scope) {
    $scope.date = new Date();
}]);

myApp.controller("avengerController", function($scope, $http) {
    initAvengers($scope, $http);
    $scope.avenger = {};
    $scope.removeAvenger = function(id) {
        deleteAvenger(id,$http,$scope);
    };

    $scope.showAvenger = function(id) {
        getAvenger(id, $scope, $http);
    };

    $scope.addAvenger = function() {
        saveAvenger($scope,$http);
    };
});

myApp.controller("agentController", function($scope, $http) {
    initAgents($scope, $http);
    $scope.agent = {};
    $scope.removeAgent = function(id) {
        deleteAgent(id,$http,$scope);
    };

    $scope.showAgent = function(id) {
        getAgent(id, $scope, $http);
    };

    $scope.addAgent = function() {
        saveAgent($scope,$http);
    };
});
