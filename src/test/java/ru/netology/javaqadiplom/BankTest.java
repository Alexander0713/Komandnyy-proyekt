package ru.netology.javaqadiplom;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.*;

class BankTest {

    private Bank bank;
    private Account savingAccount;
    private Account creditAccount;

    @BeforeEach
    void setUp() {
        bank = new Bank();
        savingAccount = new SavingAccount(1000, 500, 10000, 5);
        creditAccount = new CreditAccount(0, 5000, 5);

    }
    @Test
    public void shouldReturnFalseWhenPayFails() {

        Account from = new SavingAccount(1000, 500, 10000, 5);
        Account to = new CreditAccount(0, 5000, 5);
        int amount = 2000; // Нарушает minBalance
        boolean result = bank.transfer(from, to, amount);

        assertFalse(result); // Должен вернуть false
        assertEquals(1000, from.getBalance()); // Баланс не должен измениться
        assertEquals(0, to.getBalance()); // Баланс не должен измениться
    }
    @Test
    void shouldRollbackWhenAddFails() {
        Account from = new SavingAccount(1000, 0, 2000, 5);
        Account to = new CreditAccount(0, 1000, 5) {
            @Override
            public boolean add(int amount) {
                return false;
            }
        };
        int amount = 500;

        boolean result = bank.transfer(from, to, amount);

        assertFalse(result);
        assertEquals(1000, from.getBalance());
    }
   }