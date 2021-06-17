package co.com.mini.ecommerce.ApplicationOrder.model;

import co.com.mini.ecommerce.Application.commons.operation.ApplicationResponse;
import co.com.mini.ecommerce.ApplicationOrder.domain.Order;

import java.util.Collection;

public class ListOrderResponse implements ApplicationResponse {

    private final Collection<Order>orderItems;

    public ListOrderResponse(Collection<Order> orderItems) {
        this.orderItems = orderItems;
    }

    public Collection<Order> getOrderItems() {
        return orderItems;
    }
}
