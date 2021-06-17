package co.com.mini.ecommerce.Application.ports.in;

import co.com.mini.ecommerce.Application.commons.operation.ApplicationUseCase;
import co.com.mini.ecommerce.Application.model.CreateProductRequest;
import co.com.mini.ecommerce.Application.model.CreateProductResponse;
import co.com.mini.ecommerce.Application.model.ListProductResponse;
import co.com.mini.ecommerce.Application.model.ProductRequestIdentification;

public interface IdentificationUseCase extends ApplicationUseCase<ProductRequestIdentification, ListProductResponse> {
}
