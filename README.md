# 🚀 Employee Management System

![Java](https://img.shields.io/badge/Java-21-orange)
![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.5-brightgreen)
![Spring Security](https://img.shields.io/badge/Security-JWT-success)
![MySQL](https://img.shields.io/badge/Database-MySQL-blue)
![Swagger](https://img.shields.io/badge/API-Swagger-green)
![Maven](https://img.shields.io/badge/Build-Maven-red)
![License](https://img.shields.io/badge/License-MIT-lightgrey)

A production-ready **Employee Management System REST API** built using **Java 21, Spring Boot 3, Spring Security (JWT), Hibernate, MySQL, and Swagger/OpenAPI**.

The application provides secure REST APIs for managing employees, departments, attendance, leave requests, payroll, and dashboard analytics using **JWT Authentication** and **Role-Based Access Control (RBAC)**. It is deployed on **Railway** and can be explored through the hosted **Swagger UI**.

---

## 🚀 Live Demo

### 🌐 Railway Deployment (Swagger UI)

🔗 **Live Swagger UI**

https://employee-management-system-production-5028.up.railway.app/swagger-ui/index.html

📂 **GitHub Repository**

https://github.com/leelamotakatla-08/employee-management-system

> Recruiters can explore and test the deployed REST APIs directly from the browser without any local setup.

---

## ✨ Features

- 🔐 JWT Authentication & Role-Based Authorization
- 👥 Employee & Department Management (CRUD)
- 📅 Attendance & Leave Management
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

## 🏗 Architecture

```text
Client
   │
Swagger UI / Postman
   │
Spring Security (JWT)
   │
Controllers
   │
Services
   │
Repositories
   │
MySQL Database
```

---

## 🚀 Getting Started

Clone the repository:

```bash
git clone https://github.com/leelamotakatla-08/employee-management-system.git
cd employee-management-system
```

Create the database:

```sql
CREATE DATABASE employee_management;
```

Configure environment variables:

```properties
SPRING_DATASOURCE_URL=jdbc:mysql://localhost:3306/employee_management
SPRING_DATASOURCE_USERNAME=root
SPRING_DATASOURCE_PASSWORD=your_password
JWT_SECRET=your_secure_secret_key
JWT_EXPIRATION=86400000
```

Build and run:

```bash
./mvnw clean install
./mvnw spring-boot:run
```

Open Swagger locally:

```text
http://localhost:8080/swagger-ui/index.html
```

---

## 📸 Screenshots

### Swagger UI

![](images/swagger-home.png)

### API Schemas

![](images/swagger-schemas.png)

### JWT Authentication

![](images/jwt-authentication.png)

### Dashboard APIs

![](images/dashboard-api.png)

### Postman Testing

![](images/postman-authentication.png)

---

## 💡 Skills Demonstrated

- Spring Boot & REST API Development
- Spring Security with JWT Authentication
- Spring Data JPA & Hibernate
- MySQL Database Integration
- Layered Architecture & DTO Pattern
- Bean Validation & Exception Handling
- Swagger/OpenAPI Documentation
- Git & GitHub Version Control
- Railway Cloud Deployment

---

## 👩‍💻 Author

**Motakatla Leela Vardhini**

🎓 B.Tech – Computer Science & Engineering  
💻 Aspiring Software Developer

---

⭐ **If you found this project useful, consider giving it a Star on GitHub!**