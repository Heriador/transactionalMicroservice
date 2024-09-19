package com.Emazon.transactionMicroservice.domain.usecases;

import com.Emazon.transactionMicroservice.domain.api.ISupplyServicePort;
import com.Emazon.transactionMicroservice.domain.model.Supply;
import com.Emazon.transactionMicroservice.domain.spi.IAuthenticationPersistencePort;
import com.Emazon.transactionMicroservice.domain.spi.IStockPersistencePort;
import com.Emazon.transactionMicroservice.domain.spi.ISupplyPersistencePort;

public class SupplyUseCases implements ISupplyServicePort {

    private final ISupplyPersistencePort supplyPersistencePort;
    private final IAuthenticationPersistencePort authenticationPersistencePort;
    private final IStockPersistencePort stockPersistencePort;

    public SupplyUseCases(ISupplyPersistencePort supplyPersistencePort, IAuthenticationPersistencePort authenticationPersistencePort, IStockPersistencePort stockPersistencePort) {
        this.supplyPersistencePort = supplyPersistencePort;
        this.authenticationPersistencePort = authenticationPersistencePort;
        this.stockPersistencePort = stockPersistencePort;
    }

    @Override
    public void addSupply(Supply supply) {

    }
}
