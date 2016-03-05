'use strict';

/**
 * @ngdoc function
 * @name clientAjrtestApp.controller:ListContactsCtrl
 * @description
 * # ListContactsCtrl
 * Controller of the clientAjrtestApp. List existing contacts paginated
 */
angular.module('clientAjrtestApp')
  .controller('ListContactsCtrl', function ($scope, ContactsService) {
    $scope.pageSize = 10;
    $scope.currentpage = 1;
    $scope.itemsPerPage = 10;

    function callService() {
      ContactsService.query({
        offset : ($scope.currentpage - 1) * $scope.pageSize,
        limit : $scope.pageSize,
      }, function(response, responseHeaders) {
        $scope.contacts = response;
        $scope.totalItems = responseHeaders('X-Total-Count');
      });
    }

    callService();

    $scope.pageChanged = function() {
      callService();
    };
  });
