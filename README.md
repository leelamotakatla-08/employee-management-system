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
| Testing | Swagger UI & Postman |

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

![JWT Authentication](images/jwt-authentication.png)

Authenticate secured APIs directly from Swagger using a Bearer Token.

---

## 🔹 Dashboard & Authentication APIs

![Dashboard APIs](images/dashboard-api.png)

Dashboard analytics and authentication endpoints.

---

## 🔹 API Testing using Postman

![Postman](images/postman-authentication.png)

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
git clone https://github.com/leelamotakatla-08/employee-management-system.git

cd employee-management-system
```

---

## Create the Database

```sql
CREATE DATABASE employee_management;
```

---

## Configure the Database

Update your MySQL credentials in:

```properties
src/main/resources/application.properties
```

Example:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/employee_management
spring.datasource.username=root
spring.datasource.password=your_password
```

---

## Build the Project

```bash
./mvnw clean install
```

---

## Run the Application

```bash
./mvnw spring-boot:run
```

The application will start on:

```
http://localhost:8080
```

---

# 📚 Swagger Documentation

After starting the application, open:

```
http://localhost:8080/swagger-ui/index.html
```

Swagger provides:

- Interactive API Testing
- JWT Authentication Support
- Request & Response Models
- Complete REST API Documentation

---

# 🔐 Authentication

This project uses **JWT (JSON Web Token)** authentication.

### Authentication Flow

1. Register a new user.
2. Login using registered credentials.
3. Receive a JWT token.
4. Click the **Authorize** button in Swagger UI.
5. Enter:

```
Bearer <your_jwt_token>
```

6. Access secured APIs.

---

# 📁 Project Structure

```
src
├── controller
├── service
│   └── impl
├── repository
├── entity
├── dto
├── mapper
├── config
├── security
├── exception
└── EmployeeManagementSystemApplication.java
```

---

# 🚀 Future Enhancements

- Docker Containerization
- React Frontend
- AWS Deployment
- CI/CD using GitHub Actions
- Unit & Integration Testing
- Email Notifications
- File Upload for Employee Profiles

---

# 👩‍💻 Author

**Motakatla Leela Vardhini**

🎓 B.Tech – Computer Science & Engineering

💻 Aspiring Java Full Stack Developer

🌱 Passionate about Spring Boot, REST APIs, and Backend Development

---

# ⭐ Support

If you found this project useful, please consider giving it a ⭐ on GitHub.

It helps others discover the project and motivates future improvements.