# 📚 E-Shop: Electronic Shopping Mall System

## Overview
E-Shop is an online shopping platform for purchasing programming-related books. Developed with **Java EE**, it features a structured **front-end** and **back-end** system, allowing users to browse, purchase, and manage book orders efficiently. Admins have additional privileges for website maintenance and database management.

## 🔧 Tech Stack
- **Front-End:** HTML, CSS, JavaScript, jQuery, Ajax  
- **Back-End:** Java EE, JSP, Servlet  
- **Database:** MySQL 8.0  
- **Server:** Tomcat v9.0.56  
- **Development Tools:** Eclipse  
- **Packages Used:** `jstl-1.2.jar`, `smartupload.jar`, `mysql-connector-java-8.0.27.jar`

## 🎯 Features

### 🔹 User Functionalities (Customers)
- **Register/Login/Logout**
- **Browse books** by category
- **Add to cart** and modify items
- **Purchase books** and view order history
- **Modify shipping address**

### 🔹 Admin Functionalities
- **Manage customers** (view/update details)
- **Modify product categories** and book details
- **Monitor orders** and website operations

### 🔹 Security & Enhancements
- **AJAX Implementation:** Prevents duplicate user registration & cart overloading  
- **Access Control:** Restricts user operations with filters  
- **Role-Based Access:** Only admins can access backend functionalities  
- **User Privacy Protection:** Customers can only see their own personal information  

## 🏗 Project Structure
- **MVC Pattern** for maintainability & scalability  
- **Responsive UI** similar to popular shopping platforms (e.g., Amazon)  
- **Advanced search & structured categories** for easy navigation  

## 🚀 Getting Started

### Prerequisites
- Install **Eclipse** IDE
- Setup **Tomcat v9.0.56** server
- Install **MySQL 8.0**
- Configure database connection in `mysql-connector-java-8.0.27.jar`

### Installation
1. Clone this repository:
   ```bash
   git clone https://github.com/yourusername/e-shop.git
   ```
## Project Design
### Project Architecture
![Project Architecture](images/ProjectArchitecture.png)

### Database Relation Diagram
![Relation Diagram](images/DatabaseRelationDiagram.png)

### MVC Pattern
![MVCPattern1](images/MVCPattern1.png)
![MVCPattern2](images/MVVPattern2.png)

### MVC Package Structure
![MVC Package Diagram](images/PackageDiagramMVC.png)

### Use Case Diagrams and Sequence Diagrams for Clients
#### User Login
![User Login Use Case](images/UseCaseUserLogin.jpg)
![User Login Sequence Diagram](images/SequenceDiagramUserLogin.png)

#### Personal Center
![Personal Center Use Case](images/UseCasePersonalCenter.png)
![Personal Center Sequence Diagram](images/SequencePersonalCenter.jpg)

#### Order Management
![Order Management Use Case](images/UseCaseOrderManagement.png)
![Order Management Sequence Diagram](images/SequenceOrderManagement.png)

#### Checkout
![Checkout Use Case](images/UseCaseCheckOut.jpg)
![Checkout Sequence Diagram](images/SequenceCheckOut.png)

#### Cart Management
![Cart Management Use Case](images/UseCaseCartManagement.jpg)
![Cart Management Sequence Diagram](images/SequenceCartManagement.png)

#### Book Display
![Book Display Use Case](images/UseCaseBookDisplay.png)
![Book Display Sequence Diagram](images/SequenceBookDisplay.png)

### Use Case Diagrams for Admin
#### User Management
![User Management Use Case](images/UseCaseUserManagement.jpg)

#### Book Management
![Book Management Use Case](images/UseCaseBookManagement.jpg)

#### Category Management
![Category Management Use Case](images/UseCaseCategoryManagement.jpg)

## 🎨 User Interface (UI) Screenshots

### 🔹 Authentication & User Management
#### User Login
![User Login UI](images/UI_login.jpg)

#### User Registration
![User Registration UI](images/UI_register.jpg)

#### Reset Password
![Reset Password UI](images/UI_reset_password.png)

#### User Management (Admin)
![User Management UI](images/UI_user_management.png)

---

### 🔹 Admin Panel
#### Admin Login
![Admin Login UI](images/UI_admin_login.png)

#### Admin Menu
![Admin Menu UI](images/UI_admin_menu.png)

#### Product Management
![Product Management UI](images/UI_product_management.png)

#### Category Management
![Category Management UI](images/UI_category_management.png)

---

### 🔹 Shopping & Orders
#### Product List
![Product List UI](images/UI_product_list.png)

#### Product Detail
![Product Detail UI](images/UI_product_detail.png)

#### Search Product
![Search Product UI](images/UI_search_product.png)

#### Shopping Cart
![Shopping Cart UI](images/UI_cart.jpg)
![Shopping Cart UI](images/UI_cart.png)

#### Payment
![Payment UI](images/UI_payment.jpg)

#### Order Management
![Order Management UI](images/UI_order.png)

#### Paid Orders
![Paid Orders UI](images/UI_paid_order.png)

#### Order Confirmation
![Order Confirmation UI](images/UI_order_confirmation.png)

#### Manage Address
![Manage Address UI](images/UI_manage_address.png)


