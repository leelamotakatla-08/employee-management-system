# 🚀 Employee Management System

![Java](https://img.shields.io/badge/Java-21-orange)
![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3-brightgreen)
![Spring Security](https://img.shields.io/badge/Security-JWT-success)
![MySQL](https://img.shields.io/badge/Database-MySQL-blue)
![Swagger](https://img.shields.io/badge/API-Swagger-green)
![Maven](https://img.shields.io/badge/Build-Maven-red)

A production-ready **Employee Management System REST API** built using **Spring Boot 3**, **Spring Security (JWT)**, **MySQL**, **Hibernate**, and **Swagger/OpenAPI**.

The application enables organizations to securely manage employees, departments, attendance, leave requests, payroll, and dashboard analytics through secure REST APIs with role-based access control.

---

# 🎯 Highlights

- RESTful API built using Spring Boot 3
- JWT Authentication & Role-Based Authorization
- Secure CRUD operations across Employee, Department, Attendance, Leave, Payroll, and Dashboard modules
- Interactive API documentation using Swagger UI
- Layered Architecture with DTO Pattern
- Manual API testing using Swagger UI and Postman

---

# ✨ Features

- 🔐 JWT Authentication & Authorization
- 👥 Employee CRUD Operations
- 🏢 Department CRUD Operations
- 📅 Attendance Management
- 🌴 Leave Management (Apply, Approve & Reject)
- 💰 Payroll Management with Automatic Net Salary Calculation
- 📊 Dashboard Analytics & Reports
- 🔒 Password Encryption using BCrypt
- ✅ Bean Validation (Jakarta Validation)
- ✅ Global Exception Handling
- ✅ DTO Pattern & Layered Architecture
- ✅ Interactive Swagger API Documentation

---

# 📈 Project Highlights

| Metric | Details |
|----------|---------|
| Business Modules | 7 |
| Security | JWT Authentication & Role-Based Access |
| Database | MySQL |
| API Documentation | Swagger / OpenAPI |
| Testing | Swagger UI & Postman |
| Build Tool | Maven |

---

# 🛠 Tech Stack

| Category | Technology |
|-----------|------------|
| Language | Java 21 |
| Framework | Spring Boot 3 |
| Security | Spring Security + JWT |
| Database | MySQL |
| ORM | Spring Data JPA + Hibernate |
| Documentation | Swagger / OpenAPI |
| Build Tool | Maven |
| Testing | Postman, Swagger UI |

---

# 📸 Project Screenshots

## 🔹 Swagger API Documentation

![Swagger Home](images/swagger-home.png)

Interactive API documentation with secured REST APIs.

---

## 🔹 API Documentation & Schemas

![Swagger Schemas](images/swagger-schemas.png)

Automatically generated request and response models using OpenAPI.

---

## 🔹 JWT Authentication

![JWT Authentication](images/swagger-jwt-authentication.png)

Authenticate secured APIs directly from Swagger using a Bearer Token.

---

## 🔹 Dashboard & Authentication APIs

![Dashboard APIs](images/swagger-dashboard-auth.png)

Dashboard analytics and authentication endpoints.

---

## 🔹 API Testing using Postman

![Postman](images/postman-login-success.png)

Successful login and JWT token generation tested using Postman.

---

# 📦 Modules

| Module | Features |
|----------|----------|
| Authentication | User Registration & Login |
| Employee | Employee CRUD Operations |
| Department | Department CRUD Operations |
| Attendance | Attendance Tracking |
| Leave | Apply, Approve & Reject Leave |
| Payroll | Payroll CRUD & Net Salary Calculation |
| Dashboard | Employee, Attendance, Leave & Payroll Analytics |

---

# 🚀 Getting Started

## Clone the Repository

```bash
git clone https://github.com/yourusername/employee-management-system.git

cd employee-management-system
```

## Create the Database

```sql
CREATE DATABASE employee_management;
```

## Configure the Database

Update your MySQL credentials in **application.properties**.

## Build & Run

```bash
./mvnw clean install

./mvnw spring-boot:run
```

Application runs at:

```
http://localhost:8080
```

---

# 📚 Swagger Documentation

Open the following URL after starting the application:

```
http://localhost:8080/swagger-ui/index.html
```

Swagger provides:

- Interactive API Testing
- JWT Authentication Support
- Request & Response Models
- Complete REST API Documentation

---

# 🚀 Future Enhancements

- Docker Containerization
- React Frontend
- AWS Deployment
- CI/CD using GitHub Actions

---

# 👩‍💻 Author

**Motakatla Leela Vardhini**

B.Tech – Computer Science & Engineering

Aspiring Software Development Engineer

---

# ⭐ Support

If you found this project useful, consider giving it a ⭐ **Star** on GitHub.