package co.com.mini.ecommerce.ApplicationOrder.errors;

import co.com.mini.ecommerce.Application.commons.error.ApplicationError;
import co.com.mini.ecommerce.Application.commons.error.HttpStatusCode;
import co.com.mini.ecommerce.ApplicationOrder.domain.OrderIdentificationNumber;

import java.util.Map;

public class OrderAlreadyExistsError extends ApplicationError {
    private final OrderIdentificationNumber orderIdentificationNumber;

    public OrderAlreadyExistsError(OrderIdentificationNumber orderIdentificationNumber) {
        this.orderIdentificationNumber = orderIdentificationNumber;
    }

    public OrderIdentificationNumber getOrderIdentificationNumber() {
        return orderIdentificationNumber;
    }

    @Override
    public String errorCode() {
        return null;
    }

    @Override
    public HttpStatusCode httpStatusCode() {
        return null;
    }

    @Override
    public Map<String, Object> metadata() {
        return super.metadata();
    }
}
