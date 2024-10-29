package com.bank;

public class Bank {

    private double Balance;
    private double MinimumBalance;
    private String AccountHolderName;

    public String getAccountName() {
        return AccountHolderName;
    }

    public double getBalance() {
        return Balance;
    }

    public double getMinimumBalance() {
        return MinimumBalance;
    }

    public void setAccountHolderName(String newAccountHolderName) {
        this.AccountHolderName = newAccountHolderName;
    }

    public void setBalance(double newBalance) {
        this.Balance = newBalance;
    }

    public void setMinimumBalance(double newMinimumBalance) {
        this.MinimumBalance = newMinimumBalance;
    }

    public void deposit(double money){
        if (money < 0) {
            throw new IllegalArgumentException("Money can not be negative");
        }else{
            setBalance(money + this.getBalance());
        }
    }

    public void withdraw(double money){
        if (money < 0){
            throw new IllegalArgumentException("Money can not be negative");
        }
        else if (this.getBalance()-money > this.getMinimumBalance()){
            setBalance(this.getBalance()-money);
        }

        else{
            throw new IllegalArgumentException("Balance goes below minimum allowed!");
        }
    }

}
