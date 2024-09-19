package com.Emazon.transactionMicroservice.infrastructure.configuration.util;

public class FeignConstant {

    public static final String STOCK_MICROSERVICE = "stockMicroservice";
    public static final String STOCK_MICROSERVICE_URL = "${stock_service.url}";

    private FeignConstant() {
    }
}
