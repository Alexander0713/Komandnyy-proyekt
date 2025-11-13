package ru.netology.javaqadiplom;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SavingAccountTest {

    @Test
    public void shouldAddLessThanMaxBalance() {
        SavingAccount account = new SavingAccount(
                2_000,
                1_000,
                10_000,
                5
        );

        account.add(3_000);

        Assertions.assertEquals(2_000 + 3_000, account.getBalance());
    }
  
    @Test
    public void shouldNotChangeBalanceWhenPaymentExceedsMinBalance() {
        SavingAccount account = new SavingAccount(
                1_200,
                1_000,
                10_000,
                5
        );

        boolean result = account.pay(300);

        Assertions.assertFalse(result);

        Assertions.assertEquals(1_200, account.getBalance());
    }

    @Test
    public void shouldThrowExceptionWhenInitialBalanceBelowMin() {
        Exception exception = Assertions.assertThrows(IllegalArgumentException.class,
                () -> new SavingAccount(500, 1000, 10000, 5));

        Assertions.assertTrue(exception.getMessage().contains("баланс"));
    }

    @Test
    public void shouldThrowExceptionWhenInitialBalanceBelowMax() {
        Exception exception = Assertions.assertThrows(IllegalArgumentException.class,
                () -> new SavingAccount(15000, 1000, 10000, 5));

        Assertions.assertTrue(exception.getMessage().contains("баланс"));
    }

    @Test
    public void shouldCalculateYearChangeWithFractionalResultAndMinBalance1000() {
        SavingAccount account = new SavingAccount(1_230, 1_000, 10_000, 5);

        int result = account.yearChange();

        Assertions.assertEquals(61, result);
    }

    @Test
    public void shouldThrowExceptionWhenMinBalanceNegative() {
        Exception exception = Assertions.assertThrows(IllegalArgumentException.class,
                () -> new SavingAccount(2000, -100, 10000, 5));

        Assertions.assertTrue(exception.getMessage().contains("отрицательным"));
    }

    @Test
    public void shouldThrowExceptionWhenMinGreaterThanMax() {

        Exception exception = Assertions.assertThrows(IllegalArgumentException.class,
                () -> new SavingAccount(2000, 15000, 10000, 5));

        Assertions.assertTrue(exception.getMessage().contains("больше максимального баланса"));
    }
}
