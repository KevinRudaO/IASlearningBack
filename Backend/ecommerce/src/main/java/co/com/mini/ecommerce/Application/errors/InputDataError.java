package co.com.mini.ecommerce.Application.errors;

import co.com.mini.ecommerce.Application.commons.error.ApplicationError;
import co.com.mini.ecommerce.Application.commons.error.HttpStatusCode;

public class InputDataError extends ApplicationError {

    private final String message;

    public InputDataError(String message) {
        this.message = message;
    }

    @Override
    public String errorCode() {
        return "INPUT_DATA_ERROR";
    }

    @Override
    public HttpStatusCode httpStatusCode() {
        return HttpStatusCode.BAD_REQUEST;
    }
}
