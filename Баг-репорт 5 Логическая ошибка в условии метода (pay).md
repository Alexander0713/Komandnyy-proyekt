# Описание.
Неправильное условие проверки кредитного лимита в методе pay.
# Локация дефекта:
        

https://github.com/Alexander0713/Komandnyy-proyekt/blob/f2dbb2d1978b0270423be66de7734c22d4d6c416/src/main/java/ru/netology/javaqadiplom/CreditAccount.java#L39-L49
# Шаги воспроизведения:

 
1. Открыть [код программы](https://github.com/Alexander0713/Komandnyy-proyekt/blob/7e01d1602ba0e7787782ab0ac6d54e4d04a0db01/src/main/java/ru/netology/javaqadiplom/SavingAccount.java#L44) в IDEA. 
1. Открыть класс для тестирования CreditAccountTest.java
1. Добавить тестовый метод
1. Создать кредитный счет: CreditAccount account = new CreditAccount(1000, 5000, 15)
1. Выполнить операцию оплаты: account.pay(1000)
1. Запустить тест
1. Посмотреть результат в консоли

*Ожидаемый результат:* Операция должна завершиться успешно, баланс стать 0

*Фактический результат:* Баланс устанавливается в -1000
# Тест для проверки:

     @Test
      void shouldPayCorrectlyWithinCreditLimit() {
    CreditAccount account = new CreditAccount(1000, 5000, 15);
    
    boolean result = account.pay(1000);
    
    assertTrue(result);
    assertEquals(0, account.getBalance());}

# Скриншот:

<img width="1658" height="1038" alt="Image" src="https://github.com/user-attachments/assets/ffa37e19-b69f-4e8e-9cac-01c4db15da17" />


# Окружение
* **Устройство:** ПК
* **Операционная система:** Windows 11,
* **Браузер:** Google Chrome Версия: 137.0.7151.120 (Официальная сборка)(64 бит)
* **JAVA:** OpenJDK 11