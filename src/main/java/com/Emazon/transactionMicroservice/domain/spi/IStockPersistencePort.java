package com.Emazon.transactionMicroservice.domain.spi;

public interface IStockPersistencePort {
    boolean existsItem(Long itemId);

    void addStock(Long itemId, Integer quantity);
}
