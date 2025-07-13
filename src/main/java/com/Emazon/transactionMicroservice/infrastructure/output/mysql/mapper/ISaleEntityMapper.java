package com.Emazon.transactionMicroservice.infrastructure.output.mysql.mapper;

import com.Emazon.transactionMicroservice.domain.model.Sale;
import com.Emazon.transactionMicroservice.infrastructure.output.mysql.entity.SaleEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;


@Mapper(componentModel = "spring")
public interface ISaleEntityMapper {

    @Mapping(target = "items", ignore = true)
    SaleEntity toEntity(Sale sale);

    Sale toSale(SaleEntity saleEntity);

}
