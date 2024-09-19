package com.Emazon.transactionMicroservice.application.mapper;

import com.Emazon.transactionMicroservice.application.dto.SupplyRequest;
import com.Emazon.transactionMicroservice.domain.model.Supply;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface SupplyRequestMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "userId", ignore = true)
    @Mapping(target = "status", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    Supply toSupply(SupplyRequest supplyRequest);
}
