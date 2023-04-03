Insurance Policy REST API using Spring Boot

This is my assignment for the Insure My Team job application. This is a REST API which works with three tables, 
namely client, insurance_policy, and claim. The client and policy tables share a one-to-many relationship while the 
policy and claim share a one-to-one relationship. The API can handle all the CRUD operations mentioned in the assignment,
as well as some additional operations to show the relation between the two tables. The API is set to give correct HTTP response codes, 
and all the exceptions have been handled.

Technology Stack:
This API is built using the following technology stack:
Spring Boot
JPA (Hibernate) 
MySQL

Setting up the API:
To set up and run this API, follow these steps:
Clone the repository to your local machine.
Import the Mysql_data.sql file into your local MySQL server.
Open the application.properties file located in the src/main/resources folder and make necessary changes such as database credentials.
Run the application 

API Documentation
I have generated API documentation using Swagger in PDF format, which can be found in the repository.

Testing the API
To test the API, import the MySQL data in MySQL and make necessary changes in the application.properties file. After that,
use Postman or any other REST client to test the API endpoints.

API Endpoints
The following are the API endpoints available:

Clients:
* GET /api/clients: Fetch all clients.
*  GET /api/clients/{id}: Fetch a specific client by ID.
*  POST /api/clients: Create a new client.
*  PUT /api/clients/{id}: Update a client's information.
*  DELETE /api/clients/{id}: Delete a client.
*  GET /api/clients/{id}/policy-count: Fetch the total number of policies holded by a client by client ID

b. Insurance Policies:
* GET /api/policies: Fetch all insurance policies.
* GET /api/policies/{id}: Fetch a specific insurance policy by ID.
* POST /api/policies: Create a new insurance policy.
* PUT /api/policies/{id}: Update an insurance policy.
* DELETE /api/policies/{id}: Delete an insurance policy.
* GET /api/policies/{id}/claim-data: Fetch the information of claim from the policy ID (Policy number)

c. Claims:
* GET /api/claims: Fetch all claims.
* GET /api/claims/{id}: Fetch a specific claim by ID.
* POST /api/claims: Create a new claim.
* PUT /api/claims/{id}: Update a claim's information.
* DELETE /api/claims/{id}: Delete a claim


Conclusion
This REST API is designed to handle all the CRUD operations mentioned in the assignment, as well as some additional operations to show the relationship between the tables. It is built using Spring Boot and JPA with MySQL as the database server. Please refer to the API documentation and the endpoints provided for further information on how to use the API.
