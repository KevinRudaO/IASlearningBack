package co.com.mini.ecommerce.Application.service;

import co.com.mini.ecommerce.Application.domain.Product;
import co.com.mini.ecommerce.Application.model.ListProductRequest;
import co.com.mini.ecommerce.Application.model.ListProductResponse;
import co.com.mini.ecommerce.Application.ports.in.ListProductUseCase;
import co.com.mini.ecommerce.Application.ports.out.ProductRepository;

import java.util.Collection;

public class ListProductService implements ListProductUseCase {

    private final ProductRepository repository;

    public ListProductService(ProductRepository repository) {
        this.repository = repository;
    }


    @Override
    public ListProductResponse execute(ListProductRequest request) {
        Collection<Product> products = repository.listProduct();
        return new ListProductResponse(products);
    }
}
