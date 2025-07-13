package com.Emazon.transactionMicroservice.domain.usecases;

import com.Emazon.transactionMicroservice.domain.api.ISaleDetailsServicePort;
import com.Emazon.transactionMicroservice.domain.model.CartDetails;
import com.Emazon.transactionMicroservice.domain.model.Sale;
import com.Emazon.transactionMicroservice.domain.model.SaleDetails;
import com.Emazon.transactionMicroservice.domain.spi.ISaleDetailsPersistencePort;
import com.Emazon.transactionMicroservice.domain.spi.IStockPersistencePort;

import java.math.BigDecimal;


public class SaleDetailsUseCase implements ISaleDetailsServicePort {

    private final IStockPersistencePort stockPersistencePort;
    private final ISaleDetailsPersistencePort saleDetailsPersistencePort;

    public SaleDetailsUseCase(IStockPersistencePort stockPersistencePort, ISaleDetailsPersistencePort saleDetailsPersistencePort) {
        this.stockPersistencePort = stockPersistencePort;
        this.saleDetailsPersistencePort = saleDetailsPersistencePort;
    }


    @Override
    public void saveSaleDetails(CartDetails cartDetails, Sale sale) {
        SaleDetails saleDetail = new SaleDetails();
        saleDetail.setSale(sale);
        saleDetail.setItemId(cartDetails.getItemId());
        saleDetail.setQuantity(cartDetails.getQuantity());
        saleDetail.setPrice(stockPersistencePort.getPriceById(cartDetails.getItemId()));

        saleDetailsPersistencePort.createSaleDetails(saleDetail);
    }
}
