package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class AccountWhiteBoxTests {

    @Test
    public void testDepositClosedAccount() {
        Account acc = new Account(100, "Closed");
        boolean result = acc.deposit(100);
        assertFalse(result, "Deposit should fail when account is closed");
    }

    @Test
    public void testDepositNegativeAmount() {
        Account acc = new Account(100, "Verified");
        boolean result = acc.deposit(-50);
        assertFalse(result, "Deposit should fail when amount is negative");
    }

    @Test
    public void testDepositValid() {
        Account acc = new Account(100, "Verified");
        boolean result = acc.deposit(100);
        assertTrue(result, "Deposit should succeed with valid amount");
        assertEquals(200, acc.getBalance(), 0.01,
                "Balance should increase by deposit amount");
    }

    @Test
    public void testWithdrawClosedAccount() {
        Account acc = new Account(100, "Closed");
        boolean result = acc.withdraw(50);
        assertFalse(result, "Withdraw should fail when account is closed");
    }

    @Test
    public void testWithdrawSuspendedAccount() {
        Account acc = new Account(100, "Suspended");
        boolean result = acc.withdraw(50);
        assertFalse(result, "Withdraw should fail when account is suspended");
    }

    @Test
    public void testWithdrawOverdraft() {
        Account acc = new Account(100, "Verified");
        boolean result = acc.withdraw(200);
        assertFalse(result, "Withdraw should fail when amount exceeds balance");
    }

    @Test
    public void testWithdrawValid() {
        Account acc = new Account(100, "Verified");
        boolean result = acc.withdraw(50);
        assertTrue(result, "Withdraw should succeed for valid amount");
        assertEquals(50, acc.getBalance(), 0.01,
                "Balance should decrease by the withdrawn amount");
    }
}
