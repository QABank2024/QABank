// src/test/java/com/banking/CurrentAccountTest.java
package com.bank;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CurrentAccountTest {
    private CurrentAccount account;
    private static final double INITIAL_BALANCE = 1000.0;
    private static final double MINIMUM_BALANCE = 100.0;
    private static final String ACCOUNT_HOLDER = "John Doe";
    private static final double MAXIMUM_WITHDRAWAL = 5000.0;

    @BeforeEach
    void setUp() {
        account = new CurrentAccount(ACCOUNT_HOLDER, INITIAL_BALANCE, MINIMUM_BALANCE);
    }

    @Test
    void testCurrentAccountCreation() {
        assertEquals(ACCOUNT_HOLDER, account.getAccountHolderName());
        assertEquals(INITIAL_BALANCE, account.getBalance());
        assertEquals(MINIMUM_BALANCE, account.getMinimumBalance());
        assertEquals(MAXIMUM_WITHDRAWAL, account.getMaximumWithdrawal());
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
    void testWithdrawalExceedingMaximum() {
        assertThrows(IllegalArgumentException.class,
                () -> account.withdraw(MAXIMUM_WITHDRAWAL + 100));
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
    void testToString() {
        String expected = String.format("Current Account - Holder: %s, Balance: %.2f",
                ACCOUNT_HOLDER, INITIAL_BALANCE);
        assertEquals(expected, account.toString());
    }
}
