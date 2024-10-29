// src/test/java/com/banking/BankTest.java
package com.bank;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.List;

public class BankTest {
    private Bank bank;

    @BeforeEach
    void setUp() {
        bank = new Bank();
        bank.addAccount(new CurrentAccount("John Doe", 1000.0, 100.0));
        bank.addAccount(new SavingsAccount("Jane Doe", 2000.0, 100.0, 2.5));
    }

    @Test
    void testGetAllAccounts() {
        List<BankAccount> accounts = bank.getAllAccounts();
        assertEquals(2, accounts.size());
        assertInstanceOf(CurrentAccount.class, accounts.get(0));
        assertInstanceOf(SavingsAccount.class, accounts.get(1));
    }

    @Test
    void testToString() {
        String result = bank.toString();
        assertTrue(result.contains("John Doe"));
        assertTrue(result.contains("Jane Doe"));
        assertTrue(result.contains("Current Account"));
        assertTrue(result.contains("Savings Account"));
    }
}