# 💰 Budget Tracker Appp

A secure, responsive, and full-featured personal expense tracking web application built with **Spring Boot**, **Spring Security**, **Thymeleaf**, and **MySQL**. This project helps users manage their budgets, track expenses, and log in with secure authentication.

---

## 🔗 Live Demo

🚧 _[Not deployed yet — to be added soon]_  
<!-- If deployed, add link like: https://budget-tracker-pooja.herokuapp.com -->

---

## 🧰 Tech Stack

- ✅ Java 17
- ✅ Spring Boot 3.5.3
- ✅ Spring Data JPA
- ✅ Spring Security (Custom login + Forgot password + Google OAuth planned)
- ✅ Thymeleaf
- ✅ MySQL
- ✅ Lombok
- ✅ Maven

---

## ✨ Features

- 🔐 User Registration & Custom Login
- 🔑 Forgot Password with Email Token & Reset Logic
- 📊 Add, View, Edit, Delete Expenses
- 📁 Categorize transactions
- 📌 Dashboard for quick stats
- 📅 Track expenses by date
- 📥 MySQL backend storage
- 🔐 Encrypted passwords using BCrypt
- 🌐 Responsive UI (HTML + CSS)

---

## 📸 Screenshots


## Folder Structure
in.pooja.budgettracker
├── controller
│ ├── AccountController.java
│ └── ExpenseController.java
├── model
│ ├── Account.java
│ └── Expense.java
├── repository
│ ├── AccountRepository.java
│ └── ExpenseRepository.java
├── service
│ ├── EmailService.java
│ └── UserDetailsServiceImpl.java
├── config
│ └── SecurityConfig.java
├── resources
│ ├── templates/
│ │ ├── login.html
│ │ ├── register.html
│ │ ├── dashboard.html
│ │ └── forgot-password.html
│ └── application.properties


---

## ⚙How to Run

1. **Clone this repo**
   ```bash
   git clone https://github.com/Pooja1212Saini/budget-tracker-app.git
   cd budget-tracker-app
2.CREATE DATABASE budget_app;
3.Update application.properties

properties
Copy code
spring.datasource.username=YOUR_DB_USER
spring.datasource.password=YOUR_DB_PASS

4.Run the app
Copy code
./mvnw spring-boot:run

5.Open in browser:
http://localhost:8080/login

📩 Forgot Password Feature
Enter email in "Forgot Password"

A tokenized reset link is sent via Gmail
User resets password → redirected to login
Working with real Gmail credentials using App Password

📌 Upcoming Features
.Google OAuth Login
.Budget limit alerts
.Monthly stats chart
.Responsive mobile UI
.PDF/Excel Export of transactions
.Dark Mode Toggle

🙋‍♀️ About Me
I'm Pooja Saini, a final-year CSE student passionate about backend development and building real-world projects in Java.




