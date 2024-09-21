package com.Emazon.transactionMicroservice.infrastructure.configuration.feignConfiguration;

import com.Emazon.transactionMicroservice.application.dto.request.AddStockRequest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.Emazon.transactionMicroservice.infrastructure.configuration.util.FeignConstants;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = FeignConstants.STOCK_MICROSERVICE, url = FeignConstants.STOCK_MICROSERVICE_URL, configuration = FeignConfiguration.class)
public interface IStockFeignClient {

    @GetMapping(FeignConstants.EXISTS_ITEM_BY_ID_ROUTE)
    boolean existsById(@PathVariable Long itemId);

    @PatchMapping(value = FeignConstants.ADD_STOCK_ROUTE, consumes = MediaType.APPLICATION_JSON_VALUE)
    void addStock(@PathVariable Long itemId, @RequestBody AddStockRequest addStockRequest);
}
