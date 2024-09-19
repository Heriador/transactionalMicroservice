package com.Emazon.transactionMicroservice.domain.spi;

import com.Emazon.transactionMicroservice.domain.model.Supply;

public interface ISupplyPersistencePort {
    void addSupply(Supply supply);
}
