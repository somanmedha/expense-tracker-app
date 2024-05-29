# Expense Tracker Application

This repository contains the second project in the Spring Boot Revision Series, focusing on building a basic expense tracker application. The primary goal of this project is to learn how to create API documentation using Swagger UI.

## 1. Overview
The Expense Tracker Application is a straightforward and efficient Spring Boot project designed to handle basic expense tracking operations. It includes functionalities such as category management, expense management, and detailed API documentation. This project demonstrates the use of Spring Boot's features for building robust and maintainable applications.

## 2. Features
  #### 2.1 Category Management: Create and manage expense categories.
  #### 2.2 Expense Management: Add and manage expenses.
  #### 2.3 Exception Handling: Implement robust error handling mechanisms to manage exceptions gracefully.
  #### 2.4 DTOs and Mappers: Utilize Data Transfer Objects (DTOs) and mappers for efficient data handling.
  #### 2.5 API Documentation: Detailed API documentation is provided using Swagger UI and SpringDoc OpenAPI to help users understand and use the available endpoints.
**Note**
Security has not been implemented in this project for the REST APIs. The focus is on understanding and revising Spring Boot fundamentals.

## 3. Configuration
 ####  3.1 application.properties: Configuration settings for the application.
  Please note that I've used PostgreSQL with pgAdmin for database management. You can use any database management system, but you will need to make suitable changes in the application.properties file.
 #### 3.2 ORM Mapping: Spring Data JPA is used for ORM mapping.
 #### 3.3 Java Version: Java 17
 #### 3.4 Spring Boot Version: 3.2.5
 #### 3.5 Database: PostgreSQL with pgAdmin. You can use any database management system.

## 4. Build and Dependencies
  4.1 pom.xml: Maven configuration file listing all dependencies and plugins used in the project.

## 5. Getting Started

### 5.1 Prerequisites

####  5.1.1 Java 17+
####  5.1.2 Maven 3.6.3 or higher
####  5.1.3 An IDE such as IntelliJ IDEA or Eclipse
####  5.1.4 PostgreSQL and pgAdmin (or any other preferred database management system)
####  5.1.5 Postman (or any other REST client tool) for testing the APIs

### 5.2 Running the Application

 ####   5.2.1 Clone the repository: 
  ```git clone https://github.com/your-username/expense-tracker-app.git ```
 ####   5.2.2 Navigate to the project directory:
 ```cd expense-tracker-app```
 ####   5.2.3 Build the project using Maven:
``` mvn clean install```
 ####   5.2.4 Run the application:
```mvn spring-boot:run```

## 6. API Endpoints

To use the APIs, you need to run the application and visit `http://localhost:8080/swagger-ui/index.html`.

## 7. Contributing

Contributions are welcome! Please fork the repository and submit a pull request for any enhancements or bug fixes.

