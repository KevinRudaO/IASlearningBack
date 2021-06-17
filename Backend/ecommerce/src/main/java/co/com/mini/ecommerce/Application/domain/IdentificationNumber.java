package co.com.mini.ecommerce.Application.domain;

import co.com.mini.ecommerce.Application.commons.StringUtils;
import co.com.mini.ecommerce.Application.commons.Validate;

import java.util.Objects;
import java.util.regex.Pattern;

public class IdentificationNumber {

    private final int value;
    public IdentificationNumber(int value) {
        Validate.notNull(value, "IdentificationNumber can not be null");
        Validate.istrue(StringUtils.nonBlank(value), "IdentificationNumber can not be empty");
        Validate.MoreThanOne(value,"Invalid identification number: " + value);
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        IdentificationNumber that = (IdentificationNumber) o;
        return Objects.equals(value, that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    @Override
    public String toString() {
        return "IdentificationNumber{" +
                "value='" + value + '\'' +
                '}';
    }
}
