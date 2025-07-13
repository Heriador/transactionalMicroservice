package com.Emazon.transactionMicroservice.application.dto.request;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class SaleDetailsRequest {
    private Long id;
    private Long itemId;
    private Integer quantity;
    private BigDecimal price;
    private BigDecimal subTotal;
}
