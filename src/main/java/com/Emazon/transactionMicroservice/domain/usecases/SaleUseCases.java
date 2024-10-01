package com.Emazon.transactionMicroservice.domain.usecases;

import com.Emazon.transactionMicroservice.domain.api.ISaleServicePort;
import com.Emazon.transactionMicroservice.domain.model.CartDetails;
import com.Emazon.transactionMicroservice.domain.spi.IAuthenticationPersistencePort;
import com.Emazon.transactionMicroservice.domain.spi.IShoppingCartPersistencePort;
import com.Emazon.transactionMicroservice.domain.spi.ISalePersistencePort;
import com.Emazon.transactionMicroservice.domain.spi.IStockPersistencePort;

import java.util.List;

public class SaleUseCases implements ISaleServicePort {

    private final ISalePersistencePort salePersistencePort;
    private final IAuthenticationPersistencePort authenticationPersistencePort;
    private final IStockPersistencePort stockPersistencePort;
    private final IShoppingCartPersistencePort cartPersistencePort;

    public SaleUseCases(ISalePersistencePort salePersistencePort,
                        IAuthenticationPersistencePort authenticationPersistencePort,
                        IStockPersistencePort stockPersistencePort,
                        IShoppingCartPersistencePort cartPersistencePort) {
        this.salePersistencePort = salePersistencePort;
        this.authenticationPersistencePort = authenticationPersistencePort;
        this.stockPersistencePort = stockPersistencePort;
        this.cartPersistencePort = cartPersistencePort;
    }

    @Override
    public void createSale() {
        Long userId = authenticationPersistencePort.getAuthenticatedUserId();

        List<CartDetails> items = cartPersistencePort.getCartItems(userId);
    }
}
