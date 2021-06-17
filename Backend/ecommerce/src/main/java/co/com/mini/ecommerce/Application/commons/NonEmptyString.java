package co.com.mini.ecommerce.Application.commons;
import static co.com.mini.ecommerce.Application.commons.StringUtils.AntNon;
import static co.com.mini.ecommerce.Application.commons.StringUtils.nonBlank;

public class NonEmptyString {

    private final String value;

    public NonEmptyString(String value) {
        //validaciones de los tipos de variables
        Validate.notNull(value,"NonEmptyString can not be null");
        Validate.istrue(AntNon(value),"NonEmptyString can not be empty");
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "NonEmptyString{" +
                "value='" + value + '\'' +
                '}';
    }
}
