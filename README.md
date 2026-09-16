# Group Wallet System - Backend

## 📌 Project Overview
The **Group Wallet System** is a professional-grade fintech backend developed for **Al Ahly Momkn**. The system provides a secure, reliable, and scalable platform for managing shared finances, including group treasury management, role-based access control (RBAC), and immutable transaction logging.

## 🏗️ Architectural Pattern: Modular Monolith
To ensure maintainability and future scalability, the project follows a **Modular Monolith** architecture. By using **Maven Multi-Module** configurations, we maintain strict physical boundaries between business domains. This allows us to move toward microservices in the future with minimal refactoring.

### Domain Modules:
*   `applicationService`: The API Gateway/Edge module. Contains REST controllers and the Spring Boot startup configuration.
*   `userService`: Manages user profiles and identity (Pre-seeded).
*   `walletService`: The core financial engine handling balances, transfers, and optimistic locking.
*   `groupService`: Manages group formations, memberships, and RBAC policies.
*   `transactionService`: The system's immutable ledger for audit trails.
*   `commonService`: Shared domain Enums, global exceptions, and DTOs.

## 🚀 Key Technical Features
- **Transaction Integrity**: `@Transactional` ensures ACID compliance for all fund transfers.
- **Concurrency Control**: Implemented **Optimistic Locking** (`@Version` column) on wallet entities to prevent race conditions during concurrent financial operations.
- **Separation of Duties**: Strict RBAC logic where only Moderators manage members, and only Treasurers manage funds.
- **Automated Data Seeding**: `data.sql` script initializes the environment with pre-funded users on startup.
- **Cross-Domain Communication**: Modules interact via service layers to avoid circular dependencies and tight coupling.

## 🛠️ Tech Stack
- **Framework**: Java 17, Spring Boot 3.2.3
- **Database**: MySQL 8.0
- **Build Tool**: Maven (Multi-module)
- **Data Access**: Spring Data JPA / Hibernate
- **Utilities**: Lombok, Spring Validation

## ⚙️ How to Run
1. Ensure **MySQL** is running.
2. Create a database named `groupwallet`.
3. Configure your database credentials in `applicationService/src/main/resources/application.yml`.
4. Run the main class: `com.alahlymomkn.GroupWalletApplication`.
5. The system will automatically create tables via Hibernate and seed data via `data.sql`.

## 📜 API Documentation
The API follows RESTful principles and is documented via Swagger/OpenAPI.
*   **Groups API**: `/api/groups`
*   **Wallet API**: `/wallet`
*   **Users API**: `/api/users`
