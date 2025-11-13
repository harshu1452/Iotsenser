# IoT Sensor Monitoring System 🚀  

A Spring Boot–based IoT Sensor Monitoring application that integrates **Kafka**, **PostgreSQL/MySQL**, and **OpenTelemetry** for distributed tracing. This project demonstrates expertise in building **scalable microservices**, **event-driven systems**, and **production-ready observability setups**.  

---

## 🔹 Features  
- **IoT Sensor Data Ingestion** via REST APIs and Kafka topics.  
- **Data Persistence** using PostgreSQL/MySQL with Spring Data JPA.  
- **Distributed Tracing & Metrics** using OpenTelemetry + Spring Boot Actuator.  
- **Event-Driven Processing** with Apache Kafka.  
- **Validation & Exception Handling** for clean and secure APIs.  
- **Unit Testing** with JUnit & Mockito.  

---

## 🔹 Tech Stack  
- **Backend**: Java 17, Spring Boot 3, Spring Data JPA, Spring Kafka  
- **Databases**: PostgreSQL, MySQL  
- **Messaging**: Apache Kafka  
- **Observability**: OpenTelemetry, Spring Boot Actuator  
- **Build Tool**: Maven  
- **Testing**: JUnit, Mockito  

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




