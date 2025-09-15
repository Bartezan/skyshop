package org.skypro.skyshop.model.errors;

public class ShopError {
    private final String code;
    private final String message;

    public ShopError(int code, String message) {
        this.code = String.valueOf(code);
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
