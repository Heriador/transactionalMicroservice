package com.Emazon.transactionMicroservice.domain.spi;

import java.math.BigDecimal;

public interface IStockPersistencePort {
    boolean existsItem(Long itemId);

    Boolean addStock(Long itemId, Integer quantity);

    Boolean removeStock(Long itemId, Integer quantity);

    Boolean hasStock(Long itemId, Integer quantity);

    BigDecimal getPriceById(Long itemId);
}
