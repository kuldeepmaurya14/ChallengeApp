# Challenge Management API

A Spring Boot REST API for managing monthly challenges. The application provides APIs to create, view, update, search, and delete challenges using Spring Data JPA.

## Features

- Create a new challenge
- Retrieve all challenges
- Search challenges by month
- Update an existing challenge
- Delete a challenge
- Case-insensitive month search
- RESTful API architecture
- Database persistence using Spring Data JPA

## Technologies Used

- **Java**
- **Spring Boot**
- **Spring Data JPA**
- **REST API**
- **Hibernate**
- **Maven**
- **MySQL / H2 Database**

## Project Structure

```text
src/main/java/com/embarkx/ChallengeApp
│
├── ChallengeAppApplication.java
├── ChallengeController.java
├── ChallengeService.java
├── ChallengeRepository.java
└── Challenge.java
```

### Architecture

```text
Client
   ↓
Controller
   ↓
Service
   ↓
Repository
   ↓
Database
```

- **Controller:** Handles HTTP requests and responses.
- **Service:** Contains application/business logic.
- **Repository:** Performs database operations using JPA.
- **Entity:** Represents the Challenge data stored in the database.

## API Endpoints

| Method | Endpoint | Description |
|---|---|---|
| GET | `/challenges` | Get all challenges |
| POST | `/challenges` | Add a new challenge |
| GET | `/challenges/{month}` | Find challenge by month |
| PUT | `/challenges/{id}` | Update a challenge |
| DELETE | `/challenges/{id}` | Delete a challenge |

## Sample Request

### Add Challenge

**POST**

```text
/challenges
```

Request body:

```json
{
  "month": "January",
  "description": "Learn Spring Boot"
}
```

### Update Challenge

**PUT**

```text
/challenges/1
```

Request body:

```json
{
  "month": "January",
  "description": "Learn Spring Boot and REST API"
}
```

## How to Run the Project

### 1. Clone the repository

```bash
git clone https://github.com/YOUR_USERNAME/ChallengeApp.git
```

### 2. Open the project

Open the project in **IntelliJ IDEA** or **Eclipse**.

### 3. Configure the database

Update the database configuration in:

```text
src/main/resources/application.properties
```

Example:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/challenge_db
spring.datasource.username=root
spring.datasource.password=your_password

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
```

### 4. Run the application

Run:

```text
ChallengeAppApplication.java
```

The application will start on:

```text
http://localhost:8080
```

## Testing

You can test the REST APIs using:

- Postman
- Thunder Client
- Browser for GET requests

## Future Improvements

- Add user authentication and authorization
- Add input validation
- Add Swagger/OpenAPI documentation
- Add pagination and sorting
- Add frontend interface

## Author

**Kuldeep Kumar Maurya**
