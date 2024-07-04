# Full-Stack Project

## Table of Contents
1. [Introduction](#introduction)
2. [Technologies](#technologies)
3. [Prerequisites](#prerequisites)
4. [Setup](#setup)
5. [Running the Application](#running-the-application)
6. [Project Structure](#project-structure)
7. [Contributing](#contributing)
8. [License](#license)

## Introduction
This is a full-stack project using Java with Spring Boot for the backend, C++ for system-level programming, React for the frontend, PostgreSQL for database management, and REST API for communication between the frontend and backend.

## Technologies
- **Backend**: Java, Spring Boot
- **System-Level Programming**: C++
- **Frontend**: React
- **Database**: PostgreSQL
- **Communication**: REST API

## Prerequisites
- Java Development Kit (JDK) 11 or higher
- Node.js and npm
- PostgreSQL
- Maven
- C++ Compiler

## Setup

### Backend
1. **Clone the repository**
    ```sh
    git clone git@github.com:yaacovdev/workTracker.git
    cd workTracker
    ```

2. **Build the backend**
    ```sh
    mvn clean install
    ```

3. **Run the Spring Boot application**
    ```sh
    mvn spring-boot:run
    ```

### Frontend
1. **Navigate to the frontend directory**
    ```sh
    cd ../frontend
    ```

2. **Install dependencies**
    ```sh
    npm install
    ```

3. **Start the React application**
    ```sh
    npm start
    ```

### Database
1. **Start PostgreSQL** and create a database
    ```sh
    createdb mydatabase
    ```

2. **Configure database connection** in `application.properties` (backend)
    ```properties
    spring.datasource.url=jdbc:postgresql://localhost:5432/mydatabase
    spring.datasource.username=yayo
    spring.datasource.password=mysecretpassword
    ```

### System-Level Programming (C++)
1. **Navigate to the C++ directory**
    ```sh
    cd ../system
    ```

2. **Compile the C++ code**
    ```sh
    g++ -o myprogram myprogram.cpp
    ```

3. **Run the C++ program**
    ```sh
    ./myprogram
    ```

## Running the Application
1. Start the backend server as described in the [Backend Setup](#backend) section.
2. Start the frontend server as described in the [Frontend Setup](#frontend) section.
3. Ensure the PostgreSQL database is running and properly configured.

## Project Structure
