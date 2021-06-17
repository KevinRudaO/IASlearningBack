package co.com.mini.ecommerce.Application.ports.out;

import co.com.mini.ecommerce.Application.domain.IdentificationNumber;
import co.com.mini.ecommerce.Application.domain.Product;

import java.util.Collection;
import java.util.Optional;

public interface ProductRepository {
    Optional<Product>getProductById (IdentificationNumber IdentificationNumber);
    void storeProduct(Product product);
    void deleteProductById(long productId);
    Collection<Product>listProduct();
    Collection<Product>getProductId(IdentificationNumber identificationNumber);
    void editProduct(Product product);
}
