package co.com.mini.ecommerce.Application.model;

import co.com.mini.ecommerce.Application.commons.operation.ApplicationRequest;

import java.util.Objects;

public class CreateProductRequest implements ApplicationRequest {
    private int ProductId;
    private String Name;
    private String Description;
    private float BasePrice;
    private float TaxRate;
    private String ProductStatus;
    private int InventoryQuantity;

    public CreateProductRequest() {
    }

    public CreateProductRequest(int productId, String name, String description, float basePrice, float taxRate, String productStatus, int inventoryQuantity) {
        ProductId = productId;
        Name = name;
        Description = description;
        BasePrice = basePrice;
        TaxRate = taxRate;
        ProductStatus = productStatus;
        InventoryQuantity = inventoryQuantity;
    }

    public int getProductId() {
        return ProductId;
    }

    public void setProductId(int productId) {
        ProductId = productId;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public float getBasePrice() {
        return BasePrice;
    }

    public void setBasePrice(float basePrice) {
        BasePrice = basePrice;
    }

    public float getTaxRate() {
        return TaxRate;
    }

    public void setTaxRate(float taxRate) {
        TaxRate = taxRate;
    }

    public String getProductStatus() {
        return ProductStatus;
    }

    public void setProductStatus(String productStatus) {
        ProductStatus = productStatus;
    }

    public int getInventoryQuantity() {
        return InventoryQuantity;
    }

    public void setInventoryQuantity(int inventoryQuantity) {
        InventoryQuantity = inventoryQuantity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CreateProductRequest that = (CreateProductRequest) o;
        return ProductId == that.ProductId && Float.compare(that.BasePrice, BasePrice) == 0 && Float.compare(that.TaxRate, TaxRate) == 0 && InventoryQuantity == that.InventoryQuantity && Objects.equals(Name, that.Name) && Objects.equals(Description, that.Description) && Objects.equals(ProductStatus, that.ProductStatus);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ProductId, Name, Description, BasePrice, TaxRate, ProductStatus, InventoryQuantity);
    }

    @Override
    public String toString() {
        return "CreateProductRequest{" +
                "ProductId=" + ProductId +
                ", Name='" + Name + '\'' +
                ", Description='" + Description + '\'' +
                ", BasePrice=" + BasePrice +
                ", TaxRate=" + TaxRate +
                ", ProductStatus='" + ProductStatus + '\'' +
                ", InventoryQuantity=" + InventoryQuantity +
                '}';
    }
}
