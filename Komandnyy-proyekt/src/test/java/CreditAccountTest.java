import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CreditAccountTest {

    @Test
    public void shouldAddToPositiveBalance() {
        CreditAccount account = new CreditAccount(
                0,
                5_000,
                15
        );

        account.add(3_000);

        Assertions.assertEquals(3_000, account.getBalance());
    }

    @Test
    void shouldNotPayWhenAmountExceedsCreditLimit() {

        CreditAccount account = new CreditAccount(1000, 5000, 15);

        boolean result = account.pay(7000);

        Assertions.assertFalse(result);
        Assertions.assertEquals(1000, account.getBalance());
    }

    @Test
    void shouldAddAmountToBalance() {
        CreditAccount account = new CreditAccount(1000, 5000, 15);

        boolean result = account.add(500);

        Assertions.assertTrue(result);
        Assertions.assertEquals(1500, account.getBalance());
    }

    @Test
    public void shouldCalculateYearChangeForNegativeBalance() {
        CreditAccount account = new CreditAccount(0, 5000, 15);
        account.pay(150);  // баланс становится -150

        int yearChange = account.yearChange();

        Assertions.assertEquals(-22, yearChange);
    }

    @Test
    void shouldThrowExceptionWhenCreditLimitNegative() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new CreditAccount(-1000, 5000, 15);
        });
    }

    @Test
    void shouldPayCorrectlyWithinCreditLimit() {
        CreditAccount account = new CreditAccount(1000, 5000, 15);

        boolean result = account.pay(6000);

        Assertions.assertTrue(result);
        Assertions.assertEquals(-5000, account.getBalance());
    }

    @Test
    public void shouldNotCreateAccountWithNegativeCreditLimit() {

        Assertions.assertThrows(IllegalArgumentException.class,
                () -> new CreditAccount(1000, -5000, 15));
    }

    @Test
    public void shouldReturnZeroForPositiveBalance() {
        CreditAccount account = new CreditAccount(5000, 10000, 15);
        Assertions.assertEquals(0, account.yearChange());
    }

    @Test
    public void shouldCreateAccountWithZeroInterestRate() {
        Assertions.assertDoesNotThrow(() ->
                new CreditAccount(1000, 5000, 0));
    }
}


