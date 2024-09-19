package com.Emazon.transactionMicroservice.application.handler;

import com.Emazon.transactionMicroservice.application.dto.SupplyRequest;

public interface ISupplyHandler {
    void addSupply(SupplyRequest supplyRequest);
}
