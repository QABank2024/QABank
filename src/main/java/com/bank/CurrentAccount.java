// src/main/java/com/banking/CurrentAccount.java
package com.bank;

public class CurrentAccount extends BankAccount {
    private static final double DEFAULT_MAXIMUM_WITHDRAWAL = 5000.0;
    private final double maximumWithdrawal;

    public CurrentAccount(String accountHolderName, double balance, double minimumBalance) {
        super(accountHolderName, balance, minimumBalance);
        this.maximumWithdrawal = DEFAULT_MAXIMUM_WITHDRAWAL;
    }

    @Override
    public void withdraw(double amount) {
        if (amount > maximumWithdrawal) {
            throw new IllegalArgumentException("Amount exceeds maximum withdrawal limit");
        }
        super.withdraw(amount);
    }

    public double getMaximumWithdrawal() {
        return maximumWithdrawal;
    }

    @Override
    public String toString() {
        return String.format("Current Account - Holder: %s, Balance: %.2f",
                getAccountHolderName(), getBalance());
    }
}