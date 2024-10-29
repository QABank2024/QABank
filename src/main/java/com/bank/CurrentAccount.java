package com.bank;

public class CurrentAccount extends Bank{

    private double maximumWithdrawal;

    public void setMaximumWithdrawal(double max){
        this.maximumWithdrawal = max;
    }

    public double getMaximumWithdrawal(){
        return maximumWithdrawal;
    }

    public void withdraw(double money){
        if (money > maximumWithdrawal){
            throw new IllegalArgumentException("Money more than max withdrawal");
        }
        else if (money < 0){
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
