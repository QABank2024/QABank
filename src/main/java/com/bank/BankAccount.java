// src/main/java/com/banking/BankAccount.java
package com.bank;

public abstract class BankAccount {
    private final String accountHolderName;
    private double balance;
    private final double minimumBalance;

    public BankAccount(String accountHolderName, double balance, double minimumBalance) {
        if (accountHolderName == null || accountHolderName.trim().isEmpty()) {
            throw new IllegalArgumentException("Account holder name cannot be empty");
        }
        if (balance < minimumBalance) {
            throw new IllegalArgumentException("Initial balance cannot be less than minimum balance");
        }

        this.accountHolderName = accountHolderName;
        this.balance = balance;
        this.minimumBalance = minimumBalance;
    }

    public void deposit(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Deposit amount must be positive");
        }
        this.balance += amount;
    }

    public void withdraw(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Withdrawal amount must be positive");
        }
        if (balance - amount < minimumBalance) {
            throw new IllegalArgumentException("Withdrawal would put balance below minimum");
        }
        this.balance -= amount;
    }

    public String getAccountHolderName() {
        return accountHolderName;
    }

    public double getBalance() {
        return balance;
    }

    public double getMinimumBalance() {
        return minimumBalance;
    }
}