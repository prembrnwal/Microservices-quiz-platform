# Microservices Quiz Platform 🚀

A highly scalable, robust microservices-based Quiz application built with **Spring Boot** and **Spring Cloud**. The platform follows an architecture where functionalities are broken down into independent, modular services (Quiz and Question), communicating seamlessly using **OpenFeign** and **Eureka Service Discovery**, all securely routed through a central **API Gateway**.

---

## 🏗️ Architecture & Microservices

The architecture consists of four distinct Spring Boot applications:

1. **Service Registry (Eureka)** - Port `8761`
   - Acts as the central nervous system.
   - All other microservices register themselves here so they can dynamically find each other without hardcoding IP addresses.

2. **API Gateway** - Port `8083`
   - The single entry point for all client requests (e.g., frontend, mobile apps).
   - Dynamically routes requests to `QUIZSERVICE` or `QUESTIONSERVICE` based on the path.
   - Utilizes Spring Cloud LoadBalancer to distribute traffic efficiently.

3. **Quiz Service** - Port `8081`
   - Manages Quiz structures and metadata.
   - Uses **OpenFeign** to make inter-service calls to the Question Service to fetch and attach all related questions when a user queries a quiz.
   - Uses **MySQL** for data persistence.

4. **Question Service** - Port `8082`
   - Manages massive pools of questions, each linked to a specific `quizId`.
   - Uses **PostgreSQL** for robust data persistence.

---

## 🛠️ Technologies Used

* **Java 17 & 21**
* **Spring Boot 4.x** (REST APIs)
* **Spring Cloud Netflix Eureka** (Service Registry & Discovery)
* **Spring Cloud Gateway** (API Routing)
* **Spring Cloud OpenFeign** (Declarative REST Clients for Microservices)
* **Spring Cloud LoadBalancer** (Client-side Load Balancing)
* **Spring Data JPA / Hibernate** (ORM)
* **MySQL & PostgreSQL** (Relational Databases)
* **Lombok** (Boilerplate code reduction)

---

## 🚀 Getting Started

### Prerequisites
* Java Development Kit (JDK 17 or higher)
* Maven
* MySQL Server (Running on `localhost:3306`)
* PostgreSQL Server (Running on `localhost:5432`)

### Booting up the Ecosystem
To prevent connection timeouts, the services must be started in a specific order:

1. **Start the Service Registry First:**
   Run `ServiceRegistryApplication.java`. (Access the Eureka dashboard at `http://localhost:8761/`)
2. **Start the Databases Data Services:**
   Run `QuestionserviceApplication.java`
   Run `QuizserviceApplication.java`
3. **Start the API Gateway:**
   Run `ApiGatewayApplication.java`

*Note: Ensure your database user credentials match the ones configured in your respective `application.properties` files before starting.*

---

## 🌐 API Endpoints (Via API Gateway)

Instead of accessing microservices directly, all traffic goes through the API Gateway running on port `8083`.

### Quiz Endpoints
* **Create a Quiz:** `POST http://localhost:8083/quiz`
* **Get All Quizzes:** `GET http://localhost:8083/quiz`
* **Get Specific Quiz (with attached Questions):** `GET http://localhost:8083/quiz/{id}`

### Question Endpoints
* **Create a Question:** `POST http://localhost:8083/question`
* **Get All Questions:** `GET http://localhost:8083/question`
* **Get Specific Question:** `GET http://localhost:8083/question/{id}`
* **Get Questions by Quiz ID:** `GET http://localhost:8083/question/quiz/{quizId}`

---

## 🤝 Contributing
Contributions, issues, and feature requests are welcome! Feel free to check the issues page.
