# Описание.

Конструктор класса CreditAccount неправильно проверяет процентную ставку - он запрещает нулевую ставку.

# Локация дефекта:
 
https://github.com/Alexander0713/Komandnyy-proyekt/blob/f2dbb2d1978b0270423be66de7734c22d4d6c416/src/main/java/ru/netology/javaqadiplom/CreditAccount.java#L20

# Шаги воспроизведения:

1. Открыть [код программы](https://github.com/Alexander0713/Komandnyy-proyekt/blob/7e01d1602ba0e7787782ab0ac6d54e4d04a0db01/src/main/java/ru/netology/javaqadiplom/SavingAccount.java#L44) в IDEA. 
1. Открыть класс для тестирования CreditAccountTest.java
1. Добавьте тестовый метод
1.  Создать кредитный счет с начальной суммой 1000 рублей, максимальный долг: 5000 рублей, процентная ставка: 0%
1. Запустить тест
1. Посмотреть результат в консоли



*Ожидаемый результат:* Объект CreditAccount успешно создается. Исключение не выбрасывается

*Фактический результат:* Выбрасывается исключение IllegalArgumentException. Сообщение: "Накопительная ставка не может быть отрицательной, а у вас: 0"

# Тест для проверки:
    @Test
    public void shouldCreateAccountWithZeroInterestRate()   {       
        Assertions.assertDoesNotThrow(() ->
                new CreditAccount(1000, 5000, 0));
    }


# Скриншот:

<img width="1647" height="950" alt="Image" src="https://github.com/user-attachments/assets/314af7ba-f323-4554-9114-5728e9698940" />

# Окружение
* **Устройство:** ПК
* **Операционная система:** Windows 11,
* **Браузер:** Google Chrome Версия: 137.0.7151.120 (Официальная сборка)(64 бит)
* **JAVA:** OpenJDK 11