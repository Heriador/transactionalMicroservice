package com.Emazon.transactionMicroservice.infrastructure.configuration.feignConfiguration;

import com.Emazon.transactionMicroservice.application.dto.request.AddStockRequest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.Emazon.transactionMicroservice.infrastructure.configuration.util.FeignConstant;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = FeignConstant.STOCK_MICROSERVICE, url = FeignConstant.STOCK_MICROSERVICE_URL, configuration = FeignConfiguration.class)
public interface IStockFeignClient {

    @GetMapping("/item/{itemId}")
    boolean existsById(@PathVariable Long itemId);

    @PatchMapping(value = "/item/stock/{itemId}", consumes = MediaType.APPLICATION_JSON_VALUE)
    void addStock(@PathVariable Long itemId, @RequestBody AddStockRequest addStockRequest);
}
