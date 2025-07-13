package com.Emazon.transactionMicroservice.infrastructure.output.feignClient.adapter;

import com.Emazon.transactionMicroservice.application.dto.request.AddStockRequest;
import com.Emazon.transactionMicroservice.domain.spi.IStockPersistencePort;
import com.Emazon.transactionMicroservice.infrastructure.configuration.feignConfiguration.IStockFeignClient;
import feign.FeignException;
import lombok.RequiredArgsConstructor;

import java.math.BigDecimal;

@RequiredArgsConstructor
public class StockFeignAdapter implements IStockPersistencePort {

    private final IStockFeignClient stockFeignClient;

    @Override
    public boolean existsItem(Long itemId) {

       try {
            return stockFeignClient.existsById(itemId);
        }
        catch(FeignException.NotFound e){
            return false;
        }

    }

    @Override
    public Boolean addStock(Long itemId, Integer quantity) {
        try{
            AddStockRequest addStockRequest = new AddStockRequest(quantity);
            stockFeignClient.addStock(itemId, addStockRequest);

            return true;
        }
        catch (FeignException.BadRequest e){
             return false;
        }
    }

    @Override
    public Boolean removeStock(Long itemId, Integer quantity) {
        try {
            AddStockRequest addStockRequest = new AddStockRequest(quantity);
            stockFeignClient.removeStock(itemId, addStockRequest);

            return true;
        }
        catch(FeignException e){
            return false;
        }
    }

    @Override
    public Boolean hasStock(Long itemId, Integer quantity) {
        try {
            return stockFeignClient.hasStock(itemId, quantity);
        }
        catch(FeignException.NotFound e){
            return false;
        }
    }

    @Override
    public BigDecimal getPriceById(Long itemId) {
        try {
            return stockFeignClient.getPriceById(itemId);
        }
        catch(FeignException e){
            return null;
        }
    }
}
