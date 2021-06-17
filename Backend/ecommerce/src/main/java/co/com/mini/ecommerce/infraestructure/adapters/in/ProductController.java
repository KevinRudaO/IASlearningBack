package co.com.mini.ecommerce.infraestructure.adapters.in;

import co.com.mini.ecommerce.Application.model.CreateProductRequest;
import co.com.mini.ecommerce.Application.model.ListProductRequest;
import co.com.mini.ecommerce.Application.model.ProductRequestEdit;
import co.com.mini.ecommerce.Application.model.ProductRequestIdentification;
import co.com.mini.ecommerce.Application.ports.in.CreateProductUseCase;
import co.com.mini.ecommerce.Application.ports.in.EditUseCase;
import co.com.mini.ecommerce.Application.ports.in.IdentificationUseCase;
import co.com.mini.ecommerce.Application.ports.in.ListProductUseCase;
import co.com.mini.ecommerce.infraestructure.adapters.out.SqlProductRepository;
import co.com.mini.ecommerce.infraestructure.commons.UseCaseHttpExecutor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping(path="/Product")
public class ProductController {
    private final UseCaseHttpExecutor useCaseHttpExecutor;
    private final CreateProductUseCase createProductUseCase;
    private final ListProductUseCase listProductUseCase;
    private final SqlProductRepository sqlProductRepository;
    private final IdentificationUseCase identificationUseCase;
    private final EditUseCase editUseCase;

    @Autowired
    public ProductController(UseCaseHttpExecutor useCaseHttpExecutor, CreateProductUseCase createProductUseCase, ListProductUseCase listProductUseCase, SqlProductRepository sqlProductRepository, IdentificationUseCase identificationUseCase, EditUseCase editUseCase) {
        this.useCaseHttpExecutor = useCaseHttpExecutor;
        this.createProductUseCase = createProductUseCase;
        this.listProductUseCase = listProductUseCase;
        this.sqlProductRepository = sqlProductRepository;
        this.identificationUseCase = identificationUseCase;
        this.editUseCase = editUseCase;
    }

    @GetMapping
    public ResponseEntity listProductHandler(){
        return useCaseHttpExecutor.executeUseCase(
                listProductUseCase,
                new ListProductRequest()
        );
    }

    @PostMapping
    public ResponseEntity createProductHandler(@RequestBody CreateProductRequest request){
        return useCaseHttpExecutor.executeUseCase(
                createProductUseCase,request
        );
    }
    @DeleteMapping(path={"/Product/{productId}"})
        public void deleteProduct (@PathVariable ("productId") long productId){
        sqlProductRepository.deleteProductById(productId);

    }
    @GetMapping (path ={"/Product/{productId}"})
    public void getProductbyId (@PathVariable("productId") int productId){

        sqlProductRepository.getIdProduct(productId);
    }
    @PostMapping (path = {"/getProductId"})
    public ResponseEntity responseEntity(@RequestBody ProductRequestIdentification request){
        return useCaseHttpExecutor.executeUseCase(identificationUseCase,request);

    }


    @PutMapping (path = {"/Product"})
        public ResponseEntity updateProduct (@RequestBody ProductRequestEdit request){
                    return useCaseHttpExecutor.executeUseCase(editUseCase,request);
    }
}
