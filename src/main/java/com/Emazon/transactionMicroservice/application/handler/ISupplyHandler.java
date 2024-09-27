package com.Emazon.transactionMicroservice.application.handler;

import com.Emazon.transactionMicroservice.application.dto.request.SupplyRequest;

import java.time.LocalDate;

public interface ISupplyHandler {
    void addSupply(SupplyRequest supplyRequest);

    LocalDate getNextSupplyDate(Long itemId);
}
