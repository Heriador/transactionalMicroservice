package com.Emazon.transactionMicroservice.domain.usecases;

import com.Emazon.transactionMicroservice.domain.api.ISupplyServicePort;
import com.Emazon.transactionMicroservice.domain.exception.SupplyTransactionException;
import com.Emazon.transactionMicroservice.domain.model.Supply;
import com.Emazon.transactionMicroservice.domain.spi.IAuthenticationPersistencePort;
import com.Emazon.transactionMicroservice.domain.spi.IStockPersistencePort;
import com.Emazon.transactionMicroservice.domain.spi.ISupplyPersistencePort;
import com.Emazon.transactionMicroservice.domain.exception.ItemNotFoundException;
import com.Emazon.transactionMicroservice.domain.util.DomainConstants;

import java.time.LocalDate;
import java.time.LocalDateTime;

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

        Long userId = authenticationPersistencePort.getAuthenticatedUserId();
        supply.setUserId(userId);

        if(!stockPersistencePort.existsItem(supply.getItemId())){
            throw new ItemNotFoundException(DomainConstants.ITEM_NOT_FOUND_EXCEPTION_MESSAGE);
        }

        if(supply.getNextSupplyDate() == null){
            throw new SupplyTransactionException(DomainConstants.NEXT_SUPPLY_DATE_IS_REQUIRED);
        }
        if(Boolean.FALSE.equals(stockPersistencePort.addStock(supply.getItemId(), supply.getQuantity()))){
            throw new SupplyTransactionException(DomainConstants.SUPPLY_TRANSACTION_FAILED_EXCEPTION_MESSAGE);
        }
        supply.setCreatedAt(LocalDateTime.now());
        supplyPersistencePort.addSupply(supply);

    }

    @Override
    public LocalDate getNextSupplyDate(Long itemId) {

        return supplyPersistencePort.getNextSupplyDate(itemId);
    }
}
