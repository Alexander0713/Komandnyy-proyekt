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

    void shouldNotPayWhenAmountExceedsCreditLimit() {

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
    void shouldAddAmountToBalance() {
        CreditAccount account = new CreditAccount(1000, 5000, 15);

        boolean result = account.add(500);

        assertTrue(result);
        assertEquals(1500, account.getBalance());
    }


}

