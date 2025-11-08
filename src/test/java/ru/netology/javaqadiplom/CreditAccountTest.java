package ru.netology.javaqadiplom;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CreditAccountTest {

    @Test
    public void shouldAddToPositiveBalance() {
        CreditAccount account = new CreditAccount(
                0,
                5_000,
                15
        );

        account.add(3_000);

        assertEquals(3_000, account.getBalance());
    }
    @Test

    public void shouldNotPayWhenAmountExceedsCreditLimit() {

// Создаем счет с балансом 1000 и кредитным лимитом 5000
        CreditAccount account = new CreditAccount(1000, 5000, 15);

// Пытаемся оплатить 7000 (превышаем лимит)
        boolean result = account.pay(7000);

// Проверяем что операция не прошла
        assertFalse(result);
// Проверяем что баланс не изменился
        assertEquals(1000, account.getBalance());
    }
    @Test
    public void shouldAddAmountToBalance() {
        CreditAccount account = new CreditAccount(1000, 5000, 15);

        boolean result = account.add(500);

        assertTrue(result);
        assertEquals(1500, account.getBalance());
    }

    @Test
    public void shouldCalculateYearChangeForNegativeBalance() {
        CreditAccount account = new CreditAccount(0, 5000, 15);
        account.pay(150);

        int yearChange = account.yearChange();

        assertEquals(-22, yearChange);
    }

    @Test
    public void shouldThrowExceptionWhenCreditLimitNegative() {
        assertThrows(IllegalArgumentException.class, () -> {
            new CreditAccount(-1000, 5000, 15);
        });
    }

    @Test
    void shouldPayCorrectlyWithinCreditLimit() {
        CreditAccount account = new CreditAccount(1000, 5000, 15);

        boolean result = account.pay(6000);

        assertTrue(result);
        assertEquals(0, account.getBalance());
    }
    @Test
    public void shouldNotCreateAccountWithNegativeCreditLimit() {
        // Пытаемся создать счет с отрицательным кредитным лимитом
        Exception exception = assertThrows(IllegalArgumentException.class,
                () -> new CreditAccount(1000, -5000, 15));
    }
    @Test
    public void shouldCorrectlySubtractAmountFromBalance() {
        CreditAccount account = new CreditAccount(1000, 5000, 15);
        assertTrue(account.pay(500));
        assertEquals(500, account.getBalance()); // 1000 - 500 = 500
    }
    @Test
    public void shouldReturnZeroForPositiveBalance() {
        CreditAccount account = new CreditAccount(5000, 10000, 15);
        assertEquals(0, account.yearChange());
    }
    @Test
    public void shouldCreateAccountWithZeroInterestRate() {
        // Нулевая ставка должна быть разрешена
        Assertions.assertDoesNotThrow(() ->
                new CreditAccount(1000, 5000, 0));
    }
}

