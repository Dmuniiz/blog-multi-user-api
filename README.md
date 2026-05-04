# 📝 Blog Platform

A robust and secure multi-user blog platform built with a modular and modern architecture. This project features a **Java 21** and **Spring Boot** backend, paired with a dynamic **React** frontend served via **Nginx**, all orchestrated using **Docker**.

## 🛠 Tech Stack

*   **Backend:** Java 21, Spring Boot 3, Spring Security, JWT, Spring Data JPA, Hibernate, MapStruct, Lombok, Maven.
*   **Frontend:** React, Vite, TypeScript.
*   **Infrastructure:** Docker, Docker Compose, Nginx.
*   **Database:** PostgreSQL 16.

## 🚀 Getting Started

The simplest way to run the entire stack (Frontend, Backend, and Database) is using **Docker Compose**, which automatically configures all networking and dependencies.

### 📋 Prerequisites
*   [Docker Desktop](https://docker.com) installed and running.

### 🛠️ Step-by-Step Setup
1.  **Clone the repository:**
    ```bash
    git clone https://github.com
    cd your-repository
    ```

2.  **Environment Variables:**
    The project requires `DB_USERNAME` and `DB_PASSWORD`. These are pre-configured in the `docker-compose.yml` file with default values, but you can override them by creating a `.env` file in the root directory.

3.  **Run the application:**
    Execute the following command in the project root:
    ```bash
    docker compose up --build -d
    DB_USERNAME=postgres
    DB_PASSWORD=admin
    ```

4.  **Access the Platform:**
    *   **Frontend (UI):** [http://localhost:3000](http://localhost:3000)
    *   **Backend (API):** [http://localhost:8888](http://localhost:8888)

> **Note:** The database initializes automatically. Thanks to the `hibernate.ddl-auto=update` configuration, all tables are created on the first boot without requiring manual SQL scripts.

## 🔑 Authentication & Security

*   **JWT Auth:** Uses **JSON Web Tokens** for secure, stateless authentication.
*   **User Provisioning:** You can set up initial users for testing in:
    `src/main/java/com/.../config/SecurityConfig.java` within the `userDetailsService` method.
*   **Route Protection:** All write operations (POST, PUT, DELETE) require a valid JWT token in the Authorization header.

## 📝 Key Features

*   **Post Management:** Create, edit, delete, and save drafts or publish blogs.
*   **Organization:** Categorization and tagging support (up to 10 tags per post).
*   **Reading Time:** Automatically calculates the estimated reading time for each article.
*   **Clean Architecture:** Utilization of DTOs and MapStruct to ensure database entities are never directly exposed.
*   **Reverse Proxy:** Nginx manages frontend requests and proxies API calls to the backend, eliminating CORS issues and improving performance.

## 🔍 Useful Commands

*   **View live logs:** `docker compose logs -f`
*   **Stop the application:** `docker compose stop`
*   **Full cleanup (removes containers & volumes):** `docker compose down -v`
