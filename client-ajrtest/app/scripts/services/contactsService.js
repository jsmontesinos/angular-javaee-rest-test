'use strict';

/**
 * @ngdoc service
 * @name clientAjrtestApp.service.contactsService
 * @description
 * # contactsService
 * Factory in the clientAjrtestApp. The service calls backend api to make CRUD operations.
 */
angular.module('clientAjrtestApp')
  .factory('ContactsService', function ($resource) {
	    return $resource('/angular-java-rest-test-0.0.1-SNAPSHOT/api/contacts/:id', { id: '@_id' });
  });
