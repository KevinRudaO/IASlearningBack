package co.com.mini.ecommerce.Application.errors;

import co.com.mini.ecommerce.Application.commons.error.ApplicationError;
import co.com.mini.ecommerce.Application.commons.error.HttpStatusCode;
import co.com.mini.ecommerce.Application.domain.IdentificationNumber;

import java.util.Map;

public class ProductAlreadyExistsError extends ApplicationError {
    private final IdentificationNumber identificationNumber;

    public ProductAlreadyExistsError(IdentificationNumber identificationNumber) {
        this.identificationNumber = identificationNumber;
    }

    public IdentificationNumber getIdentificationNumber() {
        return identificationNumber;
    }

    @Override
    public String errorCode() {
        return null;
    }

    @Override
    public HttpStatusCode httpStatusCode() {
        return null;
    }

    @Override
    public Map<String, Object> metadata() {
        return super.metadata();
    }
}
