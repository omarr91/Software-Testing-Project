package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class AccountCreditScoreTDDTests {

    @Test
    public void withdraw_fails_when_creditScore_is_low() {
        Account acc = new Account(100, "Verified", 550);
        assertFalse(acc.withdraw(50));
    }

    @Test
    public void withdraw_succeeds_when_creditScore_is_valid() {
        Account acc = new Account(100, "Verified", 700);
        assertTrue(acc.withdraw(50));
    }
}
