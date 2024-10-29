package com.bank;

public class SavingsAccount extends Bank{
    private double interestRate;

    public void setInterestRate(double rate){
        this.interestRate = rate;
    }

    public double getInterestRate(){
        return interestRate;
    }

    public void addInterest(){
        setBalance(this.getBalance()*(1+this.getInterestRate()));
    }
}
