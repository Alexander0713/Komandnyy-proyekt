# Описание.
Метод transfer в классе Bank всегда возвращает true, независимо от результата выполнения операции перевода.

# Локация дефекта:
        

https://github.com/Alexander0713/Komandnyy-proyekt/blob/f2dbb2d1978b0270423be66de7734c22d4d6c416/src/main/java/ru/netology/javaqadiplom/Bank.java#L22-L24
# Шаги воспроизведения:

 
1. Открыть [код программы](https://github.com/Alexander0713/Komandnyy-proyekt/blob/7e01d1602ba0e7787782ab0ac6d54e4d04a0db01/src/main/java/ru/netology/javaqadiplom/SavingAccount.java#L44) в IDEA. 
1. Открыть класс для тестирования BankTest.java
1. Добавить тестовый метод
1. Создать сберегательный счет с минимальным балансом 500
Account from = new SavingAccount(1000, 500, 10000, 5)
1. Создать кредитный счет Account to = new CreditAccount(0, 5000, 5)
1. Выполнить перевод на сумму, превышающую допустимую
1. Запустить тест
1. Посмотреть результат в консоли

*Ожидаемый результат:* Метод transfer должен возвращать true - если перевод выполнен успешно или false - если перевод не выполнен по любой причине

*Фактический результат:* Метод всегда возвращает true
# Тест для проверки:

  
    @Test
    void shouldReturnFalseWhenPayFails() {
    Account from = new SavingAccount(1000, 500, 10000, 5);
    Account to = new CreditAccount(0, 5000, 5);
    int amount = 2000; // ССумма, при списании которой баланс упадёт ниже minBalance (500)
    
    boolean result = bank.transfer(from, to, amount);
    
    assertFalse(result);}

# Скриншот:


<img width="1762" height="1019" alt="image" src="https://github.com/user-attachments/assets/88162385-658a-4828-b060-68d0fb5fdd9a" />



# Окружение
* **Устройство:** ПК
* **Операционная система:** Windows 11,
* **Браузер:** Google Chrome Версия: 137.0.7151.120 (Официальная сборка)(64 бит)
* **JAVA:** OpenJDK 11