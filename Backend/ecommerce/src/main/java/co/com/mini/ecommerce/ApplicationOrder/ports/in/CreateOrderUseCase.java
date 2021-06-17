package co.com.mini.ecommerce.ApplicationOrder.ports.in;

import co.com.mini.ecommerce.Application.commons.operation.ApplicationUseCase;
import co.com.mini.ecommerce.Application.model.CreateProductRequest;
import co.com.mini.ecommerce.ApplicationOrder.model.CreateOrderRequest;
import co.com.mini.ecommerce.ApplicationOrder.model.CreateOrderResponse;

public interface CreateOrderUseCase extends ApplicationUseCase<CreateOrderRequest, CreateOrderResponse> {
}
