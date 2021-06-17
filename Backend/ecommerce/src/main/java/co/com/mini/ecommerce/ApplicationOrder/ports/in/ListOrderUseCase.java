package co.com.mini.ecommerce.ApplicationOrder.ports.in;

import co.com.mini.ecommerce.Application.commons.operation.ApplicationUseCase;
import co.com.mini.ecommerce.ApplicationOrder.model.ListOrderRequest;
import co.com.mini.ecommerce.ApplicationOrder.model.ListOrderResponse;

public interface ListOrderUseCase extends ApplicationUseCase <ListOrderRequest, ListOrderResponse> {
}
