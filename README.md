# SmartCart Microservices  
> A microservices-based backend for a shopping cart system

## 🚀 Project Overview  
SmartCart Microservices is a modular, service-oriented backend architecture for an e-commerce/cart system, built using Java and Docker.  
It comprises multiple independent services (product, order, customer, API gateway) which communicate and can be scaled or deployed independently.

## 🧱 Architecture & Components  
The repository includes the following modules:  
- **api-gateway** – the entry point / gateway for all external traffic  
- **product-service** – manages products (catalog, inventory, etc)  
- **order-service** – handles orders, line-items, order lifecycle  
- **customer-service** – manages customer accounts, profiles  
- **http-requests** – (utility / sample client or HTTP-wrapper module)  

## 🛠️ Tech Stack  
- Java (Spring Boot / Spring Cloud, as appropriate)  
- Docker & Docker Compose for containerization and orchestration  
- Microservices architecture (each service runs independently)  
- RESTful APIs
- gRPC
- PostgreSQL
- API Gateway 

## ✅ Getting Started  
Follow these steps to get the project running locally:
1. Clone the repository:  
   git clone https://github.com/xilaniam/SmartCart_Microservices.git
   cd SmartCart_Microservices
   
2.Build all modules (from root):
  ./mvnw clean install
  
3.Start all the services using Docker Compose:
  docker-compose up --build
  
4.Visit the API gateway (by default):
http://localhost:7000

🔍 Usage & Examples
The usage and examples are on the http-request folder

📝 Project Status & Roadmap
Current status: Prototype.
Planned next steps:

🔲 Kafka

🔲 Add API documentation (Swagger/OpenAPI)

🔲 Add authentication & authorization (JWT/OAuth2)

🔲 Add monitoring & logging (Prometheus/Grafana, ELK stack)

🔲 Add deployment pipeline (GitHub Actions / Jenkins)

👥 Contributing
Contributions are welcome! To contribute:

📄 License
This project is licensed under the MIT License.
