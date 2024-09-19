package com.Emazon.transactionMicroservice.infrastructure.output.feignClient.adapter;

import com.Emazon.transactionMicroservice.application.dto.request.AddStockRequest;
import com.Emazon.transactionMicroservice.domain.spi.IStockPersistencePort;
import com.Emazon.transactionMicroservice.infrastructure.configuration.feignConfiguration.IStockFeignClient;
import feign.FeignException;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class StockFeignAdapter implements IStockPersistencePort {

    private final IStockFeignClient stockFeignClient;

    @Override
    public boolean existsItem(Long itemId) {

       try {
            return stockFeignClient.existsById(itemId);
        }
        catch(FeignException.NotFound e) {
            return false;
        }

    }

    @Override
    public void addStock(Long itemId, Integer quantity) {
        AddStockRequest addStockRequest = new AddStockRequest(quantity);
        stockFeignClient.addStock(itemId, addStockRequest);
    }
}
