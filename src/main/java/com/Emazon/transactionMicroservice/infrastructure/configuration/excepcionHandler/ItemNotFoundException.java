package com.Emazon.transactionMicroservice.infrastructure.configuration.excepcionHandler;

public class ItemNotFoundException extends RuntimeException {
    public ItemNotFoundException(String message) {
        super(message);
    }
}
