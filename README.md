# IoT Sensor Monitoring System 🚀

A **Spring Boot–based IoT Sensor Monitoring System** designed to ingest, process, and monitor real-time sensor data using **REST APIs, Apache Kafka, relational databases, and OpenTelemetry**.

This project demonstrates **scalable backend system design**, **event-driven microservices**, and **production-grade observability**, similar to systems used in real-world IoT and data-streaming platforms.

---

## 📌 Overview

Modern IoT systems generate large volumes of data that must be processed reliably and observed effectively.  
This application simulates a **real-world IoT backend** where sensor data is:

- Collected via REST APIs
- Streamed asynchronously using Kafka
- Persisted in a relational database
- Monitored using distributed tracing and metrics

---

## ✨ Key Features

### 📡 Sensor Data Ingestion
- RESTful APIs to accept sensor readings
- Input validation for reliable data ingestion

### 🔁 Event-Driven Processing
- Kafka producer publishes sensor events
- Kafka consumer processes events asynchronously
- Enables loose coupling and high throughput

### 🗄️ Data Persistence
- Supports **PostgreSQL** and **MySQL**
- Uses Spring Data JPA for ORM and clean data access

### 🔍 Observability & Monitoring
- Distributed tracing with **OpenTelemetry**
- Metrics and health checks via **Spring Boot Actuator**
- Compatible with **Jaeger** and **Zipkin**

### 🛡️ API Reliability
- Global exception handling
- Meaningful HTTP status codes
- Clean and secure API design

### 🧪 Testing
- Unit testing using **JUnit 5** and **Mockito**
- Focus on service-layer and business-logic testing

---

## 🛠️ Tech Stack

| Category | Technologies |
|-------|--------------|
| Language | Java 17 |
| Framework | Spring Boot 3 |
| Persistence | Spring Data JPA |
| Database | PostgreSQL / MySQL |
| Messaging | Apache Kafka |
| Observability | OpenTelemetry, Spring Boot Actuator |
| Build Tool | Maven |
| Testing | JUnit 5, Mockito |

---

## 🔹 Getting Started  

1️⃣ Clone the Repository  
```bash
git clone https://github.com/your-username/iotsenser.git
cd iotsenser

2️⃣ Configure Database

Update your application.properties with either PostgreSQL or MySQL credentials:
spring.datasource.url=jdbc:postgresql://localhost:5432/iotsenser
spring.datasource.username=your-username
spring.datasource.password=your-password

3️⃣ Run with Maven

mvn clean install
mvn spring-boot:run

---

🔹 Example API Endpoints
Method	Endpoint	Description
POST	/api/sensors	Add new sensor data
GET	/api/sensors	Fetch all sensor readings
GET	/actuator/health	Health check endpoint

---

🔹 Kafka Integration

Producer pushes sensor events to Kafka topic: iot-sensor-events.

Consumer service listens and processes sensor events in real time.

---

🔹 Observability (OpenTelemetry)

Integrated distributed tracing to monitor API performance.

Export traces to Jaeger/Zipkin or any OpenTelemetry-compatible backend.

---

🔹 Testing

mvn test
Includes unit tests with JUnit 5 and Mockito.

---

🔹 Future Improvements

Containerization with Docker & Kubernetes.

CI/CD pipeline with GitHub Actions.

Frontend dashboard for real-time visualization.

---

✨ This project highlights expertise in building enterprise-grade, event-driven, and observable microservices with modern Java.




