package co.com.mini.ecommerce.Application.commons.error;

public enum HttpStatusCode {
    BAD_REQUEST(400),
    INTERNAL_SERVER_ERROR(500);

    private final int code;

    HttpStatusCode(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }
}
