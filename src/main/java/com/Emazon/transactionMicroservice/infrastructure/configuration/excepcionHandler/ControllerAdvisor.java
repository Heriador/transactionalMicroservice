package com.Emazon.transactionMicroservice.infrastructure.configuration.excepcionHandler;

import com.Emazon.transactionMicroservice.domain.exception.ItemNotFoundException;
import com.Emazon.transactionMicroservice.domain.exception.SupplyTransactionException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Map;

@RestControllerAdvice
public class ControllerAdvisor {

    @ExceptionHandler(ItemNotFoundException.class)
    public ResponseEntity<Map<String,String>> handleItemNotFoundException(ItemNotFoundException e) {
        return ResponseEntity.status(404).body(Map.of("message",e.getMessage()));
    }

    @ExceptionHandler(SupplyTransactionException.class)
    public ResponseEntity<Map<String,String>> handleSupplyTransactionException(SupplyTransactionException e) {
        return ResponseEntity.status(400).body(Map.of("message",e.getMessage()));
    }

}
