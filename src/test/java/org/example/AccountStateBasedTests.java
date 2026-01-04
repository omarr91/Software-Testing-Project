package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class AccountStateBasedTests {

    @Test
    public void verifiedAccount_allowsDeposit() {
        Account acc = new Account(100, "Verified");
        assertTrue(acc.deposit(50));
    }

    @Test
    public void verifiedAccount_allowsWithdraw() {
        Account acc = new Account(100, "Verified");
        assertTrue(acc.withdraw(50));
    }

    @Test
    public void suspendedAccount_blocksDeposit() {
        Account acc = new Account(100, "Suspended");
        assertFalse(acc.deposit(50));
    }

    @Test
    public void suspendedAccount_blocksWithdraw() {
        Account acc = new Account(100, "Suspended");
        assertFalse(acc.withdraw(50));
    }

    @Test
    public void closedAccount_blocksDeposit() {
        Account acc = new Account(100, "Closed");
        assertFalse(acc.deposit(50));
    }

    @Test
    public void closedAccount_blocksWithdraw() {
        Account acc = new Account(100, "Closed");
        assertFalse(acc.withdraw(50));
    }
}
