package com.bank;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class BankTest {

    private Bank bank;
    private CurrentAccount currentAccount;
    private SavingsAccount savingsAccount;


    @BeforeEach
    public void setUp() {
        bank = new Bank();
        currentAccount = new CurrentAccount();
        savingsAccount = new SavingsAccount();
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

    @Test
    public void testDepositNegative(){
        bank.setBalance(0);
        bank.setMinimumBalance(0);
        double money = -50;

        assertThrows(IllegalArgumentException.class, () -> bank.deposit(money));
    }

    @Test
    public void testWithdraw(){
        bank.setBalance(30);
        bank.setMinimumBalance(0);
        double money = 20;
        bank.withdraw(money);
        assertEquals(10, bank.getBalance());
    }

    @Test
    public void testWithdraw2(){
        bank.setBalance(30);
        bank.setMinimumBalance(-100);
        double money = 40;
        bank.withdraw(money);
        assertEquals(-10, bank.getBalance());
    }

    @Test
    public void testWithdrawMoreThanAllowed(){
        bank.setBalance(30);
        bank.setMinimumBalance(0);
        double money = 50;
        assertThrows(IllegalArgumentException.class, () -> bank.withdraw(money));
    }

    @Test
    public void testWithdrawNegativeAmount(){
        bank.setBalance(30);
        bank.setMinimumBalance(0);
        double money = -50;
        assertThrows(IllegalArgumentException.class, () -> bank.withdraw(money));
    }

    @Test
    public void testCurrentAccountWithdrawOKAmount(){
        currentAccount.setBalance(30);
        currentAccount.setMinimumBalance(0);
        currentAccount.setMaximumWithdrawal(25);
        double money = 20;
        currentAccount.withdraw(money);
        assertEquals(10, currentAccount.getBalance());
    }

    @Test
    public void testCurrentAccountWithdrawNotOKAmount(){
        currentAccount.setBalance(30);
        currentAccount.setMinimumBalance(0);
        currentAccount.setMaximumWithdrawal(25);
        double money = 30;
        assertThrows(IllegalArgumentException.class, () -> currentAccount.withdraw(money));
    }

    @Test
    public void testSavingsAccountInterest(){
        savingsAccount.setBalance(100);
        savingsAccount.setInterestRate(0.04);
        savingsAccount.addInterest();
        assertEquals(104, savingsAccount.getBalance());
    }
}
