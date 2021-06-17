package co.com.mini.ecommerce.Application.commons;

public class NonEmptyName extends NonEmptyString{
    private final String value;

    public NonEmptyName(String value) {
        super(value);
        Validate.characterMax(value,"this value must not be greater than 100");
        this.value=value;
    }

    @Override
    public String getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "NonEmptyName{" +
                "value='" + value + '\'' +
                '}';
    }
}
