// src/main/java/com/banking/Main.java
package com.bank;

public class Main {
    public static void main(String[] args) {
        Bank bank = new Bank();

        // Create a current account
        CurrentAccount currentAccount = new CurrentAccount("John Doe", 1000.0, 100.0);
        currentAccount.deposit(500.0);
        System.out.println(currentAccount);

        // Create a savings account
        SavingsAccount savingsAccount = new SavingsAccount("Jane Doe", 2000.0, 100.0, 2.5);
        System.out.println("Annual Interest: $" + savingsAccount.calculateInterest());
        System.out.println(savingsAccount);

        // Add accounts to bank
        bank.addAccount(currentAccount);
        bank.addAccount(savingsAccount);

        // Display all accounts
        System.out.println("\nAll Bank Accounts:");
        System.out.println(bank);
    }
}