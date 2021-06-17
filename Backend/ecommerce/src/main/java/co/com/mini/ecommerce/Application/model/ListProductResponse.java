package co.com.mini.ecommerce.Application.model;

import co.com.mini.ecommerce.Application.commons.operation.ApplicationResponse;
import co.com.mini.ecommerce.Application.domain.Product;

import java.util.Collection;

public class ListProductResponse implements ApplicationResponse {
    private final Collection<Product> items;


    public ListProductResponse(Collection<Product> items) {
        this.items = items;
    }

    public Collection<Product> getItems() {
        return items;
    }
}
