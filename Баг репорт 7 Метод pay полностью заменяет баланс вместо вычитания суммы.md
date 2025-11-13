# Описание.

При успешной оплате метод (pay) полностью заменяет текущий баланс счета на отрицательную сумму оплаты

# Локация дефекта:
 
https://github.com/Alexander0713/Komandnyy-proyekt/blob/f2dbb2d1978b0270423be66de7734c22d4d6c416/src/main/java/ru/netology/javaqadiplom/CreditAccount.java#L46

# Шаги воспроизведения:

1. Открыть [код программы](https://github.com/Alexander0713/Komandnyy-proyekt/blob/7e01d1602ba0e7787782ab0ac6d54e4d04a0db01/src/main/java/ru/netology/javaqadiplom/SavingAccount.java#L44) в IDEA. 
1. Открыть класс для тестирования CreditAccountTest.java
1. Добавьте тестовый метод
1.  Создать кредитный счет с начальной суммой 1000 рублей, максимальный долг: 5000 рублей, процентная ставка: 15%
1. Выполнить операцию пополнения на 500 рублей
1. Запустить тест
1. Посмотреть результат в консоли



*Ожидаемый результат:* Баланс должен увеличиться до 1500

*Фактический результат:* Баланс перезаписывается значением -500

# Тест для проверки:
       @Test
       public void shouldCorrectlySubtractAmountFromBalance() {
        CreditAccount account = new CreditAccount(1000, 5000, 15);
        assertTrue(account.pay(500));
        assertEquals(500, account.getBalance()); // 1000 - 500 = 500    }


# Скриншот:

<img width="1585" height="952" alt="Image" src="https://github.com/user-attachments/assets/e901339b-645f-4362-a010-aa4f6f9773c7" />

# Окружение
* **Устройство:** ПК
* **Операционная система:** Windows 11,
* **Браузер:** Google Chrome Версия: 137.0.7151.120 (Официальная сборка)(64 бит)
* **JAVA:** OpenJDK 11