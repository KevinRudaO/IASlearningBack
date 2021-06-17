package co.com.mini.ecommerce.Application.commons;

public class NonEmptyBasePrice {

    private final float value;


    public NonEmptyBasePrice(float value) {

        Validate.notNull(value,"Base price cant be null");
        Validate.Lowerthanzero(value,"Base price cant be lower than 0");
        this.value = value;
    }

    public float getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "NonEmptyBasePrice{" +
                "value=" + value +
                '}';
    }
}
