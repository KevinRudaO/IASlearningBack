package co.com.mini.ecommerce.ApplicationOrder.service;

import co.com.mini.ecommerce.ApplicationOrder.domain.Order;
import co.com.mini.ecommerce.ApplicationOrder.model.ListOrderRequest;
import co.com.mini.ecommerce.ApplicationOrder.model.ListOrderResponse;
import co.com.mini.ecommerce.ApplicationOrder.ports.in.ListOrderUseCase;
import co.com.mini.ecommerce.ApplicationOrder.ports.out.OrderRepository;

import java.util.Collection;

public class ListOrderService implements ListOrderUseCase {
    private final OrderRepository orderRepository;

    public ListOrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public ListOrderResponse execute(ListOrderRequest request) {

        Collection<Order>orders = orderRepository.listOrder();
        return new ListOrderResponse(orders);
    }
}
