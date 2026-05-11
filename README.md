# 🚌 Yuvayatraa Backend — Spring Boot REST API

Backend API for Yuvayatraa bus booking application.

## 🛠️ Tech Stack
- Java 21
- Spring Boot 4.0.5
- Spring Security 7 + JWT
- PostgreSQL 16
- Hibernate ORM
- Maven

## 🔗 Frontend Repo
https://github.com/yuvasri12/yuvayatraa-frontend

## 🚀 Run Locally

### Prerequisites
- Java 21
- PostgreSQL 16
- Maven

### Setup
Update `src/main/resources/application.properties`:
```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/yuvayatraa_db
spring.datasource.username=postgres
spring.datasource.password=YOUR_PASSWORD
jwt.secret=yuvayatraa_super_secret_key_2024
jwt.expiration=86400000
```

### Run
```bash
mvn spring-boot:run
```
API runs on: `http://localhost:8080`

## 🔗 API Endpoints
| Method | Endpoint | Description |
|--------|----------|-------------|
| POST | /api/auth/register | Register |
| POST | /api/auth/login | Login |
| GET | /api/buses | Get buses |
| POST | /api/buses/admin/add | Add bus |
| GET | /api/routes | Get routes |
| GET | /api/routes/search | Search routes |
| POST | /api/bookings | Create booking |
| GET | /api/bookings/my-bookings | My bookings |

## 👨‍💻 Developer
**Yuva Sri S** — GitHub: [@yuvasri12](https://github.com/yuvasri12)
