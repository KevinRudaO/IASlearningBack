package co.com.mini.ecommerce.Application.service;

import co.com.mini.ecommerce.Application.commons.*;
import co.com.mini.ecommerce.Application.domain.EnumProductStatus;
import co.com.mini.ecommerce.Application.domain.IdentificationNumber;
import co.com.mini.ecommerce.Application.domain.Product;
import co.com.mini.ecommerce.Application.errors.InputDataError;
import co.com.mini.ecommerce.Application.model.CreateProductRequest;
import co.com.mini.ecommerce.Application.model.ProductRequestEdit;
import co.com.mini.ecommerce.Application.model.ProductResponseEdit;
import co.com.mini.ecommerce.Application.ports.in.EditUseCase;
import co.com.mini.ecommerce.Application.ports.out.ProductRepository;

import java.util.Optional;

public class EditProductService implements EditUseCase {
    private final ProductRepository productRepository;

    public EditProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public ProductResponseEdit execute(ProductRequestEdit request) {
        Product product = validateInput(request);

        IdentificationNumber identificationNumber = product.getProductId();
        Optional<Product> productById = productRepository.getProductById(identificationNumber);

        productRepository.editProduct(product);
        return null;
    }

    private Product validateInput (ProductRequestEdit request){
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
