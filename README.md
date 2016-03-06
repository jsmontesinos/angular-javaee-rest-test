# Angular JavaEE Rest Test application

This is an example 3-tier application (front-end, back-end and data layer) build in top of angular with bootstrap in the front-end and javaee tomee web application runing in the server.

The application contains a CRUD view to create, list, edit and delete contacts. Contacts has got 5 fields: First Name, Last Name, Email, Date of Birth and Address.

## Application structure

The application is developed using various tecnologies:

- Angular js: the logic of the front-end application.
- Bootstrap: a set of css an javascript libraries that helps the app looks beauty.
- Java EE: JAX-RS and JPA application in the backend to serve the REST API.
- Postgresql: A database to stock the data

## Compile and run the app

To compile the application we need to run 'grunt build' in the client-ajrtest folder. This result in a new 'dist' folder inside. Then we must run 'mvn package' on the server-ajrtest folder to produce the war. By last, we need to have a postgres database (script to create it is supplied in sql folder) and a Java EE application server to host the war. I have tested it in Apache Tomee server.


