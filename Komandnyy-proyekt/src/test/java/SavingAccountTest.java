import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SavingAccountTest {

    @Test
    public void shouldAddLessThanMaxBalance() {
        SavingAccount account = new SavingAccount(
                2_000,
                1_000,
                10_000,
                5
        );

        account.add(3_000);

        Assertions.assertEquals(2_000 + 3_000, account.getBalance());
    }

    @Test
    public void shouldPayWhenBalanceRemainsAboveMin() {
        SavingAccount account = new SavingAccount(
                2_000,
                1_000,
                10_000,
                5
        );

        account.pay(5_000);

        Assertions.assertEquals(2_000 - 5_000, account.getBalance());
    }

    @Test
    public void shouldNotChangeBalanceWhenPaymentExceedsMinBalance() {
        SavingAccount account = new SavingAccount(
                1_200,
                1_000,
                10_000,
                5
        );

        boolean result = account.pay(300);

        Assertions.assertFalse(result);

        Assertions.assertEquals(1_200, account.getBalance());
    }

    @Test
    public void shouldThrowExceptionWhenInitialBalanceBelowMin() {
        Exception exception = Assertions.assertThrows(IllegalArgumentException.class,
                () -> new SavingAccount(500, 1000, 10000, 5));

        Assertions.assertTrue(exception.getMessage().contains("баланс"));
    }

    @Test
    public void shouldThrowExceptionWhenInitialBalanceBelowMax() {
        Exception exception = Assertions.assertThrows(IllegalArgumentException.class,
                () -> new SavingAccount(15000, 1000, 10000, 5));

        Assertions.assertTrue(exception.getMessage().contains("баланс"));
    }

    @Test
    public void shouldCalculateYearChangeCorrectly() {
        SavingAccount account = new SavingAccount(150, 0, 10000, 5);

        int result = account.yearChange();

        Assertions.assertEquals(7, result,
                "Должно быть: 150 * 5 / 100 = 7.5 → 7");
        // Фактически: 150 / 100 = 1 * 5 = 5
    }
}
