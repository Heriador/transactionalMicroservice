package com.Emazon.transactionMicroservice.infrastructure.output.mysql.mapper;

import com.Emazon.transactionMicroservice.domain.model.SaleDetails;
import com.Emazon.transactionMicroservice.infrastructure.output.mysql.entity.SaleDetailsEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.math.BigDecimal;
import java.util.List;

@Mapper(componentModel = "spring", uses = {ISaleEntityMapper.class})
public interface ISaleDetailsEntityMapper {


    SaleDetailsEntity toEntity(SaleDetails saleDetails);

    SaleDetails toSaleDetails(SaleDetailsEntity saleDetailsEntity);

    List<SaleDetailsEntity> toEntityList(List<SaleDetails> items);

}
