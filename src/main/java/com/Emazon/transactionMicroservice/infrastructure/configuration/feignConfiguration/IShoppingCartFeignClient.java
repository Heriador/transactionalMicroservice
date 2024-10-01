package com.Emazon.transactionMicroservice.infrastructure.configuration.feignConfiguration;

import com.Emazon.transactionMicroservice.domain.model.CartDetails;
import com.Emazon.transactionMicroservice.infrastructure.configuration.util.FeignConstants;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient(name = FeignConstants.SHOPPING_CART_MICROSERVICE,
        url = FeignConstants.SHOPPING_CART_MICROSERVICE_URL,
        configuration = FeignConfiguration.class)
public interface IShoppingCartFeignClient {

    @GetMapping(FeignConstants.GET_CART_ROUTE)
    List<CartDetails> getCartItems(Long userId);
}
