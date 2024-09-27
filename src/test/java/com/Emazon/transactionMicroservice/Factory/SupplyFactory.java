package com.Emazon.transactionMicroservice.Factory;

import com.Emazon.transactionMicroservice.application.dto.request.SupplyRequest;
import com.Emazon.transactionMicroservice.domain.model.Supply;
import com.Emazon.transactionMicroservice.infrastructure.output.mysql.entity.SupplyEntity;

import java.time.LocalDate;


public class SupplyFactory {

    private static final Supply supply;
    private static final SupplyRequest supplyRequest;
    private static final SupplyEntity supplyEntity;

    static {
        supply = new Supply();
        supply.setId(1L);
        supply.setUserId(1L);
        supply.setItemId(1L);
        supply.setQuantity(1);
        supply.setCreatedAt(null);
        supply.setNextSupplyDate(LocalDate.now());

        supplyEntity = new SupplyEntity();
        supplyEntity.setId(supply.getId());
        supplyEntity.setUserId(supply.getUserId());
        supplyEntity.setItemId(supply.getItemId());
        supplyEntity.setQuantity(supply.getQuantity());
        supplyEntity.setCreatedAt(supply.getCreatedAt());
        supplyEntity.setNextSupplyDate(supply.getNextSupplyDate());

        supplyRequest = new SupplyRequest(supply.getId(),supply.getQuantity(),supply.getNextSupplyDate());

    }

    public static Supply getSupply() {
        return supply;
    }

    public static SupplyEntity getSupplyEntity() {
        return supplyEntity;
    }

    public static SupplyRequest getSupplyRequest() {
        return supplyRequest;
    }



}
