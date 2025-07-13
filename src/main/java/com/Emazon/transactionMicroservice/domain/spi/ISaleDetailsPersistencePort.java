package com.Emazon.transactionMicroservice.domain.spi;

import com.Emazon.transactionMicroservice.domain.model.SaleDetails;

public interface ISaleDetailsPersistencePort {
    void createSaleDetails(SaleDetails saleDetail);
}
