/**
 * Кредитный счёт
 * Может иметь баланс вплоть до отрицательного, но до указанного кредитного лимита.
 * Имеет ставку - количество процентов годовых на сумму на балансе, если она меньше нуля.
 */
public class CreditAccount extends Account {
    protected int creditLimit;

    /**
     * Создаёт новый объект кредитного счёта с заданными параметрами.
     * Если параметры некорректны (кредитный лимит отрицательный и так далее), то
     * должно выкидываться исключения вида IllegalArgumentException.
     *
     * @param initialBalance - неотрицательное число, начальный баланс для счёта
     * @param creditLimit    - неотрицательное число, максимальная сумма которую можно задолжать банку
     * @param rate           - неотрицательное число, ставка кредитования для расчёта долга за отрицательный баланс
     */
    public CreditAccount(int initialBalance, int creditLimit, int rate) {
        if (initialBalance < 0) {
            throw new IllegalArgumentException("Начальный баланс не может быть отрицательным: " + initialBalance);
        }
        if (creditLimit <= 0) {
            throw new IllegalArgumentException("Кредитный лимит не может быть отрицательным: " + creditLimit);
        }
        if (rate < 0) {
            throw new IllegalArgumentException("Ставка не может быть отрицательной: " + rate);
        }

        this.balance = initialBalance;
        this.creditLimit = creditLimit;
        this.rate = rate;
    }

    @Override
    public boolean pay(int amount) {
        if (amount <= 0) {
            return false;
        }

        if (balance - amount >= -creditLimit) {
            balance = balance - amount;
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean add(int amount) {
        if (amount <= 0) {
            return false;
        }

        balance += amount;
        return true;
    }

    @Override
    public int yearChange() {
        if (balance >= 0) {
            return 0;
        }

        double interest = (double) balance * rate / 100.0;
        return (int) Math.round(interest);
    }

    public int getCreditLimit() {
        return creditLimit;
    }

    public int getBalance() {
        return balance;
    }
}
