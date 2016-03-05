'use strict';

/**
 * @ngdoc function
 * @name clientAjrtestApp.controller:CreateContactCtrl
 * @description
 * # CreateContactCtrl
 * Controller of the clientAjrtestApp. Create or edit a contact
 */
angular.module('clientAjrtestApp')
  .controller('CreateContactCtrl', function($scope, ContactsService, $log) {
    $scope.contact = new ContactsService();

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
  });
