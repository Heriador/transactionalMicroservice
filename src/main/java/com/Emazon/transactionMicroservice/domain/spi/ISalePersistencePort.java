package com.Emazon.transactionMicroservice.domain.spi;

import com.Emazon.transactionMicroservice.domain.model.Sale;

public interface ISalePersistencePort {
    void createSale(Sale sale);
}
