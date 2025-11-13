package ru.netology.javaqadiplom;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BankTest {

    @Test
    void shouldTransferSuccessfully() {
        Account from = new SavingAccount(1000, 0, 10_000, 5);
        Account to = new SavingAccount(500, 0, 10_000, 5);
        Bank bank = new Bank();

        boolean result = bank.transfer(from, to, 200);

        Assertions.assertTrue(result);
        Assertions.assertEquals(800, from.getBalance());
        Assertions.assertEquals(700, to.getBalance());
    }

    @Test
    void shouldRejectZeroAmount() {
        Account from = new SavingAccount(1000, 0, 10_000, 5);
        Account to = new SavingAccount(500, 0, 10_000, 5);
        Bank bank = new Bank();

        boolean result = bank.transfer(from, to, 0);

        Assertions.assertFalse(result);
        Assertions.assertEquals(1000, from.getBalance());
        Assertions.assertEquals(500, to.getBalance());
    }

    @Test
    void shouldFailIfInsufficientFunds() {
        Account from = new SavingAccount(100, 0, 10_000, 5);
        Account to = new SavingAccount(500, 0, 10_000, 5);
        Bank bank = new Bank();

        boolean result = bank.transfer(from, to, 200);

        Assertions.assertFalse(result);
        Assertions.assertEquals(100, from.getBalance());
        Assertions.assertEquals(500, to.getBalance());
    }

    @Test
    void shouldRollbackIfAddFails() {

        Account from = new SavingAccount(1000, 0, 10_000, 5);
        Account to = new SavingAccount(900, 0, 1000, 5);

        Bank bank = new Bank();
        boolean result = bank.transfer(from, to, 200);

        Assertions.assertFalse(result);
        Assertions.assertEquals(1000, from.getBalance());
        Assertions.assertEquals(900, to.getBalance());
    }
}
