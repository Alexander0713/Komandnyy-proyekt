# Описание.
Метод yearChange некорректно рассчитывает проценты для отрицательного баланса.
# Локация дефекта:
        
https://github.com/Alexander0713/Komandnyy-proyekt/blob/f2dbb2d1978b0270423be66de7734c22d4d6c416/src/main/java/ru/netology/javaqadiplom/CreditAccount.java#L83

# Шаги воспроизведения:

 
1. Открыть код программы в IDEA. 
1. Открыть класс для тестирования CreditAccountTest.java
1. Добавьте тестовый метод
1. Создать новый кредитный счет с начальным балансом 0 рублей и кредитным лимитом 5000 рублей:  CreditAccount account = new CreditAccount(0, 5000, 15)
1. Выполнить операцию оплаты: account.pay(150)
1. Рассчитать годовые проценты: account.yearChange()
1. Запустить тест
1. Посмотреть результат в консоли

*Ожидаемый результат:* Программа должна сказать: -22 рублей

*Фактический результат:* Программа говорит: -15 рублей
# Тест для проверки:

    @Test
    public void shouldCalculateYearChangeForNegativeBalance() {
        CreditAccount account = new CreditAccount(0, 5000, 15);
        account.pay(150);


        int yearChange = account.yearChange();


        assertEquals(-22, yearChange);
    }

# Скриншот:
<img width="1650" height="1019" alt="Image" src="https://github.com/user-attachments/assets/b8f5971c-410f-407e-a84c-1b3f21376da2" />

# Окружение
* **Устройство:** ПК
* **Операционная система:** Windows 11,
* **Браузер:** Google Chrome Версия: 137.0.7151.120 (Официальная сборка)(64 бит)
* **JAVA:** OpenJDK 11
