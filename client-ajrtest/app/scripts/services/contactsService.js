'use strict';

/**
 * @ngdoc service
 * @name clientAjrtestApp.service.contactsService
 * @description
 * # contactsService
 * Factory in the clientAjrtestApp. The service calls backend api to make CRUD operations.
 */
angular.module('clientAjrtestApp')
  .factory('ContactsService', function($resource) {
    return $resource('/angular-java-rest-test/api/contacts/:id', null, {
      update: {
        method: 'PUT'
      }
    });
  });
