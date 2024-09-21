package com.Emazon.transactionMicroservice.domain.spi;

public interface IStockPersistencePort {
    boolean existsItem(Long itemId);

    Boolean addStock(Long itemId, Integer quantity);
}
