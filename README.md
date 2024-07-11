

# FastX Bus Ticket Booking System

## Overview
The **FastX Bus Ticket Booking System** is a comprehensive web-based application designed to streamline the process of searching for bus routes, viewing schedules, booking tickets, and making payments online. This system connects passengers with bus operators, providing a seamless experience for reserving bus seats, planning journeys, and managing bookings.

## Features
- **User Registration and Authentication**: Secure login and profile management for passengers.
- **Bus Route Search**: Search for bus routes based on origin, destination, and date.
- **Route Details and Booking**: View detailed route information, seat availability, and ticket prices. Make reservations and receive e-tickets.
- **Ticket Confirmation**: Email confirmations with booking details.
- **User Profiles**: Manage personal profiles, view booking history, and cancel bookings.
- **Admin Dashboard**: Manage schedules, bus availability, and bookings for bus operators/admins.

## Technologies
- **Frontend**: Angular
- **Backend**: Java, Spring Boot
- **Database**: MySQL / SQL Server
- **Authentication**: JSON Web Tokens (JWT)

## Use Cases
### Users
- **Register and Log In**: Create accounts and log in securely.
- **Search Bus**: Find bus routes based on journey details.
- **Select Seats and Make Reservations**: Choose seats and book tickets.
- **Payment Processing**: Secure online payments.
- **Cancel Tickets**: Cancel bookings and request refunds.
- **View Booking History**: Track and manage past reservations.

### Bus Operators
- **Log In**: Access the operator dashboard.
- **Manage Routes**: Add, edit, or remove bus routes and schedules.
- **Manage Bookings**: View and manage bookings.
- **Logout**: Secure logout functionality.

### Administrators
- **Log In**: Admin access to the system.
- **User Management**: Manage user and bus operator accounts.
- **Manage Bookings and Routes**: Oversee bookings and bus routes.
- **Logout**: Secure logout functionality.

## System Architecture
- **User and Bus Operator Registration**: Secure creation and validation of accounts.
- **User Dashboard**: Search for routes, view schedules, select seats, and manage bookings.
- **Bus Operator Dashboard**: Manage bus details, schedules, fares, and view bookings.
- **Admin Dashboard**: Comprehensive management of users, operators, bookings, and routes.

## Development Process
1. **Backend Development**
   - REST APIs with Spring Boot.
   - Use of Java latest features and Spring Data JPA.
   - Backend data validation, API versioning, and security with JWT.
   - Implement logging, unit testing, and follow coding standards.

2. **Frontend Constraints**
   - Responsive and organized layout.
   - Use Angular for UI development, routing, and validations.
   - Implement forms, data binding, and custom JavaScript functionalities.
   - Ensure error messages are user-readable and maintain a standard project structure.

## Security and Compliance
- **JWT Authentication**: Secure login and token-based authorization.
- **Protected Routes**: Ensure access control based on user roles and permissions.
- **Logout**: Invalidate JWT tokens to prevent unauthorized access.

## Frontend Design
- **User Registration and Login Pages**
  - Clean layout with form fields for registration and login.
  - Real-time validation, error messages, and password strength indicators.
  - Responsive design with hover effects and focus styles.

- **User Dashboard**
  - Search routes with auto-suggestions for origin and destination.
  - Display route details, select seats, and make bookings.
  - View and manage booking history, including cancellations.

- **Bus Operator Dashboard**
  - Manage bus details, schedules, and seat availability.
  - View and refund booked tickets.

- **Admin Dashboard**
  - Manage user and operator accounts, bookings, and routes.

## Setup and Installation
1. **Clone the Repository**
   ```sh
   git clone https://github.com/yourusername/fastx-bus-booking-system.git
   cd fastx-bus-booking-system
   ```

2. **Backend Setup**
   - Navigate to the backend directory and run the Spring Boot application.
   ```sh
   cd backend
   ./mvnw spring-boot:run
   ```

3. **Frontend Setup**
   - Navigate to the frontend directory, install dependencies, and run the Angular application.
   ```sh
   cd frontend
   npm install
   ng serve
   ```

## Usage
1. **User Registration and Login**: Create a new account or log in with existing credentials.
2. **Search and Book Tickets**: Find bus routes, view details, select seats, and make reservations.
3. **Manage Bookings**: View booking history, cancel bookings, and request refunds.
4. **Admin and Operator Functions**: Access the dashboard to manage routes, bookings, and user accounts.

## Contributing
Contributions are welcome! Please follow these steps to contribute:
1. Fork the repository.
2. Create a new branch (`git checkout -b feature/your-feature`).
3. Commit your changes (`git commit -m 'Add some feature'`).
4. Push to the branch (`git push origin feature/your-feature`).
5. Open a pull request.

