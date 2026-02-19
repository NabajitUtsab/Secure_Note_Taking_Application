# Secure Note Taking Application 🔐

 

A ****secure RESTful note-taking web application**** built with ****Spring Boot**** and ****Spring Security****. 

Users can register, log in, create, read, update, and delete their personal encrypted notes (in future versions). Admins can view and manage all notes.

 
## Key security features:


\- Role-based access control (****ROLE_USER**** & ****ROLE_ADMIN****)

\- Stateless JWT-like Basic Auth (Base64 token returned on login)

\- BCrypt password hashing

\- Protected endpoints with *\`@PreAuthorize\`*

 

![Java](https://img.shields.io/badge/Java-17+-orange?style=for-the-badge\&logo=java\&logoColor=white)

![Spring Boot](https://img.shields.io/badge/Spring\_Boot-3.x-brightgreen?style=for-the-badge\&logo=spring\&logoColor=white)

![Spring Security](https://img.shields.io/badge/Spring\_Security-6.x-blue?style=for-the-badge\&logo=spring-security\&logoColor=white)

![Maven](https://img.shields.io/badge/Maven-3.8+-C71A36?style=for-the-badge\&logo=apache-maven\&logoColor=white)

 

## ✨ Features

 

\- User registration (*`/api/auth/register/user`*)

\- Admin registration (*`/api/auth/register/admin`*)

\- Basic authentication with role-based authorization

\- CRUD operations on personal notes (only owner can access/edit/delete)

\- Admin can view ****all**** notes and delete any note

\- Global exception handling

\- H2 console enabled for development (*`/h2-console`*)

 

## 🛠️ Tech Stack

 

\- ****Backend****: Spring Boot 3.x

\- ****Security****: Spring Security 6 (method security \+ http basic)

\- ****Database****: JPA / Hibernate (H2 in-memory by default – easy to switch to PostgreSQL/MySQL)

\- ****Build tool****: Maven

\- ****Authentication****: Basic Auth \+ BCrypt hashing

\- ****ORM****: Spring Data JPA

\- ****Java****: 17+

 

## 🚀 Quick Start

 

### Prerequisites

 

\- Java 17+

\- Maven 3.6+ (or use included Maven Wrapper)

 

### Run the application

 

 \- Clone the repo


      git clone https://github.com/NabajitUtsab/Secure_Note_Taking_Application.git

      cd Secure_Note_Taking_Application
  


 \- Build & run
     

     ./mvnw spring-boot:run



Application starts on: [**http://localhost:8080**](http://localhost:8080/)

## H2 Console (development only)

* URL: [http://localhost:8080/h2-console](http://localhost:8080/h2-console)  
* JDBC URL: jdbc:h2:mem:testdb (default – check application.properties if changed)  
* Username: sa  
* Password: (empty by default)

## 🔑 API Endpoints

**Authentication**

| Method | Endpoint | Description | Access |
| :---- | :---- | :---- | :---- |
| POST | /api/auth/register/user | Register normal user | Public |
| POST | /api/auth/register/admin | Register admin user | Public |

## Body example (JSON):

JSON

{

  "name": "john\_doe",

  "password": "strongPass123",

  "roles": \["ROLE\_USER"\]

}


## User Notes (ROLE_USER)

| Method | Endpoint | Description |
| :---- | :---- | :---- |
| GET | /api/notes | Get all my notes |
| GET | /api/notes/{id} | Get one note |
| POST | /api/notes | Create new note |
| PUT | /api/notes/{id} | Update note |
| DELETE | /api/notes/{id} | Delete note |

## Admin Endpoints (ROLE\_ADMIN)

| Method | Endpoint | Description |
| :---- | :---- | :---- |
| GET | /api/admin/notes | Get **all** notes |
| DELETE | /api/admin/notes/{id} | Delete any note |

## 📂 Project Structure (main parts)

text

src/main/java/com/example/Secure\_Note\_Taking\_Application/

├── configuration

│   └── SecurityConfig.java

├── controller

│   ├── RegistrationController.java

│   ├── UserController.java

│   └── AdminController.java

├── dto

│   ├── NoteRequest.java

│   ├── NoteResponse.java

│   └── RegisterRequest.java

├── entity

│   ├── AppUser.java

│   └── Note.java

├── repository

│   ├── AppUserRepo.java

│   └── NoteRepo.java

├── service

│   ├── RegistrationService.java

│   ├── LoginService.java

│   ├── UserService.java

│   ├── AdminService.java

│   └── CustomUserDetailsService.java

└── exceptionHandler

	└── GlobalExceptionHandler.java

## 🔐 Security Notes

* Passwords are hashed with **BCrypt**  
* Endpoints are protected with role checks  
* Session is **stateless**  
* CSRF disabled (suitable for API-only usage)  
* **Important**: Current login returns Base64(username:password) – in production replace with proper **JWT**

## 📌 Current Status

* **MVP stage** — basic CRUD \+ role-based security implemented  
* No frontend yet (API-only)  
* No proper JWT implementation yet (uses Basic Auth token)  
* Encryption of note content **planned** for future versions

 

