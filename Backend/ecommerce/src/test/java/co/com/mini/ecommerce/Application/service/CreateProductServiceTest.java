package co.com.mini.ecommerce.Application.service;

import co.com.mini.ecommerce.Application.commons.*;
import co.com.mini.ecommerce.Application.domain.EnumProductStatus;
import co.com.mini.ecommerce.Application.domain.IdentificationNumber;
import co.com.mini.ecommerce.Application.domain.Product;
import co.com.mini.ecommerce.Application.errors.ProductAlreadyExistsError;
import co.com.mini.ecommerce.Application.model.CreateProductRequest;
import co.com.mini.ecommerce.Application.model.CreateProductResponse;
import co.com.mini.ecommerce.Application.ports.out.ProductRepository;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.Mockito;


import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class CreateProductServiceTest {

    @Test
    void ifProductExitsItGetsCreated(){

        ProductRepository repository = Mockito.mock(ProductRepository.class);
        Mockito.when(repository.getProductById(ArgumentMatchers.any(IdentificationNumber.class)))
                .thenReturn(Optional.empty());
        CreateProductService createProductService= new CreateProductService(repository);
            final int productid=12;
        CreateProductRequest createProductRequest = new CreateProductRequest(
     productid,"name","description",2500,0.2f,"published",2);
         //act
       CreateProductResponse createProductResponse= createProductService.execute(createProductRequest);
        //assert
        assertAll(
                ()-> assertDoesNotThrow(()-> createProductService.execute(createProductRequest)),
                ()->assertEquals(
                        createProductResponse.getProduct().getProductId().getValue(),
                        productid),
                ()->Mockito.verify(repository,Mockito.times(2))
                .getProductById(ArgumentMatchers.any(IdentificationNumber.class))
        );
    }
    @Test
    void ifProductExistsException(){

        Product product = new Product(new IdentificationNumber(265),
                new NonEmptyName("name"),
                new NonEmptyDescription("sadasd"),
                new NonEmptyBasePrice(2600),
                new NonEmptyTaxRate(0.3f),
                EnumProductStatus.published,
                new NonEmptyInvQuantity(4)
        );
          ProductRepository repository = Mockito.mock(ProductRepository.class);
          Mockito.when(repository.getProductById(ArgumentMatchers.any(IdentificationNumber.class)))
                  .thenReturn(Optional.of(product));

          CreateProductService createProductService =new CreateProductService(repository);
          CreateProductRequest request = new CreateProductRequest(
                  product.getProductId().getValue(),
                  product.getName().getValue(),
                  product.getDescription().getValue(),
                  product.getBasePrice().getValue(),
                  product.getTaxRate().getValue(),
                  product.getProductStatus().name(),
                  product.getInventoryQuantity().getValue()
          );
          assertAll(
                  ()->assertThrows(ProductAlreadyExistsError.class,()->createProductService.execute(request)),
        ()->Mockito.verify(repository,Mockito.times(0))
                .storeProduct(ArgumentMatchers.any(Product.class))
          );

    }


}