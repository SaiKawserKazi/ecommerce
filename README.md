# E-Commerce API Project

## Overview
This project is an E-commerce API application developed using Spring Boot 3.2.2. The primary goal of the project is to provide a backend service for an e-commerce platform, allowing customers to view their wish lists, retrieve daily sales totals, identify the best sale days, and see the top-selling products.

## Features
The API provides the following endpoints:
1. **Wish List API**: Retrieve the wish list of a specific customer.
2. **Daily Sales API**: Get the total sales amount for the current day.
3. **Max Sale Day API**: Find the day with the maximum sales within a given time range.
4. **Top Selling Items (All Time) API**: List the top 5 selling items based on total sale amount.
5. **Top Selling Items (Last Month) API**: List the top 5 selling items based on the number of sales in the last month.

## Technologies Used
- **Java**: JDK 17 or JDK 21
- **Spring Boot**: 3.2.2
- **Hibernate**: ORM framework for database interactions
- **PostgreSQL**: Relational database management system
- **Docker**: Containerization platform for easy deployment and scaling
- **Lombok**: To reduce boilerplate code for model classes
- **JUnit**: For Test-Driven Development (TDD)

## Setup Instructions

### Prerequisites
- Java Development Kit (JDK) 17 or 21
- Docker (latest version)
- An IDE of your choice (IntelliJ IDEA, Eclipse, VS Code, etc.)

### Database Setup
Ensure PostgreSQL is running and create a database named `testdb` with user `testdb` and password `1234`.

### Running the Application

1. **Clone the repository**:
    ```bash
    git clone https://github.com/your-username/e-commerce-api.git
    cd e-commerce-api
    ```

2. **Configure the application**:
   Ensure that your `src/main/resources/application.properties` file is configured with the following properties:
    ```properties
    spring.application.name=e-commerce
    spring.datasource.url=jdbc:postgresql://localhost:5432/testdb
    spring.datasource.username=testdb
    spring.datasource.password=1234
    spring.datasource.driver-class-name=org.postgresql.Driver

    # Hibernate properties
    spring.jpa.database-platform=org.hibernate.dialect.PostgreSQLDialect
    spring.jpa.show-sql=true
    spring.jpa.hibernate.ddl-auto=update

    # Server port
    server.port=8083
    ```

3. **Build and run the application**:
    ```bash
    ./mvnw spring-boot:run
    ```

4. **Access the application**:
   The application will be available at `http://localhost:8083`.

### Docker Setup

1. **Build the Docker image**:
    ```bash
    docker build -t e-commerce-api .
    ```

2. **Run the Docker container**:
    ```bash
    docker run -d -p 8083:8083 e-commerce-api
    ```

### Sample Data

Use the provided SQL scripts to insert sample data into your PostgreSQL database.

```sql
-- Insert data into the customer table
INSERT INTO customer (customer_id, name, email, created_at, updated_at) VALUES
('1e8bfa5c-7b84-4d95-8e9e-3c5b4a5d9f60', 'John Doe', 'john.doe@example.com', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
-- (Add 19 more rows...)

-- Insert data into the product table
INSERT INTO product (product_id, name, description, price, created_at, updated_at) VALUES
('5e8bfa5c-7b84-4d95-8e9e-3c5b4a5d9f64
