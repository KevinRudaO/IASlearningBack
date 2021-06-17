package co.com.mini.ecommerce.Application.ports.in;

import co.com.mini.ecommerce.Application.commons.operation.ApplicationUseCase;
import co.com.mini.ecommerce.Application.model.CreateProductRequest;
import co.com.mini.ecommerce.Application.model.CreateProductResponse;

public interface CreateProductUseCase extends ApplicationUseCase<CreateProductRequest, CreateProductResponse> {
}
