package co.com.mini.ecommerce.infraestructure.configuration;

import co.com.mini.ecommerce.Application.ports.in.CreateProductUseCase;
import co.com.mini.ecommerce.Application.ports.in.EditUseCase;
import co.com.mini.ecommerce.Application.ports.in.IdentificationUseCase;
import co.com.mini.ecommerce.Application.ports.in.ListProductUseCase;
import co.com.mini.ecommerce.Application.ports.out.ProductRepository;
import co.com.mini.ecommerce.Application.service.CreateProductService;
import co.com.mini.ecommerce.Application.service.EditProductService;
import co.com.mini.ecommerce.Application.service.ListProductService;
import co.com.mini.ecommerce.Application.service.ProductIdService;
import co.com.mini.ecommerce.infraestructure.adapters.out.SqlProductRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ProductApplicationConfiguration {


    @Bean
    public EditUseCase editUseCase(SqlProductRepository sqlProductRepository){
        return new EditProductService(sqlProductRepository);
    }
    @Bean
    public IdentificationUseCase identificationUseCase (SqlProductRepository sqlProductRepository){
        return new ProductIdService(sqlProductRepository);
    }

    @Bean
    public CreateProductUseCase createProductUseCase(ProductRepository productRepository){
        return new CreateProductService(productRepository);
    }
    @Bean
    public ListProductUseCase listProductUseCase(ProductRepository repository){
        return new ListProductService(repository);
    }
}
