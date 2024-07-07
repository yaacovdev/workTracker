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

### Database
1. **Start PostgreSQL** and create a database
    ```sh
    createdb worktracker
    ```

2. **Configure database connection** in `application.properties` (backend)
    ```properties
        # PostgreSQL database connection
        spring.datasource.url=jdbc:postgresql://localhost:5432/worktracker
        spring.datasource.username=postgres
        spring.datasource.password=mysecretpassword
        spring.datasource.driver-class-name=org.postgresql.Driver
    ```

### Backend
1. **Clone the repository**
    ```sh
    git clone git@github.com:yaacovdev/workTracker.git
    cd workTracker
    ```

2. **Build the backend**
    ```sh
    cd backend
    mvn clean install
    mvn dependency:copy-dependencies
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



### System-Level Programming (C++)
1. **Navigate to the system directory**
    ```sh
    cd ../system
    ```

2. **Compile the C++ code**
    ```sh
    mkdir build
    cd build
    cmake ..
    make
    ```

3. **Run the C++ program**
    ```sh
    ./UsageTracker
    ```

## Running the Application
1. Ensure the PostgreSQL database is running and properly configured.
2. Start the backend server as described in the [Backend Setup](#backend) section.
3. Start the frontend server as described in the [Frontend Setup](#frontend) section.
4. Run the C++ program as described in the [System-Level Programming Setup](#system-level-programming-c) section.


## Project Structure
```tree
    workTracker/
    ├── backend/
    │   ├── src/
    │   ├── pom.xml
    │   └── ...
    ├── frontend/
    │   ├── src/
    │   ├── package.json
    │   └── ...
    ├── system/
    │   ├── myprogram.cpp
    │   ├── CMakeLists.txt
    │   └── ...
    └── README.md
```

## Contributing
Please read [CONTRIBUTING.md](CONTRIBUTING.md) for details on our code of conduct and the process for submitting pull requests.

## License
This project is licensed under the YaacovDev License - see the [LICENSE](LICENSE) file for details.
