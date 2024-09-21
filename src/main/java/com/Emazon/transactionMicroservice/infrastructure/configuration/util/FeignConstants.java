package com.Emazon.transactionMicroservice.infrastructure.configuration.util;

public class FeignConstants {

    public static final String STOCK_MICROSERVICE = "stockMicroservice";
    public static final String STOCK_MICROSERVICE_URL = "${stock_service.url}";

    public static final String EXISTS_ITEM_BY_ID_ROUTE = "/item/{itemId}";
    public static final String ADD_STOCK_ROUTE = "/item/stock/{itemId}";

    public static final String TOKEN_PREFIX = "Bearer ";
    public static final String AUTHORIZATION_HEADER = "Authorization";

    private FeignConstants() {
    }
}
