package com.Emazon.transactionMicroservice.domain.spi;

import com.Emazon.transactionMicroservice.domain.model.Supply;

import java.time.LocalDate;

public interface ISupplyPersistencePort {
    void addSupply(Supply supply);

    LocalDate getNextSupplyDate(Long itemId);
}
