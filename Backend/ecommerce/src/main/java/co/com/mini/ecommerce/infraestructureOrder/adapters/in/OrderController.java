package co.com.mini.ecommerce.infraestructureOrder.adapters.in;

import co.com.mini.ecommerce.ApplicationOrder.model.CreateOrderRequest;
import co.com.mini.ecommerce.ApplicationOrder.model.ListOrderRequest;
import co.com.mini.ecommerce.ApplicationOrder.ports.in.CreateOrderUseCase;
import co.com.mini.ecommerce.ApplicationOrder.ports.in.ListOrderUseCase;
import co.com.mini.ecommerce.infraestructure.commons.UseCaseHttpExecutor;
import co.com.mini.ecommerce.infraestructureOrder.adapters.out.SqlOrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping(path="/Order")
public class OrderController {
    private final UseCaseHttpExecutor useCaseHttpExecutor;
    private final CreateOrderUseCase createOrderUseCase;
    private final ListOrderUseCase listOrderUseCase;
    private final SqlOrderRepository sqlOrderRepository;

    @Autowired
    public OrderController(UseCaseHttpExecutor useCaseHttpExecutor, CreateOrderUseCase createOrderUseCase, ListOrderUseCase listOrderUseCase, SqlOrderRepository sqlOrderRepository) {
        this.useCaseHttpExecutor = useCaseHttpExecutor;
        this.createOrderUseCase = createOrderUseCase;
        this.listOrderUseCase = listOrderUseCase;
        this.sqlOrderRepository = sqlOrderRepository;
    }
    @GetMapping
    public ResponseEntity listOrderHandler(){
        return useCaseHttpExecutor.executeUseCase(listOrderUseCase,new ListOrderRequest());
    }
    @PostMapping
    public ResponseEntity CreateOrderHandler(@RequestBody CreateOrderRequest request){
        return useCaseHttpExecutor.executeUseCase(createOrderUseCase, request);
    }



}
