package org.example;

public class AccountUI {

    public static void main(String[] args) {

        Account acc = new Account(100, "Suspended");

        System.out.println("Account Status: " + acc.getStatus());
        System.out.println("Attempting Deposit...");

        if (!acc.deposit(50)) {
            System.out.println("Error: Transaction not allowed for suspended account");
        } else {
            System.out.println("Deposit successful");
        }
    }
}
