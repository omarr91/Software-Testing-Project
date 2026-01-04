package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class AccountBlackBoxTest {

    @Test
    void deposit_negativeAmount_fails() {
        Account account = new Account(100, "Verified");
        assertFalse(account.deposit(-1));
    }

    @Test
    void deposit_zeroAmount_fails() {
        Account account = new Account(100, "Verified");
        assertFalse(account.deposit(0));
    }

    @Test
    void deposit_positiveAmount_succeeds() {
        Account account = new Account(100, "Verified");
        assertTrue(account.deposit(1));
    }

    @Test
    void deposit_closedAccount_fails() {
        Account account = new Account(100, "Closed");
        assertFalse(account.deposit(50));
    }

    @Test
    void withdraw_validAmount_succeeds() {
        Account account = new Account(100, "Verified");
        assertTrue(account.withdraw(50));
    }

    @Test
    void withdraw_overBalance_fails() {
        Account account = new Account(100, "Verified");
        assertFalse(account.withdraw(101));
    }

    @Test
    void withdraw_suspendedAccount_fails() {
        Account account = new Account(100, "Suspended");
        assertFalse(account.withdraw(50));
    }
}
