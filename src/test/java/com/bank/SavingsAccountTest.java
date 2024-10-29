// src/test/java/com/banking/SavingsAccountTest.java
package com.bank;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class SavingsAccountTest {
    private SavingsAccount account;
    private static final double INITIAL_BALANCE = 1000.0;
    private static final double MINIMUM_BALANCE = 100.0;
    private static final String ACCOUNT_HOLDER = "Jane Doe";
    private static final double INTEREST_RATE = 2.5;

    @BeforeEach
    void setUp() {
        account = new SavingsAccount(ACCOUNT_HOLDER, INITIAL_BALANCE, MINIMUM_BALANCE, INTEREST_RATE);
    }

    @Test
    void testSavingsAccountCreation() {
        assertEquals(ACCOUNT_HOLDER, account.getAccountHolderName());
        assertEquals(INITIAL_BALANCE, account.getBalance());
        assertEquals(MINIMUM_BALANCE, account.getMinimumBalance());
        assertEquals(INTEREST_RATE, account.getInterestRate());
    }

    @Test
    void testDeposit() {
        account.deposit(500.0);
        assertEquals(1500.0, account.getBalance());
    }

    @Test
    void testDepositNegativeAmount() {
        assertThrows(IllegalArgumentException.class, () -> account.deposit(-100.0));
    }

    @Test
    void testSuccessfulWithdrawal() {
        account.withdraw(500.0);
        assertEquals(500.0, account.getBalance());
    }

    @Test
    void testWithdrawalBelowMinimumBalance() {
        assertThrows(IllegalArgumentException.class,
                () -> account.withdraw(INITIAL_BALANCE - MINIMUM_BALANCE + 100));
    }

    @Test
    void testWithdrawalNegativeAmount() {
        assertThrows(IllegalArgumentException.class, () -> account.withdraw(-100.0));
    }

    @Test
    void testCalculateInterest() {
        double expectedInterest = INITIAL_BALANCE * (INTEREST_RATE / 100);
        assertEquals(expectedInterest, account.calculateInterest());
    }

    @Test
    void testToString() {
        String expected = String.format("Savings Account - Holder: %s, Balance: %.2f, Interest Rate: %.1f%%",
                ACCOUNT_HOLDER, INITIAL_BALANCE, INTEREST_RATE);
        assertEquals(expected, account.toString());
    }
}