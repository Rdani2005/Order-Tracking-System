# Order Tracking System

## Description

The **Order Tracking System** is a microservices-based system that manages orders, tracks their status, processes payments through **PayPal**, and handles communication with delivery services like **Uber Direct**. The architecture follows the **Domain-Driven Design (DDD)** approach and is built using **Java**, **Spring Boot**, and **Maven**.

This project includes:
- Order management and status tracking.
- Payment processing via **PayPal**.
- Delivery status tracking through external services (initially **Uber Direct**).
- Communication between microservices using **Kafka**.
- Data persistence in a **PostgreSQL** database.

---

## Technologies Used

- **Java** (JDK 17+)
- **Spring Boot** (3.x)
- **Maven** (Dependency management)
- **PostgreSQL** (Relational database)
- **Kafka** (Messaging system)
- **Docker** (Optional for deployment)
- **Uber Direct API** (Initially for delivery management, but interchangeable)

---

## Architecture

The application is designed as a set of independent microservices, each with a clear responsibility. Below are the key services:

### 1. **Order Service**
   - **Responsibility:** Manage orders and their statuses.
   - **Order states:**
     - Created
     - In Preparation
     - Ready for Shipping
     - Shipped
     - Completed
   - Persistence in PostgreSQL.

### 2. **Payment Service**
   - **Responsibility:** Process and manage payment statuses.
   - **Integration:** With **PayPal API**.
   - **Payment states:**
     - Pending
     - Completed
     - Failed

### 3. **Delivery Service**
   - **Responsibility:** Handle communication with delivery services.
   - **Initial integration:** **Uber Direct API** (flexible for future integrations).
   - **Key tasks:**
     - Create delivery orders.
     - Update delivery status in the order.

### 4. **Message Broker**
   - **Technology:** Kafka.
   - **Responsibility:** Asynchronous communication between microservices.

---

## Installation and Execution

### Prerequisites
1. **Java JDK 17+**
2. **Maven**
3. **Docker** (optional, for running PostgreSQL and Kafka)
4. **PostgreSQL** (installed or in a container)
5. **Kafka** (installed or in a container)

### Setup

1. Clone this repository:
   ```bash
   git clone https://github.com/rdani2005/uber-direct.git
   cd uber-direct
   ```
2. Configure microservice properties in the application.yml files:
   -  PostgreSQL database:
       ```yml
       spring:
        datasource:
          url: jdbc:postgresql://localhost:5432/order_system
          username: your_username
          password: your_password
        jpa:
          hibernate:
            ddl-auto: update
       ```
    - Kafka:
      ```yml
        spring:
          kafka:
            bootstrap-servers: localhost:9092
            consumer:
              group-id: order-system
      ```
3. Build the project:
  ```bash
  mvn clean install
  ```
4. Run the services:
   - Each microservice has its own module. Navigate to the corresponding directory and run:
     ```bash
     mvn spring-boot:run
     ```
## Contribution
Contributions are welcome! Please:

1. Fork the repository.
2. Create a branch for your changes: git checkout -b feature/new-feature.
3. Submit a pull request explaining your changes.

## License
This project is licensed under the MIT License. See the `LICENSE` file for more details

