package co.com.mini.ecommerce.Application.commons;

public class NonEmptyInvQuantity {

    private final int value;

    public NonEmptyInvQuantity(int value) {
        Validate.notNull(value,"Quantity cant be null");
        Validate.QuantityLower(value, "Quantity should be higher than zero");
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "NonEmptyInvQuantity{" +
                "value=" + value +
                '}';
    }
}
