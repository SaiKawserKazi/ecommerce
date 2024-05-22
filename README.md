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

-- Insert data into the customer table
INSERT INTO customer (customer_id, name, email, created_at, updated_at) VALUES
('1e8bfa5c-7b84-4d95-8e9e-3c5b4a5d9f64', 'John Doe', 'john11@example.com', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
('2e8bfa5c-7b84-4d95-8e9e-3c5b4a5d9f65', 'Jane Smith', 'jane11@example.com', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
('3e8bfa5c-7b84-4d95-8e9e-3c5b4a5d9f66', 'Alice Lee', 'alice11@example.com', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);

-- Insert data into the product table
INSERT INTO product (product_id, name, description, price, created_at, updated_at) VALUES
('4e8bfa5c-7b84-4d95-8e9e-3c5b4a5d9f66', 'Laptop', 'High-performance laptop', 999.99, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
('5e8bfa5c-7b84-4d95-8e9e-3c5b4a5d9f67', 'Smartphone', 'Latest smartphone model', 799.99, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
('6e8bfa5c-7b84-4d95-8e9e-3c5b4a5d9f68', 'Headphones', 'Noise-canceling headphones', 199.99, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);

-- Insert data into the sale table
INSERT INTO sale (sale_id, customer_id, total_amount, sale_date, created_at, updated_at) VALUES
('7e8bfa5c-7b84-4d95-8e9e-3c5b4a5d9f83', '1e8bfa5c-7b84-4d95-8e9e-3c5b4a5d9f67', 1999.98, CURRENT_DATE, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
('8e8bfa5c-7b84-4d95-8e9e-3c5b4a5d9f84', '2e8bfa5c-7b84-4d95-8e9e-3c5b4a5d9f68', 1599.98, CURRENT_DATE, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
('9e8bfa5c-7b84-4d95-8e9e-3c5b4a5d9f86', '3e8bfa5c-7b84-4d95-8e9e-3c5b4a5d9f69', 999.99, CURRENT_DATE, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);

-- Insert data into the sale_item table
INSERT INTO sale_item (sale_item_id, sale_id, product_id, quantity, price, created_at) VALUES
('ae8bfa5c-7b84-4d95-8e9e-3c5b4a5d9f64', '7e8bfa5c-7b84-4d95-8e9e-3c5b4a5d9f66', '4e8bfa5c-7b84-4d95-8e9e-3c5b4a5d9f63', 1, 999.99, CURRENT_TIMESTAMP),
('be8bfa5c-7b84-4d95-8e9e-3c5b4a5d9f75', '7e8bfa5c-7b84-4d95-8e9e-3c5b4a5d9f66', '6e8bfa5c-7b84-4d95-8e9e-3c5b4a5d9f65', 2, 99.99, CURRENT_TIMESTAMP),
('ce8bfa5c-7b84-4d95-8e9e-3c5b4a5d9f76', '8e8bfa5c-7b84-4d95-8e9e-3c5b4a5d9f67', '5e8bfa5c-7b84-4d95-8e9e-3c5b4a5d9f64', 2, 799.99, CURRENT_TIMESTAMP),
('de8bfa5c-7b84-4d95-8e9e-3c5b4a5d9f77', '9e8bfa5c-7b84-4d95-8e9e-3c5b4a5d9f68', '4e8bfa5c-7b84-4d95-8e9e-3c5b4a5d9f63', 1, 999.99, CURRENT_TIMESTAMP),
('ee8bfa5c-7b84-4d95-8e9e-3c5b4a5d9f88', '9e8bfa5c-7b84-4d95-8e9e-3c5b4a5d9f68', '6e8bfa5c-7b84-4d95-8e9e-3c5b4a5d9f65', 1, 99.99, CURRENT_TIMESTAMP);

-- Insert data into the wish_list table
INSERT INTO wish_list (wishlist_id, customer_id, product_id, created_at) VALUES
('fe8bfa5c-7b84-4d95-8e9e-3c5b4a5d9f79', '1e8bfa5c-7b84-4d95-8e9e-3c5b4a5d9f60', '5e8bfa5c-7b84-4d95-8e9e-3c5b4a5d9f64', CURRENT_TIMESTAMP),
('fe8bfa5c-7b84-4d95-8e9e-3c5b4a5d9f78', '2e8bfa5c-7b84-4d95-8e9e-3c5b4a5d9f61', '4e8bfa5c-7b84-4d95-8e9e-3c5b4a5d9f63', CURRENT_TIMESTAMP),
('fe8bfa5c-7b84-4d95-8e9e-3c5b4a5d9f77', '3e8bfa5c-7b84-4d95-8e9e-3c5b4a5d9f62', '6e8bfa5c-7b84-4d95-8e9e-3c5b4a5d9f65', CURRENT_TIMESTAMP);


-- Insert products
INSERT INTO product (product_id, name, price) VALUES
('550e8400-e29b-41d4-a716-446655440000', 'Product A', 100.0),
('550e8400-e29b-41d4-a716-446655440001', 'Product B', 200.0),
('550e8400-e29b-41d4-a716-446655440002', 'Product C', 300.0),
('550e8400-e29b-41d4-a716-446655440003', 'Product D', 400.0),
('550e8400-e29b-41d4-a716-446655440004', 'Product E', 500.0),
('550e8400-e29b-41d4-a716-446655440005', 'Product F', 600.0);

-- Insert sales
INSERT INTO sale (sale_id, sale_date, total_amount) VALUES
('550e8400-e29b-41d4-a716-446655440100', '2024-04-01', 500.0),
('550e8400-e29b-41d4-a716-446655440101', '2024-04-15', 600.0),
('550e8400-e29b-41d4-a716-446655440102', '2024-05-01', 700.0),
('550e8400-e29b-41d4-a716-446655440103', '2024-05-10', 800.0),
('550e8400-e29b-41d4-a716-446655440104', '2024-05-20', 900.0),
('550e8400-e29b-41d4-a716-446655440105', '2024-05-25', 1000.0),
('550e8400-e29b-41d4-a716-446655440106', '2024-06-01', 1100.0),
('550e8400-e29b-41d4-a716-446655440107', '2024-06-05', 1200.0),
('550e8400-e29b-41d4-a716-446655440108', '2024-06-10', 1300.0),
('550e8400-e29b-41d4-a716-446655440109', '2024-06-15', 1400.0);

-- Insert sale items
INSERT INTO sale_item (sale_item_id, sale_id, product_id, quantity, price) VALUES
('550e8400-e29b-41d4-a716-446655440200', '550e8400-e29b-41d4-a716-446655440100', '550e8400-e29b-41d4-a716-446655440000', 5, 100.0),
('550e8400-e29b-41d4-a716-446655440201', '550e8400-e29b-41d4-a716-446655440101', '550e8400-e29b-41d4-a716-446655440001', 3, 200.0),
('550e8400-e29b-41d4-a716-446655440202', '550e8400-e29b-41d4-a716-446655440102', '550e8400-e29b-41d4-a716-446655440002', 2, 300.0),
('550e8400-e29b-41d4-a716-446655440203', '550e8400-e29b-41d4-a716-446655440103', '550e8400-e29b-41d4-a716-446655440003', 4, 400.0),
('550e8400-e29b-41d4-a716-446655440204', '550e8400-e29b-41d4-a716-446655440104', '550e8400-e29b-41d4-a716-446655440004', 6, 500.0),
('550e8400-e29b-41d4-a716-446655440205', '550e8400-e29b-41d4-a716-446655440105', '550e8400-e29b-41d4-a716-446655440005', 7, 600.0),
('550e8400-e29b-41d4-a716-446655440206', '550e8400-e29b-41d4-a716-446655440106', '550e8400-e29b-41d4-a716-446655440000', 8, 100.0),
('550e8400-e29b-41d4-a716-446655440207', '550e8400-e29b-41d4-a716-446655440107', '550e8400-e29b-41d4-a716-446655440001', 9, 200.0),
('550e8400-e29b-41d4-a716-446655440208', '550e8400-e29b-41d4-a716-446655440108', '550e8400-e29b-41d4-a716-446655440002', 10, 300.0),
('550e8400-e29b-41d4-a716-446655440209', '550e8400-e29b-41d4-a716-446655440109', '550e8400-e29b-41d4-a716-446655440003', 11, 400.0),
('550e8400-e29b-41d4-a716-446655440210', '550e8400-e29b-41d4-a716-446655440109', '550e8400-e29b-41d4-a716-446655440004', 12, 500.0),
('550e8400-e29b-41d4-a716-446655440211', '550e8400-e29b-41d4-a716-446655440109', '550e8400-e29b-41d4-a716-446655440005', 13, 600.0);

