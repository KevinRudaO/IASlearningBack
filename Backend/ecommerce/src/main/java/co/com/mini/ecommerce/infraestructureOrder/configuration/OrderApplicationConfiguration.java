package co.com.mini.ecommerce.infraestructureOrder.configuration;


import co.com.mini.ecommerce.ApplicationOrder.ports.in.CreateOrderUseCase;
import co.com.mini.ecommerce.ApplicationOrder.ports.in.ListOrderUseCase;
import co.com.mini.ecommerce.ApplicationOrder.ports.out.OrderRepository;
import co.com.mini.ecommerce.ApplicationOrder.service.CreateOrderService;
import co.com.mini.ecommerce.ApplicationOrder.service.ListOrderService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OrderApplicationConfiguration {

    @Bean
    public CreateOrderUseCase createOrderUseCase(OrderRepository orderRepository){
        return new CreateOrderService(orderRepository);
    }
    @Bean
    public ListOrderUseCase listOrderUseCase(OrderRepository orderRepository){
        return new ListOrderService(orderRepository) {
        };
    }
}
