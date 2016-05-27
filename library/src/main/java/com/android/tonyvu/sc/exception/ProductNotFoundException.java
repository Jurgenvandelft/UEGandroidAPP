package com.android.tonyvu.sc.exception;

public class ProductNotFoundException extends RuntimeException {
    private static final long serialVersionUID = 43L;

    private static final String DEFAULT_MESSAGE = "Product niet gevonden in de winkelwagen.";

    public ProductNotFoundException() {
        super(DEFAULT_MESSAGE);
    }

    public ProductNotFoundException(String message) {
        super(message);
    }
}
