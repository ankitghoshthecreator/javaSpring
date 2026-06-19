# javaSpringgapp

This is a Spring Boot project built with Java 17 and Maven. It serves as a foundational application utilizing the Spring Web MVC framework.

## Getting Started

### Prerequisites

*   Java 17 or higher
*   Maven (or you can use the included wrapper `mvnw`)

### Project Structure

*   `src/main/java`: Contains the application's source code.
*   `src/main/resources`: Contains configuration files like `application.properties`.
*   `src/test`: Contains test cases.
*   `pom.xml`: Maven configuration file managing dependencies and plugins.

### Running the Application

To run the application locally, use the Maven wrapper:

**Windows:**
```cmd
mvnw.cmd spring-boot:run
```

**macOS/Linux:**
```bash
./mvnw spring-boot:run
```

### Dependencies

*   `spring-boot-starter-webmvc`: Core starter for building web applications, including RESTful applications using Spring MVC.
*   `spring-boot-starter-webmvc-test`: Starter for testing Spring MVC applications.

