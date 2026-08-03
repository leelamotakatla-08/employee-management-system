# 🚀 Employee Management System

![Java](https://img.shields.io/badge/Java-21-orange)
![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.5-brightgreen)
![Spring Security](https://img.shields.io/badge/Security-JWT-success)
![MySQL](https://img.shields.io/badge/Database-MySQL-blue)
![Swagger](https://img.shields.io/badge/API-Swagger-green)
![Maven](https://img.shields.io/badge/Build-Maven-red)
![License](https://img.shields.io/badge/License-MIT-lightgrey)

Production-ready **Employee Management System REST API** built with **Java 21, Spring Boot 3, Spring Security (JWT), Hibernate, MySQL, and Swagger/OpenAPI**.

The application provides secure REST APIs for managing employees, departments, attendance, leave, payroll, and dashboard analytics using **JWT Authentication** and **Role-Based Access Control (RBAC)**. It is deployed on **Railway** with an interactive **Swagger UI** for live API testing.

---

## 🌐 Live Demo

🚆 **Railway Deployment**

**🔗 Live Swagger UI**

https://employee-management-system-production-5028.up.railway.app/swagger-ui/index.html

> Explore and test the deployed REST APIs directly from your browser.

---

## ✨ Features

- 🔐 JWT Authentication & RBAC
- 👥 Employee CRUD
- 🏢 Department CRUD
- 📅 Attendance Tracking
- 🌴 Leave Management
- 💰 Payroll Management
- 📊 Dashboard Analytics
- 🔒 BCrypt Password Encryption
- ✅ Bean Validation & Global Exception Handling
- 📖 Interactive Swagger/OpenAPI Documentation
- 🧱 Layered Architecture (Controller → Service → Repository)

---

## 🛠 Tech Stack

| Category | Technology |
|-----------|------------|
| Language | Java 21 |
| Framework | Spring Boot 3 |
| Security | Spring Security + JWT |
| Database | MySQL |
| ORM | Spring Data JPA + Hibernate |
| Documentation | Swagger / OpenAPI |
| Build Tool | Maven |
| Testing | Swagger UI & Postman |

---

## 📊 Project Metrics

| Metric | Value |
|---------|------:|
| Business Modules | 7 |
| Controllers | 8 |
| Entities | 10 |
| Repository Interfaces | 8 |
| Java Classes | 68+ |
| Authentication | JWT |
| Deployment | Railway |

---

## 🏗 Architecture

```text
Client
   │
Swagger UI / Postman
   │
Spring Security (JWT)
   │
Controller
   │
Service
   │
Repository
   │
MySQL
```

---

## 🚀 Getting Started

Clone the repository

```bash
git clone https://github.com/leelamotakatla-08/employee-management-system.git
cd employee-management-system
```

Create the database

```sql
CREATE DATABASE employee_management;
```

Configure environment variables

```properties
SPRING_DATASOURCE_URL=jdbc:mysql://localhost:3306/employee_management
SPRING_DATASOURCE_USERNAME=root
SPRING_DATASOURCE_PASSWORD=your_password
JWT_SECRET=your_secure_secret_key
JWT_EXPIRATION=86400000
```

Build and run

```bash
./mvnw clean install
./mvnw spring-boot:run
```

Local Swagger

```text
http://localhost:8080/swagger-ui/index.html
```

---

## 📸 Screenshots

| Swagger UI | API Schemas |
|------------|-------------|
| ![](images/swagger-home.png) | ![](images/swagger-schemas.png) |

| JWT Authentication | Dashboard APIs |
|--------------------|----------------|
| ![](images/jwt-authentication.png) | ![](images/dashboard-api.png) |

| Postman Testing |
|-----------------|
| ![](images/postman-authentication.png) |

---

## 💡 Skills Demonstrated

- Java 21
- Spring Boot
- Spring Security (JWT)
- REST API Development
- Spring Data JPA & Hibernate
- MySQL
- Bean Validation & Exception Handling
- Swagger/OpenAPI
- Git & GitHub
- Railway Deployment

---

## 👩‍💻 Author

**Motakatla Leela Vardhini**

🎓 B.Tech – Computer Science & Engineering

💻 Aspiring Software Developer

---

⭐ **If you found this project useful, consider giving it a Star on GitHub!**