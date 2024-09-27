package com.Emazon.transactionMicroservice.application.dto.request;

import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class SupplyRequest {

    @NotNull
    private Long itemId;

    @NotNull
    @Positive
    private Integer quantity;

    @Temporal(TemporalType.DATE)
    private LocalDate nextSupplyDate;
}
