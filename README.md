# Supermarket Application - (K-Market) 🛒

Welcome to the K-Market Application! This application provides a comprehensive solution for managing supermarket operations, including inventory management, product management and order processing. 
This README file will guide you through the setup and usage of the application.

## Table of Contents 📚

- [Features](#features)
- [Technologies Used](#technologies-used)
- [Getting Started](#getting-started)
  - [Prerequisites](#prerequisites)
  - [Installation](#installation)
  - [Configuration](#configuration)
  - [Running the Application](#running-the-application)
- [Usage](#usage)
- [API Documentation](#api-documentation)
- [Contributing](#contributing)
- [License](#license)
- [Contact](#contact)

## Features ✨

The Supermarket Application offers the following features:

- User management: User authentication and authorization for different roles (e.g., admin, user)
- Product management: Add, update, delete, and retrieve products in the inventory
- Order management: Place orders and track order status
- Inventory management: Track stock levels, receive new stock, and perform stock adjustments
  

## Technologies Used 🛠️

The Supermarket Application is built using the following technologies:

- Java
- Spring Boot
- Spring Security
- Spring Data JPA
- MySQL
- Maven
- Postman

## Getting Started 🚀

### Prerequisites 📋

Before starting, make sure you have the following prerequisites:

- Java Development Kit (JDK) version 11 or higher
- MySQL database server
- Maven

### Installation ⚙️

1. Clone the repository:

   ```bash
   git clone git@github.com:tharindu432/SuperMarketApp.git
   ```

2. Navigate to the project directory:
   ```bash
   cd SuperMarketApp
   ```

### Configuration 🔧

1. Create a MySQL database for the application.
2. Open src/main/resources/application.properties and modify the following properties to match your MySQL configuration.
   
   ```
   spring.datasource.url=jdbc:mysql://localhost:3306/your-database-name
   spring.datasource.username=your-username
   spring.datasource.password=your-password
   ```

### Running the Application ▶️

The Supermarket Application will start, and you can access it at http://localhost:8080.

### Usage 📖

Once the application is up and running, you can access the Supermarket Application through a web browser or use API clients like Postman to interact with the RESTful APIs.

The application provides a user-friendly interface for managing products, orders and inventory. Additionally, the APIs can be used to integrate with other systems or build custom front-end applications.


### API Documentation 📚

The Supermarket Application provides API documentation to help developers understand and utilize the available endpoints. The API documentation is generated using Swagger.
To access the API documentation, open your web browser and navigate to http://localhost:8080/swagger-ui.html.


### Contributing 🤝

Contributions to the Supermarket Application are welcome! If you find any bugs, have suggestions for new features, or would like to contribute code improvements, please feel free to open an issue or submit a pull request.


### License 📄

The Supermarket Application is open-source software licensed under the MIT License.


### Contact 📞

For any questions or inquiries about the Supermarket Application, please feel free to reach out:

- Website: [www.dev.chathurangarp.tech](https://www.dev.chathurangarp.tech)
- LinkedIn: [Tharindu Chathuranga Ruwanpathirana](https://www.linkedin.com/in/tharindu-chathuranga-ruwanpathirana-5917a520a/)
- WhatsApp: [+94764492334](https://wa.me/+94764492334)
- Email: chathuranga.rp2000@gmail.com
