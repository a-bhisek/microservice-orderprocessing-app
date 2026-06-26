# 🚀 Microservice Order Processing System

A production-style **Spring Boot Microservices** application that simulates a complete **Order Processing System**. This project demonstrates enterprise-level backend development using the **Spring Cloud ecosystem**, including service discovery, centralized configuration, API Gateway, fault tolerance, centralized logging, and application monitoring.

---

# 📌 Features

* Order placement and processing
* Inventory stock validation and reduction
* Payment processing
* Email notifications for order placement and payment confirmation
* Service Discovery using Eureka Server
* Centralized Configuration using Spring Cloud Config Server
* API Gateway for centralized request routing
* Inter-service communication using OpenFeign
* Fault Tolerance using Resilience4j Circuit Breaker
* Centralized Logging using ELK Stack (Elasticsearch, Logstash & Kibana)
* Application Monitoring using Spring Boot Admin & Actuator
* Externalized configuration using Git Repository
* MySQL database integration with Spring Data JPA

---

# 🏗️ Microservices

* 📦 Order Service
* 📦 Inventory Service
* 📦 Payment Service
* 📦 Email Service
* ⚙️ Spring Cloud Config Server
* 🔍 Eureka Server
* 🌐 Spring Cloud API Gateway
* 📊 Spring Boot Admin Server

---

# 🛠️ Technology Stack

### Backend

* Java 21
* Spring Boot
* Spring MVC
* Spring Data JPA
* Hibernate
* REST APIs

### Spring Cloud

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
* Kibana

### Tools

* Maven
* Git & GitHub
* Postman
* IntelliJ IDEA
* Eclipse

---

# 🏛️ System Architecture

```text
                        Client
                           │
                           ▼
                    API Gateway
                           │
        ┌──────────┬──────────┬──────────┐
        ▼          ▼          ▼          ▼
     Order     Inventory   Payment    Email
        │          │          │          │
        └──────────┴──────────┴──────────┘
                           │
                    Eureka Server
                           │
               Spring Cloud Config
                           │
                 Spring Boot Admin
                           │
                      ELK Stack
                           │
                          MySQL
```

---

# 🔄 Request Flow

1. Client sends request to the API Gateway.
2. API Gateway routes the request to the Order Service.
3. Order Service validates inventory through Inventory Service.
4. Payment Service processes payment.
5. Email Service sends order confirmation and payment confirmation emails.
6. All services register themselves with Eureka Server.
7. Configuration is managed using Spring Cloud Config Server.
8. Logs are collected by Logstash, stored in Elasticsearch, and visualized in Kibana.
9. Spring Boot Admin monitors all running services.

---

# 📷 Project Screenshots

> Create an **images** folder in the repository and place all screenshots inside it.

```
images/
│── architecture.png
│── eureka-dashboard.png
│── admin-dashboard.png
│── kibana-logs.png
│── postman-order-api.png
```

## 🏛️ Architecture

---

## 🔍 Eureka Dashboard

---

## 📊 Spring Boot Admin Dashboard

---

## 📈 Kibana Logs

---

## 📬 Postman API Testing

---

# 🚀 Getting Started

## Prerequisites

* Java 21
* Maven
* MySQL
* Git
* Elasticsearch
* Logstash
* Kibana

## Clone Repository

```bash
git clone https://github.com/a-bhisek/microservice-orderprocessing-app.git
```

## Start Services

Start the services in the following order:

1. Config Server
2. Eureka Server
3. Spring Boot Admin
4. Inventory Service
5. Payment Service
6. Email Service
7. Order Service
8. API Gateway

---

# 📊 Project Highlights

* Enterprise-Level Spring Boot Microservices
* Service Discovery with Eureka
* Centralized Configuration
* API Gateway Routing
* OpenFeign Communication
* Circuit Breaker using Resilience4j
* Centralized Logging using ELK Stack
* Spring Boot Admin Monitoring
* External Configuration using Git Repository
* Layered Architecture
* RESTful APIs
* Exception Handling
* MySQL Persistence

---

# 🚀 Future Enhancements

* JWT Authentication & Authorization
* Docker & Docker Compose
* Kubernetes Deployment
* Kafka/RabbitMQ Integration
* CI/CD using GitHub Actions
* Distributed Tracing with Zipkin/OpenTelemetry
* AWS Cloud Deployment

---

# 👨‍💻 Author

**Abhisek Mohapatra**

GitHub: https://github.com/a-bhisek

---

⭐ **If you found this project useful, consider giving it a Star!**
