# Spring Boot Study Project

This is a study project showcasing the use of Spring Boot to create a simple user management API.

## Prerequisites

Before getting started, make sure you have met the following requirements:

- **Java** (version 17)
- [Spring Boot](https://spring.io/projects/spring-boot) (version 3.1.4)

## Usage

### HTTP Calls

- **GET - List all users:**

  ```http
  GET http://localhost:8080/users
Description: Retrieves a list of all users using a DTO.

- **GET - Get a user by ID:**

  ```http
  GET http://localhost:8080/users/{id}
Description: Retrieves a specific user based on the provided ID.

- **POST - Create a new user:**

  ```http
  POST http://localhost:8080/users
Description: Creates a new user with the data provided in the request body using a DTO.

- **PUT - Update a user by ID:**

  ```http
  PUT http://localhost:8080/users/{id}
Description: Updates an existing user based on the provided ID with the data provided in the request body using a DTO.

- **DELETE - Delete a user by ID:**

  ```http
  DELETE http://localhost:8080/users/{id}
Description: Deletes a user based on the provided ID.

## Contact

If you have any questions or suggestions, please feel free to get in touch:

- Name: Frederico Dezorzi
- Email: fred.dezorzi@gmail.com
- LinkedIn: [Frederico Dezorzi](https://www.linkedin.com/in/frederico-dezorzi-529518182/)




