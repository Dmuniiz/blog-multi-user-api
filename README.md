# Blog Platform (Java + Spring Boot)
A secure and structured backend application for a multi-user blog platform. Built using Java 21 and Spring Boot, this project focuses on authentication, clean architecture, and well-documented code.

## 🛠 Tech Stack
Java 21 <br>
Spring Boot <br>
Spring Security + JWT <br>
Spring Data JPA <br>
PostgreSQL <br>
MapStruct Lib <br>
Lombok <br>
Docker <br>
Maven <br>

## Features
JWT-based authentication with login and registration endpoints <br>
Spring Security filter chain to secure all protected routes <br>
Stateless request handling with custom JWT extraction and validation <br>
Global Exception Handling for better error messaging and control <br><br>
Support for multiple users: <br>
Create, edit, and delete blog posts <br>
Save drafts or publish blogs <br>
Assign a category to each blog <br>
Add up to 10 tags per blog <br><br>
Automatic reading time calculation <br>
DTOs used for requests, responses, and internal data transfer <br>
MapStruct for clean mapping between DTOs and entities <br>
Clean modular folder structure following best practices <br>

## Secrets & Passwords
Before running, make sure that you have 2 environment variables set up: DB_USER, DB_PASSWORD (I have set them up using a .env file) <br>
These are needed in docker-compose.yml & src > main > resources > application.properties
<br>
## User creation
To create new users access this file: <br> src > main > java > com...Blog_Platgorm > config > SecurityConfig.java > userDetailsService
Enter the email or password according to your wish and run the application to save it into your database

## Frontend
To run the frontend navigate to frontend directory in your terminal then do these 2 steps:  <br>
npm install (ignore the warnings) <br>
npm run dev

