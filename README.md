# Dealer & Vehicle Management API

A RESTful API built with Spring Boot for managing dealers and their vehicles, including a payment gateway simulation system.

## 🚀 Features

- **Dealer Management**: Complete CRUD operations for dealer entities
- **Vehicle Management**: Full vehicle lifecycle management with dealer association
- **Premium Dealer Filter**: Specialized endpoint for premium dealer vehicles
- **Payment Gateway Simulation**: Asynchronous payment processing with status updates
- **Database Integration**: PostgreSQL with JPA/Hibernate
- **API Documentation**: Swagger/Postman

## 🛠 Tech Stack

- **Framework**: Spring Boot 3.x
- **Language**: Java 17+
- **Database**: PostgreSQL
- **ORM**: Spring Data JPA / Hibernate
- **Security**: Spring Security + JWT
- **Build Tool**: Maven
- **Deployment**: Render

## 📋 Prerequisites

- Java 21 or higher
- Maven 3.6+
- PostgreSQL 12+
- Git

## 🏗 Project Structure

```
src/
├── main/
│   ├── java/com/dealership/
│   │   ├── controller/          # REST Controllers
│   │   ├── entity/             # JPA Entities
│   │   ├── repository/         # Data Repositories
│   │   ├── service/            # Business Logic          
│   │   └── TaskApplication.java
│   └── resources/
│       ├── application.properties
```

## 🔧 Installation & Setup

### 1. Clone the Repository
```bash
git clone https:[//github.com/pranay-27/dealerVehicleManagement]
```

### 3. Build and Run
```bash
mvn clean install
mvn spring-boot:run
```

The application will start on `http://localhost:8080`

## 📡 API Endpoints

### Dealer Management
| Method | Endpoint | Description |
|--------|----------|-------------|
| GET | `/api/dealers` | Get all dealers |
| GET | `/api/dealers/{id}` | Get dealer by ID |
| POST | `/api/dealers` | Create new dealer |
| GET | `/api/dealers/premium` | Premium dealers |
| DELETE | `/api/dealers/{id}` | Delete dealer |

### Vehicle Management
| Method | Endpoint | Description |
|--------|----------|-------------|
| GET | `/api/vehicles` | Get all vehicles |
| GET | `/api/vehicles/{id}` | Get vehicle by ID |
| POST | `/api/vehicles?dealerId={dealerId}` | Create new vehicle |
| DELETE | `/api/vehicles/{id}` | Delete vehicle |
| GET | `/api/vehicles/premium` | Get vehicles of premium dealers only |

### Payment Gateway
| Method | Endpoint | Description |
|--------|----------|-------------|
| POST | `/api/payment/initiate?dealerId={dealerId}` | Initiate payment |
| GET | `/api/payments` | Get All Payments |

## 📝 Sample API Requests

### Create Dealer
```json
POST /api/dealers
{
    "name": "John's Auto Dealership",
    "email": "john@autoDealer.com",
    "subscriptionType": "PREMIUM"
}
```

### Create Vehicle
```json
POST /api/vehicles
{
    "dealerId": 1,
    "model": "Toyota Camry 2024",
    "price": 25000.00,
    "status": "AVAILABLE"
}
```

### Initiate Payment
```json
POST /api/payment/initiate
{
    "dealerId": 1,
    "amount": 999.99,
    "method": "UPI"
}
```
## 🚀 Deployment

### Live Application
- **Base URL**: `[https://dealervehiclemanagement.onrender.com]`


### Postman Collection
Import the Postman collection file: `Dealer-Vehicle-API.postman_collection.json`

## 📋 Key Features Implemented

### Task 1: Dealer & Vehicle Management
- ✅ Complete CRUD operations for Dealers and Vehicles
- ✅ Proper entity relationships (Foreign Key)
- ✅ Premium dealers vehicle filtering endpoint
- ✅ PostgreSQL integration with JPA
- ✅ Proper error handling and validation

### Task 2: Payment Gateway Simulation
- ✅ Payment initiation endpoint
- ✅ Asynchronous status update (5-second delay)
- ✅ Multiple payment methods support
- ✅ Payment history tracking

## 🔍 Code Quality Features

- **Exception Handling**: Global exception handler with proper HTTP status codes
- **Service Layer**: Clean separation of concerns
- **Repository Pattern**: Spring Data JPA repositories

## 👨‍💻 Author

**Your Name**
- GitHub: [@pranay-27](https://github.com/pranay-27)
- LinkedIn: [ammulapranay]([https://www.linkedin.com/in/pranayammula/)
- Email: ammulapranay46.com
