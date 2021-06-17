package co.com.mini.ecommerce.Application.commons.operation;

public interface ApplicationUseCase <IN extends ApplicationRequest,OUT extends ApplicationResponse >{
    OUT execute (IN request);
}
