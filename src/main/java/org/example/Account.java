package org.example;

public class Account {

    private double balance;
    private String status;
    private int creditScore;

    // Constructor used in most tests
    public Account(double balance, String status) {
        this.balance = balance;
        this.status = status;
        this.creditScore = 700; // default valid credit score
    }

    // Constructor used in TDD tests
    public Account(double balance, String status, int creditScore) {
        this.balance = balance;
        this.status = status;
        this.creditScore = creditScore;
    }

    public boolean deposit(double amount) {
        // Block deposit for Closed or Suspended accounts
        if (status.equals("Closed") || status.equals("Suspended")) {
            return false;
        }

        // Invalid amount
        if (amount <= 0) {
            return false;
        }

        balance += amount;
        return true;
    }

    public boolean withdraw(double amount) {
        // Block withdraw for Closed or Suspended accounts
        if (status.equals("Closed") || status.equals("Suspended")) {
            return false;
        }

        // Credit score rule (TDD requirement)
        if (creditScore < 600) {
            return false;
        }

        // Overdraft protection
        if (amount > balance) {
            return false;
        }

        balance -= amount;
        return true;
    }

    public double getBalance() {
        return balance;
    }

    public String getStatus() {
        return status;
    }
}
