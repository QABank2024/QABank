// src/main/java/com/banking/Bank.java
package com.bank;

import java.util.ArrayList;
import java.util.List;

public class Bank {
    private final List<BankAccount> accounts;

    public Bank() {
        this.accounts = new ArrayList<>();
    }

    public void addAccount(BankAccount account) {
        if (account == null) {
            throw new IllegalArgumentException("Account cannot be null");
        }
        accounts.add(account);
    }

    public List<BankAccount> getAllAccounts() {
        return new ArrayList<>(accounts);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Bank Accounts:\n");
        for (BankAccount account : accounts) {
            sb.append(account.toString()).append("\n");
        }
        return sb.toString();
    }
}