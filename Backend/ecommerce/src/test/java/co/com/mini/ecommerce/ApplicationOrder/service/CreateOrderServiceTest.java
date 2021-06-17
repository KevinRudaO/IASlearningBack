package co.com.mini.ecommerce.ApplicationOrder.service;

import co.com.mini.ecommerce.Application.commons.NonEmptyBasePrice;
import co.com.mini.ecommerce.Application.commons.NonEmptyString;
import co.com.mini.ecommerce.ApplicationOrder.domain.Order;
import co.com.mini.ecommerce.ApplicationOrder.domain.OrderIdentificationNumber;
import co.com.mini.ecommerce.ApplicationOrder.errors.OrderAlreadyExistsError;
import co.com.mini.ecommerce.ApplicationOrder.model.CreateOrderRequest;
import co.com.mini.ecommerce.ApplicationOrder.model.CreateOrderResponse;
import co.com.mini.ecommerce.ApplicationOrder.ports.out.OrderRepository;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.Mockito;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class CreateOrderServiceTest {
    @Test
    void ifOrderExistsItGetsCreated(){
        //Arrange
        OrderRepository repository = Mockito.mock(OrderRepository.class);
        Mockito.when(repository.getOrderById(ArgumentMatchers.any(OrderIdentificationNumber.class)))
                .thenReturn(Optional.empty());
        CreateOrderService service = new CreateOrderService(repository);
        final int clientId =1695;
        CreateOrderRequest request = new CreateOrderRequest(clientId,"gasg2","alexandre",18500);
        //Act
        CreateOrderResponse response = service.execute(request);
        //Assert
        assertAll(
                ()->assertDoesNotThrow(()->service.execute(request)),
                ()->assertEquals(response.getOrder().getClientId().getValue(), clientId),
                ()->Mockito.verify(repository,Mockito.times(2))
        );
    }

}