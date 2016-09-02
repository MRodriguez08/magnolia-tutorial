var searchApp = angular.module("searchApp", [ "ngResource" ]);
searchApp.controller("searchController", [
    "$scope",
    "$resource",
    function($scope, $resource) {
      $scope.query = "";
      $scope.resultItems = [];

      var SearchEndpoint = $resource(
          '/magnolia-tutorial-webapp/.rest/search/v1', {
            query : '@query'
          });

      $scope.search = function() {
        SearchEndpoint.query({
          query : $scope.query
        }, function(entries) {
          $scope.resultItems = entries;
        });
      }
      $scope.search();
    } ]);