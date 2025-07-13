package com.Emazon.transactionMicroservice.infrastructure.configuration.excepcionHandler;

import com.Emazon.transactionMicroservice.domain.exception.InsufficientStockException;
import com.Emazon.transactionMicroservice.domain.exception.ItemNotFoundException;
import com.Emazon.transactionMicroservice.domain.exception.SaleTransactionException;
import com.Emazon.transactionMicroservice.domain.exception.SupplyTransactionException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Map;

@RestControllerAdvice
public class ControllerAdvisor {

    @ExceptionHandler(ItemNotFoundException.class)
    public ResponseEntity<Map<String,String>> handleItemNotFoundException(ItemNotFoundException e) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Map.of("message",e.getMessage()));
    }

    @ExceptionHandler(SupplyTransactionException.class)
    public ResponseEntity<Map<String,String>> handleSupplyTransactionException(SupplyTransactionException e) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Map.of("message",e.getMessage()));
    }

    @ExceptionHandler(InsufficientStockException.class)
    public ResponseEntity<Map<String,String>> handleInsufficientStockException(InsufficientStockException e) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Map.of("message",e.getMessage()));
    }

    @ExceptionHandler(SaleTransactionException.class)
    public ResponseEntity<Map<String,String>> handleSaleTransactionException(SaleTransactionException e) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Map.of("message",e.getMessage()));
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Map<String,String>> handleException(Exception e) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(Map.of("message",e.getMessage()));
    }

}
