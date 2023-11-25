# AI Generated Todo List Application

This repository contains a CRUD (Create, Read, Update, Delete) API application developed using Java, Spring Boot, and MySQL. The application manages a simple Todo List.

## Setup Instructions

### Prerequisites

Before running the application, make sure you have:

- Java Development Kit (JDK)
- Apache Maven
- Docker (for running MySQL as a container)

### Configuration

1. **Clone the repository:**

   ```bash
   git clone https://github.com/parfenovds/ai_generated_todo
   ```

    Open the application.properties file in src/main/resources:
        Set your database credentials (spring.datasource.username and spring.datasource.password).
        For the first run, set spring.jpa.hibernate.ddl-auto=create to generate tables. After the first run, revert it to validate.

2. **Running the Application**

   2.1. Start MySQL Docker Container:
  
     ```bash
      docker run -d -e MYSQL_ROOT_PASSWORD=<your_password> -e MYSQL_DATABASE=todo_db -e MYSQL_USER=todo_user -e MYSQL_PASSWORD=todo_password -p 3306:3306 mysql:latest
     ```
  
    2.2. Navigate to the project directory:
  
     ```bash
      cd ai_generated_todo
     ```
  
    2.3. Run the application:
  
     ```bash
      mvn spring-boot:run
     ```
  
  2.4. Endpoints

3. **The API endpoints available are:**
    - GET /api/todo: Retrieve all Todo Items.
    - GET /api/todo/{id}: Retrieve a Todo Item by ID.
    - POST /api/todo: Create a new Todo Item.
    - PUT /api/todo/{id}: Update an existing Todo Item by ID.
    - DELETE /api/todo/{id}: Delete a Todo Item by ID.
