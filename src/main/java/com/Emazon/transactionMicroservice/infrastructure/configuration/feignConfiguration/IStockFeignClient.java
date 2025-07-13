package com.Emazon.transactionMicroservice.infrastructure.configuration.feignConfiguration;

import com.Emazon.transactionMicroservice.application.dto.request.AddStockRequest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import com.Emazon.transactionMicroservice.infrastructure.configuration.util.FeignConstants;

import java.math.BigDecimal;

@FeignClient(name = FeignConstants.STOCK_MICROSERVICE, url = FeignConstants.STOCK_MICROSERVICE_URL, configuration = FeignConfiguration.class)
public interface IStockFeignClient {

    @GetMapping(FeignConstants.EXISTS_ITEM_BY_ID_ROUTE)
    boolean existsById(@PathVariable Long itemId);

    @PatchMapping(value = FeignConstants.ADD_STOCK_ROUTE, consumes = MediaType.APPLICATION_JSON_VALUE)
    void addStock(@PathVariable Long itemId, @RequestBody AddStockRequest addStockRequest);

    @GetMapping(FeignConstants.HAS_STOCK_ROUTE)
    Boolean hasStock(@PathVariable Long itemId, @PathVariable Integer quantity);

    @GetMapping(FeignConstants.GET_PRICE_BY_ID_ROUTE)
    BigDecimal getPriceById(@RequestParam Long itemId);

    @PatchMapping(value = FeignConstants.REMOVE_STOCK_ROUTE, consumes = MediaType.APPLICATION_JSON_VALUE)
    void removeStock(@PathVariable Long itemId, @RequestBody AddStockRequest addStockRequest);
}
