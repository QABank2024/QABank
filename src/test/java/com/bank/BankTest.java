package com.bank;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

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

    @Test
    public void testDeposit(){
        bank.setAccountHolderName("John Doe");
        bank.setBalance(0);
        bank.setMinimumBalance(0);
        float money = 50;
        bank.deposit(money);
        assertEquals(50, bank.getBalance());
    }

    public void testDepositNegative(){
        bank.setBalance(0);
        bank.setMinimumBalance(0);
        double money = -50;

        assertThrows(IllegalArgumentException.class, () -> account.deposit(money));
    }
}
