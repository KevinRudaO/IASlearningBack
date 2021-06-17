package co.com.mini.ecommerce.Application.service;

import co.com.mini.ecommerce.Application.domain.IdentificationNumber;
import co.com.mini.ecommerce.Application.domain.Product;
import co.com.mini.ecommerce.Application.model.ListProductResponse;
import co.com.mini.ecommerce.Application.model.ProductRequestIdentification;
import co.com.mini.ecommerce.Application.ports.in.IdentificationUseCase;
import co.com.mini.ecommerce.infraestructure.adapters.out.SqlProductRepository;

import java.util.Collection;

public class ProductIdService implements IdentificationUseCase {
    private final SqlProductRepository sqlProductRepository;

    public ProductIdService(SqlProductRepository sqlProductRepository) {
        this.sqlProductRepository = sqlProductRepository;
    }

    @Override
    public ListProductResponse execute(ProductRequestIdentification request) {
        Collection<Product> products =sqlProductRepository.getProductId(new IdentificationNumber(request.getProductId()));
        return new ListProductResponse(products);
    }
}
