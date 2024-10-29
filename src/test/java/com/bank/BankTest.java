package com.bank;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BankTest {

    private Bank bank;

    @BeforeEach
    public void setUp() {
        bank = new Bank();
    }

    @Test
    public void testSetAndGetAccountHolderName() {
        String name = "John Doe";
        bank.setAccountHolderName(name);
        assertEquals(name, bank.getAccountName());
    }

    @Test
    public void testSetAndGetBalance() {
        double balance = 1000.50;
        bank.setBalance(balance);
        assertEquals(balance, bank.getBalance());
    }

    @Test
    public void testSetAndGetMinimumBalance() {
        double minBalance = 100.0;
        bank.setMinimumBalance(minBalance);
        assertEquals(minBalance, bank.getMinimumBalance());
    }
}
