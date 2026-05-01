# 🚀 Full Stack Project Management Application

A full-stack web application to manage projects, tasks, and team collaboration efficiently. The platform allows users to create projects, assign tasks, track progress, and communicate within teams.

---

## 🌐 Live Demo

https://projectmanagentapp-frontend.onrender.com/


---

## 📌 Overview

This is a full-stack application built using modern technologies:

* Backend powered by Spring Boot
* Frontend built with React.js
* Secure authentication using JWT & OAuth2
* MySQL database for persistent storage

Such applications are commonly used to **manage projects, teams, and workflows in real-time environments** ([GitHub][1])

---

## ✨ Features

### 🔐 Authentication & Security

* JWT-based authentication
* OAuth2 login (Google)
* Role-based authorization
* Secure password hashing

---

### 📁 Project Management

* Create, update, delete projects
* Assign users to projects
* Track project ownership

---

### ✅ Task / Issue Management

* Create and assign tasks
* Set priority & status
* Track task lifecycle

---

### 💬 Collaboration

* Comments on tasks
* Chat system for communication
* Invite users to projects

---

### 📧 Email Integration

* Password reset emails
* Project invitations
* SMTP-based email service

---

### 📊 Subscription System

* Manage user subscriptions
* Track plan validity

---

## 🛠️ Tech Stack

### Backend

* Java Spring Boot
* Spring Security
* JWT Authentication
* OAuth2
* SMTP Email Service
* MySQL

---

### Frontend

* React.js
* shadcn/ui
* Axios
* useReducer (state management)

---

## 🗄️ Database Schema

Core tables:

* users_table
* project_table
* issue_table
* comments_table
* chat & message
* invitation_table
* subscription
* password_reset_token

---

## ⚙️ Backend Setup (Spring Boot)

```bash
cd backend
mvn clean install
mvn spring-boot:run
```

### application.properties

```properties
server.port=5000

spring.datasource.url=jdbc:mysql://localhost:3306/your_db
spring.datasource.username=root
spring.datasource.password=your_password

spring.jpa.hibernate.ddl-auto=update

jwt.secret=your_secret_key

# SMTP
spring.mail.host=smtp.gmail.com
spring.mail.port=587
spring.mail.username=your_email
spring.mail.password=your_password
```

---

## ⚙️ Frontend Setup (React)

```bash
cd frontend
npm install
npm start
```

---

## 🎨 UI Setup

```bash
npx shadcn-ui@latest init
```

---

## 🔄 API Integration (Axios)

```js
import axios from "axios";

const API = axios.create({
  baseURL: process.env.REACT_APP_API_URL,
});

API.interceptors.request.use((req) => {
  const token = localStorage.getItem("token");
  if (token) req.headers.Authorization = `Bearer ${token}`;
  return req;
});

export default API;
```

---

## 🚀 Deployment

* Backend → Railway
* Frontend → Render
* Database → Railway (MySQL)

---

## ⚠️ Known Issue (Email Service)

### 🚫 Problem

Email functionality does NOT work in production due to free-tier restrictions:

* SMTP ports (25, 465, 587) are blocked
* Email sending fails on deployed server

---

### ✅ Works Locally

* Email service works perfectly on local machine
* Password reset and invitation emails function correctly

---

### 💡 Recommended Solution

Use API-based email services instead of SMTP:

* SendGrid
* Mailgun
* Resend

---

## 📦 Environment Variables

### Backend

```
DB_URL=
DB_USERNAME=
DB_PASSWORD=
JWT_SECRET=
MAIL_USERNAME=
MAIL_PASSWORD=
```

### Frontend

```
REACT_APP_API_URL=
```

---

## 🔮 Future Enhancements

* Real-time updates (WebSockets)
* Notifications system
* File uploads
* Advanced analytics

---

## 🤝 Contribution

Feel free to fork and contribute.

---

## 📄 License

MIT License

[1]: https://github.com/SashenJayathilaka/Project-Management-App?utm_source=chatgpt.com "️ Project Management App (Full Stack + AWS)"
