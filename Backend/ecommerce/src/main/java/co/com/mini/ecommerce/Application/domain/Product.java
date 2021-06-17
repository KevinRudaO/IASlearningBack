package co.com.mini.ecommerce.Application.domain;

import co.com.mini.ecommerce.Application.commons.*;


public class Product {


    private final IdentificationNumber ProductId;
    private final NonEmptyName Name;
    private final NonEmptyDescription Description;
    private final NonEmptyBasePrice BasePrice;
    private final NonEmptyTaxRate TaxRate;
    private final EnumProductStatus ProductStatus;
    private final NonEmptyInvQuantity InventoryQuantity;


    public Product(IdentificationNumber productId, NonEmptyName name, NonEmptyDescription description, NonEmptyBasePrice basePrice, NonEmptyTaxRate taxRate, EnumProductStatus productStatus, NonEmptyInvQuantity inventoryQuantity) {

        Validate.notNull(productId,"id cant be null");
        Validate.notNull(name,"Name cant be null");
        Validate.notNull(description,"description cant be null");
        Validate.notNull(basePrice,"Base price cant be null");
        Validate.notNull(taxRate,"Tax rate cant be null");
        Validate.notNull(productStatus,"Product Status cant be null");
        Validate.notNull(inventoryQuantity," Inventory quality cant be null");

        this.ProductId = productId;
        this.Name = name;
        this.Description = description;
        this.BasePrice = basePrice;
        this.TaxRate = taxRate;
        this.ProductStatus = productStatus;
        this.InventoryQuantity = inventoryQuantity;
    }



    public IdentificationNumber getProductId() {
        return ProductId;
    }

    public NonEmptyName getName() {
        return Name;
    }

    public NonEmptyDescription getDescription() {
        return Description;
    }

    public NonEmptyBasePrice getBasePrice() {
        return BasePrice;
    }

    public NonEmptyTaxRate getTaxRate() {
        return TaxRate;
    }

    public EnumProductStatus getProductStatus() {
        return ProductStatus;
    }

    public NonEmptyInvQuantity getInventoryQuantity() {
        return InventoryQuantity;
    }
}
