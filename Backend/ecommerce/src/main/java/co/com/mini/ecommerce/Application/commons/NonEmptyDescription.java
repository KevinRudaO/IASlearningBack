package co.com.mini.ecommerce.Application.commons;

public class NonEmptyDescription extends NonEmptyString{

    private final String value;

    public NonEmptyDescription(String value) {
        super(value);
        Validate.characterMax280(value,"this value must not be greater than 280");
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
