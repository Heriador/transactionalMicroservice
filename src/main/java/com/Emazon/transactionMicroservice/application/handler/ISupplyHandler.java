package com.Emazon.transactionMicroservice.application.handler;

import com.Emazon.transactionMicroservice.application.dto.request.SupplyRequest;

public interface ISupplyHandler {
    void addSupply(SupplyRequest supplyRequest);
}
