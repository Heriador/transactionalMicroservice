package com.Emazon.transactionMicroservice.application.handler;

import com.Emazon.transactionMicroservice.domain.api.ISaleServicePort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SaleHandler implements ISaleHandler {

    private final ISaleServicePort saleServicePort;

    public void createSale() {
        saleServicePort.createSale();
    }
}
