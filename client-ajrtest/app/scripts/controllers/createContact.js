'use strict';

/**
 * @ngdoc function
 * @name clientAjrtestApp.controller:CreateContactCtrl
 * @description
 * # CreateContactCtrl
 * Controller of the clientAjrtestApp. Create or edit a contact
 */
angular.module('clientAjrtestApp')
  .controller('CreateContactCtrl', function($scope, ContactsService, $log, $location) {
    $scope.contact = new ContactsService();

    $scope.invalidemailmessage = $scope.null;

    $scope.dtpicker = {
      opened: false
    };

    $scope.opendtpicker = function() {
      $scope.dtpicker.opened = true;
    };

    $scope.save = function() {
      ContactsService.save($scope.contact, function() {
        $log.debug('Data saved');
        $location.path('contacts');
      }, function (error) {
        $scope.invalidemailmessage = 'The email is already registered';
      });
    };
  });
