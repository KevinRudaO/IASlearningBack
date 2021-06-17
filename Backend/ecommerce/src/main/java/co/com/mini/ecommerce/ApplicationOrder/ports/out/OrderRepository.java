package co.com.mini.ecommerce.ApplicationOrder.ports.out;


import co.com.mini.ecommerce.ApplicationOrder.domain.Order;
import co.com.mini.ecommerce.ApplicationOrder.domain.OrderIdentificationNumber;

import java.util.Collection;
import java.util.Optional;

public interface OrderRepository {
    Optional<Order> getOrderById (OrderIdentificationNumber orderId);
    void storeOrder(Order order);
    Collection<Order>listOrder();
}
