'use strict';

/**
 * @ngdoc function
 * @name clientAjrtestApp.controller:ListContactsCtrl
 * @description
 * # ListContactsCtrl
 * Controller of the clientAjrtestApp. List existing contacts paginated
 */
angular.module('clientAjrtestApp')
  .controller('ListContactsCtrl', function ($scope, ContactsService, $log) {
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

    $scope.dtpicker = {
      opened: false
    };

    $scope.opendtpicker = function() {
      $scope.dtpicker.opened = true;
    };

    $scope.save = function() {
      ContactsService.save($scope.contact, function() {
        $log.debug('Data saved');
      }, function (error) {
        $log.debug('Error on save');
      });
    };

    $scope.select = function(index){
      $scope.indexselected = index;
    }

    $scope.delete = function() {
      var index = $scope.indexselected;
      ContactsService.delete({id: $scope.contacts[index].id}, function() {
        $scope.contacts.splice(index,1);
      }, function (error) {
        $log.debug('Error on save');
      });
    };
  });
