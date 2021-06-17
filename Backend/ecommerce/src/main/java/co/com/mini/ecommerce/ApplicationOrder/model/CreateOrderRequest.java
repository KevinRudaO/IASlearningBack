package co.com.mini.ecommerce.ApplicationOrder.model;

import co.com.mini.ecommerce.Application.commons.operation.ApplicationRequest;

import java.util.Objects;

public class CreateOrderRequest implements ApplicationRequest {

    private int clientId;
    private String productName;
    private String clientName;
    private float totalPrice;

    public CreateOrderRequest() {
    }

    public CreateOrderRequest(int clientId, String productName, String clientName, float totalPrice) {
        this.clientId = clientId;
        this.productName = productName;
        this.clientName = clientName;
        this.totalPrice = totalPrice;
    }

    public int getClientId() {
        return clientId;
    }

    public void setClientId(int clientId) {
        this.clientId = clientId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public float getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(float totalPrice) {
        this.totalPrice = totalPrice;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CreateOrderRequest that = (CreateOrderRequest) o;
        return clientId == that.clientId && Float.compare(that.totalPrice, totalPrice) == 0 && Objects.equals(productName, that.productName) && Objects.equals(clientName, that.clientName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(clientId, productName, clientName, totalPrice);
    }

    @Override
    public String toString() {
        return "CreateOrderRequest{" +
                "clientId=" + clientId +
                ", productName='" + productName + '\'' +
                ", clientName='" + clientName + '\'' +
                ", totalPrice=" + totalPrice +
                '}';
    }
}
