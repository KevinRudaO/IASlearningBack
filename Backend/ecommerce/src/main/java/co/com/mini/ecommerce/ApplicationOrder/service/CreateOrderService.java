package co.com.mini.ecommerce.ApplicationOrder.service;

import co.com.mini.ecommerce.Application.commons.NonEmptyBasePrice;
import co.com.mini.ecommerce.Application.commons.NonEmptyString;

import co.com.mini.ecommerce.Application.errors.InputDataError;
import co.com.mini.ecommerce.ApplicationOrder.domain.Order;
import co.com.mini.ecommerce.ApplicationOrder.domain.OrderIdentificationNumber;
import co.com.mini.ecommerce.ApplicationOrder.model.CreateOrderRequest;
import co.com.mini.ecommerce.ApplicationOrder.model.CreateOrderResponse;
import co.com.mini.ecommerce.ApplicationOrder.ports.in.CreateOrderUseCase;
import co.com.mini.ecommerce.ApplicationOrder.ports.out.OrderRepository;

import java.util.Optional;

public class CreateOrderService implements CreateOrderUseCase {
    private final OrderRepository orderRepository;

    public CreateOrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public CreateOrderResponse execute(CreateOrderRequest request) {
        Order order=validateInput(request);

        orderRepository.storeOrder(order);
        return new CreateOrderResponse(order);
    }
    private Order validateInput (CreateOrderRequest request){
        try {
            OrderIdentificationNumber clientId = new OrderIdentificationNumber(request.getClientId());
            NonEmptyString productName = new NonEmptyString(request.getProductName());
            NonEmptyString clientName = new NonEmptyString(request.getClientName());
            NonEmptyBasePrice totalPrice = new NonEmptyBasePrice(request.getTotalPrice());

            return new Order(
                    clientId,
                    new NonEmptyString ("approved"),
                    totalPrice,
                    clientName,
                    productName
            );
        }catch (RuntimeException Re){
        throw new InputDataError(Re.getMessage());
        }
    }
}
