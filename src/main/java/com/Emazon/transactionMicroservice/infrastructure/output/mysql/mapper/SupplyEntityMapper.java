package com.Emazon.transactionMicroservice.infrastructure.output.mysql.mapper;

import com.Emazon.transactionMicroservice.domain.model.Supply;
import com.Emazon.transactionMicroservice.infrastructure.output.mysql.entity.SupplyEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface SupplyEntityMapper {

    SupplyEntity toEntity(Supply supply);

    Supply toSupply(SupplyEntity supplyEntity);
}
