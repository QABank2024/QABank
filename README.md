# Banking Application

## Overview
This is a simple banking application that demonstrates object-oriented programming principles and Test-Driven Development (TDD) in Java. The application implements two types of bank accounts: Current Account and Savings Account, each with their specific features and restrictions.

## Features

### Current Account
- Basic deposit and withdrawal operations
- Maximum withdrawal limit of 5000.0
- Minimum balance requirement
- Balance tracking
- Account holder information

### Savings Account
- Interest rate calculation
- Basic deposit and withdrawal operations
- Minimum balance requirement
- Balance tracking
- Account holder information

## Project Structure
```
banking-app/
├── pom.xml
└── src/
    ├── main/
    │   └── java/
    │       └── com/
    │           └── bank/
    │               ├── Main.java           # Demo application
    │               ├── Bank.java           # Bank management
    │               ├── BankAccount.java    # Abstract base class
    │               ├── CurrentAccount.java # Current account implementation
    │               └── SavingsAccount.java # Savings account implementation
    └── test/
        └── java/
            └── com/
                └── bank/
                    ├── BankTest.java           # Bank tests
                    ├── CurrentAccountTest.java  # Current account tests
                    └── SavingsAccountTest.java  # Savings account tests
```

## Setup and Installation

1. Build the project:
```bash
mvn clean install
```

## Running the Application

1. Run the main application:
```bash
mvn exec:java
```

2. Run the tests:
```bash
mvn test
```

## Testing Coverage

The application includes comprehensive tests for:

### Current Account Tests
- Account creation validation
- Deposit operations
- Withdrawal operations with maximum limit
- Minimum balance maintenance
- Invalid operation handling

### Savings Account Tests
- Account creation validation
- Interest calculation
- Deposit operations
- Withdrawal operations
- Minimum balance maintenance

### Bank Management Tests
- Account addition
- Account listing
- Account information display

## Example Usage

```java
// Create a current account
CurrentAccount currentAccount = new CurrentAccount("John Doe", 1000.0, 100.0);
currentAccount.deposit(500.0);
currentAccount.withdraw(200.0);

// Create a savings account
SavingsAccount savingsAccount = new SavingsAccount("Jane Doe", 2000.0, 100.0, 2.5);
double interest = savingsAccount.calculateInterest();

// Create a bank and add accounts
Bank bank = new Bank();
bank.addAccount(currentAccount);
bank.addAccount(savingsAccount);

// Display all accounts
System.out.println(bank);
```

## Business Rules

1. Current Account:
    - Cannot withdraw more than 5000.0 in a single transaction
    - Cannot go below minimum balance
    - Cannot perform negative transactions

2. Savings Account:
    - Interest rate must be positive
    - Cannot go below minimum balance
    - Cannot perform negative transactions

3. General Rules:
    - Account holder name cannot be empty
    - Initial balance cannot be less than minimum balance
    - Cannot withdraw more than available balance (considering minimum balance)