# 🚀 Microservice Order Processing System

A production-style **Spring Boot Microservices** application that simulates an end-to-end **Order Processing System**. The project follows the Spring Cloud ecosystem and demonstrates service discovery, centralized configuration, API Gateway, fault tolerance, centralized logging, and monitoring.

---

## ✨ Features

* Order placement and processing
* Inventory stock validation and reduction
* Payment processing
* Email notifications for order placement and payment confirmation
* Service Discovery using Eureka Server
* Centralized Configuration using Spring Cloud Config Server
* API Gateway for centralized request routing
* Inter-service communication using OpenFeign
* Fault tolerance using Resilience4j Circuit Breaker
* Centralized logging using ELK Stack (Elasticsearch, Logstash & Kibana)
* Application monitoring using Spring Boot Admin & Actuator
* MySQL database integration using Spring Data JPA

---

## 🏗️ Microservices

* **Order Service**
* **Inventory Service**
* **Payment Service**
* **Email Service**
* **Config Server**
* **Eureka Server**
* **API Gateway**
* **Spring Boot Admin Server**

---

## 🛠️ Technology Stack

### Backend

* Java 21
* Spring Boot
* Spring Cloud
* Spring Data JPA
* Spring MVC
* Hibernate
* REST APIs

### Spring Cloud Components

* Eureka Server
* Spring Cloud Config
* Spring Cloud Gateway
* OpenFeign
* Resilience4j Circuit Breaker

### Database

* MySQL

### Monitoring & Logging

* Spring Boot Admin
* Spring Boot Actuator
* Elasticsearch
* Logstash
* Kibana (ELK Stack)

### Tools

* Maven
* Git & GitHub
* Postman
* IntelliJ IDEA
* Eclipse

---

## 🏛️ Architecture

```text
                    Client
                       │
                       ▼
                 API Gateway
                       │
      ┌──────────┬───────────┬──────────┐
      ▼          ▼           ▼          ▼
 Order     Inventory     Payment     Email
      │          │           │          │
      └──────────┴───────────┴──────────┘
                    │
              Eureka Server
                    │
          Spring Cloud Config
                    │
          Spring Boot Admin
                    │
                ELK Stack
```

---

## 🔄 Request Flow

1. Client sends a request through the API Gateway.
2. API Gateway routes the request to the Order Service.
3. Order Service validates stock using Inventory Service.
4. Payment Service processes the payment.
5. Email Service sends order and payment notifications.
6. All services register with Eureka Server.
7. Configuration is managed through Spring Cloud Config Server.
8. Logs are centralized using the ELK Stack.
9. Spring Boot Admin monitors the health and status of all services.

---

## 📊 Project Highlights

* Distributed Microservices Architecture
* Service Discovery with Eureka
* Centralized Configuration
* API Gateway Routing
* Fault Tolerance using Circuit Breaker
* Centralized Logging with ELK
* Health Monitoring using Spring Boot Admin
* Externalized Configuration with Git Repository
* RESTful API Communication using OpenFeign

---

## 📷 Screenshots

Add screenshots of:

* Eureka Dashboard
* Spring Boot Admin Dashboard
* Kibana Logs
* API Gateway
* Postman API Testing

---

## 🚀 Future Enhancements

* JWT Authentication & Authorization
* Docker & Docker Compose
* Kubernetes Deployment
* Kafka/RabbitMQ Integration
* CI/CD Pipeline with GitHub Actions
* Distributed Tracing using Zipkin/OpenTelemetry
* AWS Cloud Deployment

---

## 👨‍💻 Author

**Abhisek Mohapatra**

GitHub: https://github.com/a-bhisek
