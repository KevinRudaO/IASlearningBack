package co.com.mini.ecommerce.ApplicationOrder.domain;

import co.com.mini.ecommerce.Application.commons.StringUtils;
import co.com.mini.ecommerce.Application.commons.Validate;

import java.util.Objects;

public class OrderIdentificationNumber {

    private final int value;

    public OrderIdentificationNumber(int value) {
        Validate.notNull(value,"product Id cant be null");
        Validate.istrue(StringUtils.nonBlank(value),"Order identification can not be empty");
        this.value=value;
    }


    public int getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderIdentificationNumber that = (OrderIdentificationNumber) o;
        return value == that.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    @Override
    public String toString() {
        return "OrderIdentificationNumber{" +
                "value=" + value +
                '}';
    }
}
