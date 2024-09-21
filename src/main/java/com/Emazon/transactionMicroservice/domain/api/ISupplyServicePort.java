package com.Emazon.transactionMicroservice.domain.api;

import com.Emazon.transactionMicroservice.domain.model.Supply;

import java.time.LocalDate;

public interface ISupplyServicePort {
    void addSupply(Supply supply);

    LocalDate getNextSupplyDate(Long itemId);
}
