package com.Emazon.transactionMicroservice.infrastructure.output.feignClient.adapter;

import com.Emazon.transactionMicroservice.domain.model.CartDetails;
import com.Emazon.transactionMicroservice.domain.spi.IShoppingCartPersistencePort;
import com.Emazon.transactionMicroservice.infrastructure.configuration.feignConfiguration.IShoppingCartFeignClient;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class ShoppingCartFeignAdapter implements IShoppingCartPersistencePort {

    private final IShoppingCartFeignClient shoppingCartFeignClient;

    @Override
    public List<CartDetails> getCartItems(Long userId) {
        return shoppingCartFeignClient.getCartItems(userId);
    }
}
