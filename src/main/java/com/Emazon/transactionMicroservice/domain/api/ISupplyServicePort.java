package com.Emazon.transactionMicroservice.domain.api;

import com.Emazon.transactionMicroservice.domain.model.Supply;

public interface ISupplyServicePort {
    void addSupply(Supply supply);
}
