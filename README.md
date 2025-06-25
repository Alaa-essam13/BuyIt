# BuyIt
# 🛒 E-Commerce Backend System

A complete **backend system for an e-commerce platform** built with **Spring Boot**, **JPA**, and **Hibernate**. It provides core functionalities for users, shopping carts, product management, orders, payments, and reviews.

---

## 📌 Features

✅ **User Management**  
➡️ Register, login, and manage user accounts securely.

✅ **Shopping Cart**  
➡️ Each user has a unique cart with cart items linked to products.

✅ **Order System**  
➡️ Users can place orders based on their carts with multiple items per order.

✅ **Payments**  
➡️ Support for various payment methods linked to orders.

✅ **Product Catalog**  
➡️ Organized by categories and brands, including reviews and stock management.

✅ **Address Management**  
➡️ Users can manage delivery addresses.

✅ **Product Reviews**  
➡️ Users can leave ratings and comments on products.

---

## 🗂️ Entity Relationship

Relational design using JPA with mapped relationships:
User → Cart → CartItem → Product
Order → OrderItem → Product
Product → Brand / Category / Review
User → Address
Order → Payment


---
## ERD

![erd](https://github.com/user-attachments/assets/85d31ade-481f-462a-aa5f-054191fd689b)

---
## ⚙️ Tech Stack

- 🧠 **Java 17**
- ⚙️ **Spring Boot**
- 🗃 **Spring Data JPA**
- 🐘 **PostgreSQL**
- 🧵 **Lombok**
- 🔐 **Spring Security + JWT**
- 🌐 **REST API** (JSON via Jackson)
- 💾 **Redis**

---

## 🚀 Performance Optimizations

- 📌 Used `@EntityGraph` to reduce the N+1 query problem.
- ⏳ Lazy loading and fetch strategies for optimal performance.

---

## 📁 Structure

📦 src
┣ 📂 entity
┣ 📂 repository
┣ 📂 service
┣ 📂 controller
┣ 📂 error
┗ 📂 dto / config / util


---

## 📮 Future Improvements

- 🔐 Add full JWT-based authentication
- 📦 Dockerize the application
- 🧪 Add integration & unit tests
- 🧾 Swagger API documentation

---

## 🧑‍💻 Author

Developed by Alaa Essam – Junior Java Backend Developer 🚀






