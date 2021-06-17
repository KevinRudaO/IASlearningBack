package co.com.mini.ecommerce.ApplicationOrder.domain;

import co.com.mini.ecommerce.Application.commons.NonEmptyBasePrice;
import co.com.mini.ecommerce.Application.commons.NonEmptyString;


public class Order {

    private final OrderIdentificationNumber clientId;
    private final NonEmptyString orderStatus;
    private final NonEmptyBasePrice totalPrice;
    private final NonEmptyString clientName;
    private final NonEmptyString productName;

    public Order(OrderIdentificationNumber clientId, NonEmptyString orderStatus, NonEmptyBasePrice totalPrice, NonEmptyString clientName, NonEmptyString productName) {
        this.clientId = clientId;
        this.orderStatus = orderStatus;
        this.totalPrice = totalPrice;
        this.clientName = clientName;
        this.productName = productName;
    }

    public NonEmptyString getProductName() {
        return productName;
    }

    public OrderIdentificationNumber getClientId() {
        return clientId;
    }

    public NonEmptyString getOrderStatus() {
        return orderStatus;
    }

    public NonEmptyBasePrice getTotalPrice() {
        return totalPrice;
    }

    public NonEmptyString getClientName() {
        return clientName;
    }
}

