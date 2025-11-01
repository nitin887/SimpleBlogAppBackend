# Simple Blog App Backend

A RESTful backend service for a simple blog application built with Spring Boot. This application provides endpoints for creating, reading, updating, and deleting blog posts, with role-based security to manage access.

## Features

- Full CRUD functionality for blog posts.
- Role-based access control (ADMIN, USER).
- Secure endpoints using Spring Security.
- API documentation with Swagger/OpenAPI.
- Database initialization with default roles and an admin user.

## Technologies Used

- **Java 17**: Core programming language.
- **Spring Boot 3.2.5**: Main application framework.
- **Spring Web**: For building RESTful APIs.
- **Spring Data JPA**: For data persistence with a relational database.
- **Spring Security**: For authentication and authorization.
- **MySQL**: Relational database for storing data.
- **Hibernate**: JPA implementation.
- **MapStruct**: For mapping between DTOs and entities.
- **Swagger/OpenAPI**: For API documentation and testing.
- **Maven**: Dependency management and build tool.

## Getting Started

Follow these instructions to get a copy of the project up and running on your local machine for development and testing purposes.

### Prerequisites

- [Java JDK 17](https://www.oracle.com/java/technologies/javase/jdk17-archive-downloads.html) or later.
- [Apache Maven](https://maven.apache.org/download.cgi).
- A running [MySQL](https://dev.mysql.com/downloads/mysql/) instance.

### Installation

1.  **Clone the repository:**
    ```sh
    git clone https://github.com/nitin887/SimpleBlogAppBackend.git
    cd SimpleBlogAppBackend
    ```

2.  **Configure the database:**
    Open `src/main/resources/application.properties` and update the following properties to match your MySQL database configuration:
    ```properties
    spring.datasource.url=jdbc:mysql://localhost:3306/your_database_name
    spring.datasource.username=your_mysql_username
    spring.datasource.password=your_mysql_password
    ```

3.  **Build and run the application:**
    You can build and run the project using the Maven wrapper:
    ```sh
    ./mvnw spring-boot:run
    ```
    The application will start on `http://localhost:8080`.

## API Documentation

This project uses Swagger/OpenAPI for API documentation. Once the application is running, you can access the Swagger UI at the following URL:

[http://localhost:8080/swagger-ui/index.html](http://localhost:8080/swagger-ui/index.html)

This interface provides detailed information about all the available endpoints and allows you to interact with the API directly from your browser.

## Security and Database Initialization

The application is secured using Spring Security. Some endpoints are public, while others require authentication and specific roles.

- **Database Initialization**: When the application starts, it automatically populates the database with two roles (`ROLE_ADMIN`, `ROLE_USER`) and a default admin user.
- **Default Admin User**:
    - **Username**: `admin`
    - **Password**: `password`

### Roles:

- `ROLE_USER`: Can view public content (e.g., view posts).
- `ROLE_ADMIN`: Has full access to all endpoints, including creating, updating, and deleting posts.

To access protected endpoints, you can use Basic Authentication with the default admin credentials.
