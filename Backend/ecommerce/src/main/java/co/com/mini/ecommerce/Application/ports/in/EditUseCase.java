package co.com.mini.ecommerce.Application.ports.in;

import co.com.mini.ecommerce.Application.commons.operation.ApplicationUseCase;
import co.com.mini.ecommerce.Application.model.ProductRequestEdit;
import co.com.mini.ecommerce.Application.model.ProductResponseEdit;

public interface EditUseCase extends ApplicationUseCase <ProductRequestEdit, ProductResponseEdit>{
}
