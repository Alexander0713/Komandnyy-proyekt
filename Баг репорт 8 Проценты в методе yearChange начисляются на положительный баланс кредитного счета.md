# Описание.

Метод (yearChange) в классе CreditAccount неправильно рассчитывает годовые проценты - начисляет их на любой баланс, включая положительный.

# Локация дефекта:
 
https://github.com/Alexander0713/Komandnyy-proyekt/blob/f2dbb2d1978b0270423be66de7734c22d4d6c416/src/main/java/ru/netology/javaqadiplom/CreditAccount.java#L81-L87

# Шаги воспроизведения:

1. Открыть [код программы](https://github.com/Alexander0713/Komandnyy-proyekt/blob/7e01d1602ba0e7787782ab0ac6d54e4d04a0db01/src/main/java/ru/netology/javaqadiplom/SavingAccount.java#L44) в IDEA. 
1. Открыть класс для тестирования CreditAccountTest.java
1. Добавьте тестовый метод
1.  Создать кредитный счет с начальной суммой 5000 рублей, максимальный долг: 10000 рублей, процентная ставка: 15%
1. Вызвать метод расчета годовых процентов
1. Запустить тест
1. Посмотреть результат в консоли



*Ожидаемый результат:* Проценты не начисляются на положительный баланс

*Фактический результат:* Проценты начисляются на положительный баланс.

# Тест для проверки:
    @Test
     public void shouldReturnZeroForPositiveBalance() {
    CreditAccount account = new CreditAccount(5000, 10000, 15);
    assertEquals(0, account.yearChange());
}


# Скриншот:

<img width="1667" height="1010" alt="Image" src="https://github.com/user-attachments/assets/70c1afdf-f106-4049-abac-ef695acd0149" />

# Окружение
* **Устройство:** ПК
* **Операционная система:** Windows 11,
* **Браузер:** Google Chrome Версия: 137.0.7151.120 (Официальная сборка)(64 бит)
* **JAVA:** OpenJDK 11