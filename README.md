# URL Shortener Service

A **RESTful URL shortener service** built with **Spring Boot** to practice **MVC architecture** and **data persistence**.

## Features
- Shorten long URLs
- Retrieve original URLs using short codes
- Follows RESTful API principles
- Validates input data

## Technologies Used
- Java 21
- Spring Boot
- Spring MVC
- Spring Data JPA
- H2
- Lombok

## Project Structure
- **Controller**: Handles HTTP requests and responses
- **Service**: Contains business logic
- **Repository**: Manages data persistence
- **Model/DTO**: Represents request and response objects

## Getting Started

### Prerequisites
- Java 21 or higher
- Maven 3.8+
- Your preferred IDE (IntelliJ, Eclipse, VS Code)

### Running the Project
1. Clone the repository:
  ```bash
   git clone https://github.com/IlyasDev-Quest/url-shortener-service.git  
   cd url-shortener-service
   ```

2. Build and run the project using Maven:
  ```bash
   mvn spring-boot:run
   ```

3. The application will start on `http://localhost:8080`.