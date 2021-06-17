package co.com.mini.ecommerce.Application.ports.in;

import co.com.mini.ecommerce.Application.commons.operation.ApplicationUseCase;
import co.com.mini.ecommerce.Application.model.ListProductRequest;
import co.com.mini.ecommerce.Application.model.ListProductResponse;

public interface ListProductUseCase extends ApplicationUseCase<ListProductRequest, ListProductResponse> {
}
