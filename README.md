# E-commerce Microservices Project

## Overview

This project implements an e-commerce platform using a microservices architecture. Each service is designed to handle specific business functionalities, ensuring scalability and maintainability.

## Architecture

The system comprises several microservices, each responsible for distinct aspects of the e-commerce platform:

- **Customer Service**: Manages customer information and operations.
- **Inventory Service**: Handles product inventory and stock levels.
- **Order Service**: Processes customer orders and manages order statuses.
- **Notification Service**: Sends notifications to customers regarding their orders and other activities.
- **Gateway Service**: Acts as an API gateway, routing requests to the appropriate services.
- **Discovery Service**: Facilitates service discovery to enable dynamic scaling and fault tolerance.
- **Configuration Service**: Centralizes configuration management for all services.

Each service is independently deployable and communicates with others through well-defined APIs.

## Services

1. **Customer Service**
   - **Path**: `/Acheteur-Service`
   - **Description**: Manages customer data, including creation, retrieval, updating, and deletion of customer records.
   
2. **Inventory Service**
   - **Path**: `/Produit-Service`
   - **Description**: Manages product information, inventory levels, and product-related operations.

3. **Order Service**
   - **Path**: `/Vente-Service`
   - **Description**: Handles order processing, order history, and order status management.

4. **Notification Service**
   - **Path**: `/Notification-service`
   - **Description**: Sends notifications to customers about order confirmations, shipping updates, and other relevant information.

5. **Gateway Service**
   - **Path**: `/Gateway-service`
   - **Description**: Serves as the entry point to the microservices, routing external requests to the appropriate internal services.

6. **Discovery Service**
   - **Path**: `/Discovery-service`
   - **Description**: Provides service discovery capabilities, allowing services to find and communicate with each other dynamically.

7. **Configuration Service**
   - **Path**: `/Config-service`
   - **Description**: Manages external configurations for services, enabling centralized and dynamic configuration management.

## Frontend

- **Angular Frontend**
  - **Path**: `/NGFrontEnd`
  - **Description**: Provides the user interface for the e-commerce platform, allowing customers to browse products, place orders, and manage their accounts.

## Technologies Used

This project leverages several technologies to ensure smooth operation, efficient scaling, and robust communication between services:

- **Backend**: 
  - **Java (Spring Boot)**: Each microservice is built using Spring Boot, providing a solid foundation for building scalable and resilient web applications.
  
- **Frontend**: 
  - **Angular**: The frontend is built using Angular, allowing for dynamic and responsive UI for the end users.
  
- **Service Discovery**:
  - **Netflix Eureka**: Eureka is used for service discovery, which allows different microservices to find and communicate with each other dynamically, ensuring fault tolerance and scalability.
  
- **API Gateway**: 
  - **Spring Cloud Gateway**: Acts as a reverse proxy and entry point for all incoming API requests. It routes requests to the appropriate services, ensuring load balancing and fault tolerance.

- **Configuration Management**:
  - **Spring Cloud Config**: Centralized configuration management for all services, allowing dynamic updates without restarting the microservices.

- **Message Queuing**:
  - **RabbitMQ**: RabbitMQ is used for asynchronous communication between microservices. It handles message queues for tasks such as order processing, notifications, etc., improving performance and reliability.

- **Database**:
  - **PostgreSQL**: Each service (where required) uses PostgreSQL for persistent storage, providing a reliable and robust relational database solution.
  
- **Containerization**:
  - **Docker**: All microservices and components are containerized using Docker to ensure consistency across different environments. Docker enables isolation, portability, and scalability for each service.
  
- **Orchestration**:
  - **Docker Compose**: Docker Compose is used to manage multi-container Docker applications, making it easier to define and run multi-service applications. It allows you to define all the services in a single YAML file and start them with a single command.

## Prerequisites

- **Java** (version 11 or higher)
- **Node.js** (version 14 or higher)
- **Angular CLI** (version 11 or higher)
- **Docker** (version 19 or higher)
- **Docker Compose** (version 1.27 or higher)
- **RabbitMQ** (if you want to manually interact with message queues)

## Setup Instructions

### Clone the Repository
   Clone this repository to your local machine:
   ```bash
   git clone https://github.com/wail-ait/ecom_microservice.git
   cd ecom_microservice

## Setup Instructions

### Setup Docker and Docker Compose

- Ensure Docker and Docker Compose are installed on your machine.
- Run the following command to start the services using Docker Compose:

    ```bash
    docker-compose up --build
    ```

### Access the Services

The services will be available at the following paths:

- **Customer Service**: `http://localhost:8081/Acheteur-Service`
- **Inventory Service**: `http://localhost:8082/Produit-Service`
- **Order Service**: `http://localhost:8083/Vente-Service`
- **Notification Service**: `http://localhost:8084/Notification-service`
- **Gateway Service**: `http://localhost:8080/Gateway-service`
- **Discovery Service**: `http://localhost:8761/Discovery-service`
- **Configuration Service**: `http://localhost:8888/Config-service`

### Frontend Setup

- Navigate to the `NGFrontEnd` directory and install the required packages:

    ```bash
    cd NGFrontEnd
    npm install
    ```

- Start the Angular frontend application:

    ```bash
    ng serve
    ```

- The frontend will be available at `http://localhost:4200`.
