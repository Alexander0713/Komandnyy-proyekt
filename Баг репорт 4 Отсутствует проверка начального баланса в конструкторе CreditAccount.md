# Описание.
Конструктор класса CreditAccount не проверяет, что начальный баланс является неотрицательным числом.
# Локация дефекта:
        
https://github.com/Alexander0713/Komandnyy-proyekt/blob/f2dbb2d1978b0270423be66de7734c22d4d6c416/src/main/java/ru/netology/javaqadiplom/CreditAccount.java#L19-L28

# Шаги воспроизведения:

 
1. Открыть код программы в IDEA. 
1. Открыть класс для тестирования CreditAccountTest.java
1. Добавить тестовый метод
1. Попытаться создать кредитный счет с отрицательным кредитным лимитом: new CreditAccount(-1000, 5000, 15)
1. Запустить тест
1. Посмотреть результат в консоли

*Ожидаемый результат:* Должно быть IllegalArgumentException

*Фактический результат:* Объект создается без исключения
# Тест для проверки:

    @Test
    void shouldThrowExceptionWhenCreditLimitNegative() {
    assertThrows(IllegalArgumentException.class, () -> {
        new CreditAccount(-1000, 5000, 15);
    });}

# Скриншот:

<img width="1674" height="1031" alt="Image" src="https://github.com/user-attachments/assets/b50a45f9-7ac8-4ac8-ad53-baec95e3fce3" />


# Окружение
* **Устройство:** ПК
* **Операционная система:** Windows 11,
* **Браузер:** Google Chrome Версия: 137.0.7151.120 (Официальная сборка)(64 бит)
* **JAVA:** OpenJDK 11
