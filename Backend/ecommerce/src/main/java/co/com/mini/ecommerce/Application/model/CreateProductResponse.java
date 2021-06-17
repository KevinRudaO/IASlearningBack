package co.com.mini.ecommerce.Application.model;

import co.com.mini.ecommerce.Application.commons.operation.ApplicationResponse;
import co.com.mini.ecommerce.Application.domain.Product;

public class CreateProductResponse implements ApplicationResponse {
 private final Product product;

    public CreateProductResponse(Product product) {

        this.product = product;
    }
    public Product getProduct() {

        return product;
    }
    @Override
    public String toString() {
        return "CreateProductResponse{" +
                "product=" + product +
                '}';
    }
}
