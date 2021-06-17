package co.com.mini.ecommerce.Application.errors;

import co.com.mini.ecommerce.Application.commons.error.ApplicationError;
import co.com.mini.ecommerce.Application.commons.error.HttpStatusCode;

import java.util.Map;

public class ExternalSystemError extends ApplicationError {
    private final String message;
    private final Throwable throwable;

    public ExternalSystemError(String message, Throwable throwable) {
        this.message = message;
        this.throwable = throwable;
    }

    @Override
    public String getMessage() {
        return message;
    }

    @Override
    public String errorCode() {
        return "EXTERNAL_SYSTEM_ERROR";
    }

    @Override
    public HttpStatusCode httpStatusCode() {
        return HttpStatusCode.INTERNAL_SERVER_ERROR;
    }

    @Override
    public Map<String, Object> metadata() {
        return Map.of(
                "throwable",throwable
        );
    }
}
