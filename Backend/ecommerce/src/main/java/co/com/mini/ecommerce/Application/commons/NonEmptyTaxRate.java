package co.com.mini.ecommerce.Application.commons;

public class NonEmptyTaxRate {

    private float value;

    public NonEmptyTaxRate(float value) {
        Validate.notNull(value,"Tax rate cant be not null");
        Validate.BetweenZeroandOne(value,"Tax rate should be between zero and one");
        this.value = value;
    }

    public float getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "NonEmptyTaxRate{" +
                "value=" + value +
                '}';
    }
}
