package co.com.mini.ecommerce.Application.model;

import co.com.mini.ecommerce.Application.commons.operation.ApplicationResponse;
import co.com.mini.ecommerce.Application.domain.Product;

public class ProductResponseEdit implements ApplicationResponse {
    private final Product product;

    public ProductResponseEdit(Product product) {
        this.product = product;
    }

    public Product getProduct() {

        return product;
    }

    @Override
    public String toString() {
        return "ProductResponseEdit{" +
                "product=" + product +
                '}';
    }
}
