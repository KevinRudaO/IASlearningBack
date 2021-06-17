package co.com.mini.ecommerce.ApplicationOrder.model;

import co.com.mini.ecommerce.Application.commons.operation.ApplicationResponse;
import co.com.mini.ecommerce.ApplicationOrder.domain.Order;

public class CreateOrderResponse implements ApplicationResponse {
    private final Order order;

    public CreateOrderResponse(Order order) {
        this.order = order;
    }

    public Order getOrder() {
        return order;
    }

    @Override
    public String toString() {
        return "CreateOrderResponse{" +
                "order=" + order +
                '}';
    }
}
