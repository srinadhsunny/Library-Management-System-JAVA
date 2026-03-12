Library Management System (J2EE)
A web-based application to manage library records efficiently.
This project implements full CRUD (Create, Read, Update, Delete) functionality using Java Servlets and JDBC, featuring a modern Glassmorphism UI.

Tech Stack Used
Backend: Java (JDK 8+), Servlets

Frontend: JSP, HTML5, CSS3 (Glassmorphism design)

Database: MySQL

Server: Apache Tomcat 9.0

Architecture: DAO (Data Access Object) Pattern

What I Developed
Dashboard: A centralized navigation home page with a modern "Extraordinary" theme.

Add Book: A form to capture book names, quantity, and author details, processed via saveservlet.

View List: A dynamic table that fetches all records from the MySQL database using geekUserDao.

Edit/Update: A multi-step update process (EditServlet and EditServlet2) to modify existing book details.

Delete: A quick-action feature to remove records with automatic list refreshing.

UI/UX: Implemented a unified "Frosted Glass" look across all Servlets using CSS backdrop-filter and rgba transparency.

Database Table Structure
The project uses a MySQL table named books with the following columns:

bookId - INT (Primary Key)

bookname - VARCHAR

numberOfbooks - INT

author - VARCHAR
