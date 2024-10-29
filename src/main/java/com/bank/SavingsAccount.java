// src/main/java/com/banking/SavingsAccount.java
package com.bank;

public class SavingsAccount extends BankAccount {
    private final double interestRate;

    public SavingsAccount(String accountHolderName, double balance, double minimumBalance, double interestRate) {
        super(accountHolderName, balance, minimumBalance);
        if (interestRate < 0) {
            throw new IllegalArgumentException("Interest rate cannot be negative");
        }
        this.interestRate = interestRate;
    }

    public double getInterestRate() {
        return interestRate;
    }

    public double calculateInterest() {
        return getBalance() * (interestRate / 100);
    }

    @Override
    public String toString() {
        return String.format("Savings Account - Holder: %s, Balance: %.2f, Interest Rate: %.1f%%",
                getAccountHolderName(), getBalance(), interestRate);
    }
}