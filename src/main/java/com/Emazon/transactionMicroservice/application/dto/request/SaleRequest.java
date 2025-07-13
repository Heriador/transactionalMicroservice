package com.Emazon.transactionMicroservice.application.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class SaleRequest {
    private Long id;
    private Long userId;
    private LocalDateTime createdAt;
    private List<SaleDetailsRequest> items;
    private BigDecimal total;
}
