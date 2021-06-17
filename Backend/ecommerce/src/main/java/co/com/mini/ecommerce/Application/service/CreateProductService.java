package co.com.mini.ecommerce.Application.service;

import co.com.mini.ecommerce.Application.commons.*;
import co.com.mini.ecommerce.Application.domain.EnumProductStatus;
import co.com.mini.ecommerce.Application.domain.IdentificationNumber;
import co.com.mini.ecommerce.Application.domain.Product;
import co.com.mini.ecommerce.Application.errors.InputDataError;
import co.com.mini.ecommerce.Application.errors.ProductAlreadyExistsError;
import co.com.mini.ecommerce.Application.model.CreateProductRequest;
import co.com.mini.ecommerce.Application.model.CreateProductResponse;
import co.com.mini.ecommerce.Application.ports.in.CreateProductUseCase;
import co.com.mini.ecommerce.Application.ports.out.ProductRepository;

import java.util.Optional;

public class CreateProductService  implements CreateProductUseCase {
    private final ProductRepository repository;

    public CreateProductService(ProductRepository repository) {
        this.repository = repository;
    }

    @Override
    public CreateProductResponse execute(CreateProductRequest request) {
       Product product = validateInput(request);

        IdentificationNumber identificationNumber = product.getProductId();
        Optional<Product> productById = repository.getProductById(identificationNumber);
        if(productById.isPresent()){
            throw new ProductAlreadyExistsError(identificationNumber);
        }
        repository.storeProduct(product);
        return new CreateProductResponse(product);
    }

    private Product validateInput (CreateProductRequest request){
        try {
            IdentificationNumber ProductId = new IdentificationNumber(request.getProductId());
            NonEmptyName name = new NonEmptyName(request.getName());
            NonEmptyDescription description = new NonEmptyDescription(request.getDescription());
            NonEmptyBasePrice basePrice = new NonEmptyBasePrice(request.getBasePrice());
            NonEmptyTaxRate taxRate= new NonEmptyTaxRate(request.getTaxRate());
            EnumProductStatus productStatus = EnumProductStatus.valueOf(request.getProductStatus());
            NonEmptyInvQuantity invQuantity = new NonEmptyInvQuantity(request.getInventoryQuantity());

            return new Product(
                    ProductId,
                    name,
                    description,
                    basePrice,
                    taxRate,
                    productStatus,
                    invQuantity
            );

        }catch (RuntimeException Re){
            throw new InputDataError(Re.getMessage());
        }
    }
}
