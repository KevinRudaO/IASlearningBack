package co.com.mini.ecommerce.Application.model;

import co.com.mini.ecommerce.Application.commons.operation.ApplicationRequest;

import java.util.Objects;

public class ProductRequestIdentification implements ApplicationRequest {

    private int ProductId;

    public ProductRequestIdentification(int productId) {
        ProductId = productId;
    }

    public int getProductId() {
        return ProductId;
    }

    public void setProductId(int productId) {
        ProductId = productId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductRequestIdentification that = (ProductRequestIdentification) o;
        return ProductId == that.ProductId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(ProductId);
    }

    @Override
    public String toString() {
        return "ProductRequestIdentification{" +
                "ProductId=" + ProductId +
                '}';
    }
}
