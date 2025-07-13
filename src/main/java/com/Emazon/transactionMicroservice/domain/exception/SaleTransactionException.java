package com.Emazon.transactionMicroservice.domain.exception;

public class SaleTransactionException extends RuntimeException {
    public SaleTransactionException(String message) {
        super(message);
    }
}
