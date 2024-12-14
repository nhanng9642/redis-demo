# Demo Redis Application with Spring Boot

This project is a **demo application** showcasing the integration of **Redis caching** with a **Spring Boot** application. The application uses sample data derived from the Employees database.

## Features
- **Spring Boot** for backend development.
- **Redis** as a caching layer to improve data retrieval performance.
- Sample data taken from the [Employees Database](https://github.com/datacharmer/test_db).

## Prerequisites
1. **Java 21** or higher installed on your machine.
2. **Docker** and **Docker Compose** installed for Redis and MySQL setup.
3. Maven for building the Spring Boot application.

## Getting Started

### Step 1: Clone the Repository
```bash
git clone https://github.com/nhanng9642/redis-demo.git
```

### Step 2: Start the MySQL and Redis Containers
Ensure Docker is running and execute the following command to start the necessary services:
```bash
docker-compose up -d
```
This will start:
- A **MySQL** database instance with the Employees dataset.
- A **Redis** instance for caching.

### Step 3: Configure the Application
Update the `application.yml` file in the `src/main/resources` folder if needed. For example, you can set:
- Database credentials (MySQL)
- Redis host and port

### Step 4: Run the Application
Use Maven to build and start the Spring Boot application:
```bash
mvn spring-boot:run
```

### Step 5: Access the Application
The application will be available at:
- **API Base URL**: `http://localhost:8080`

### Step 6: Testing Redis Caching
You can test the caching functionality by accessing endpoints that fetch data from the database. On subsequent requests, data should be retrieved faster due to caching.

## Notes
- This demo uses the [Employees Database](https://github.com/datacharmer/test_db) as the sample dataset. Ensure the database is initialized correctly before running the application.
- Redis is configured with default settings. Modify the configuration in `docker-compose.yml` if needed.

## Cleanup
To stop and remove all containers:
```bash
docker-compose down
```

---
Enjoy exploring Redis caching with Spring Boot!

