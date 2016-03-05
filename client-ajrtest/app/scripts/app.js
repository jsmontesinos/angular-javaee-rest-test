'use strict';

/**
 * @ngdoc overview
 * @name clientAjrtestApp
 * @description
 * # clientAjrtestApp
 *
 * Main module of the application.
 */
angular
  .module('clientAjrtestApp', [
    'ui.bootstrap',
    'ngResource',
    'ngRoute',
    'ngSanitize'
  ])
  .config(function ($routeProvider) {
    $routeProvider
      .when('/', {
        templateUrl: 'views/list-contacts.html',
        controller: 'ListContactsCtrl',
        controllerAs: 'listContacts'
      })
      .when('/about', {
        templateUrl: 'views/about.html',
        controller: 'AboutCtrl',
        controllerAs: 'about'
      })
      .when('/create-contact', {
        templateUrl: 'views/create-contact.html',
        controller: 'CreateContactCtrl',
        controllerAs: 'createContact'
      })
      .otherwise({
        redirectTo: '/'
      });
  });
