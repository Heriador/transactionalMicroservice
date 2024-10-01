package com.Emazon.transactionMicroservice.domain.spi;

import com.Emazon.transactionMicroservice.domain.model.CartDetails;

import java.util.List;

public interface IShoppingCartPersistencePort {
    List<CartDetails> getCartItems(Long userId);
}
