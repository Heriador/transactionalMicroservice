package com.Emazon.transactionMicroservice.infrastructure.output.mysql.adapter;

import com.Emazon.transactionMicroservice.domain.model.SaleDetails;
import com.Emazon.transactionMicroservice.domain.spi.ISaleDetailsPersistencePort;
import com.Emazon.transactionMicroservice.infrastructure.output.mysql.mapper.ISaleDetailsEntityMapper;
import com.Emazon.transactionMicroservice.infrastructure.output.mysql.repository.ISaleDetailsRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class SaleDetailsAdapter implements ISaleDetailsPersistencePort {

    private final ISaleDetailsRepository saleDetailsRepository;
    private final ISaleDetailsEntityMapper saleDetailsEntityMapper;

    @Override
    public void createSaleDetails(SaleDetails saleDetail) {
        saleDetailsRepository.save(saleDetailsEntityMapper.toEntity(saleDetail));
    }
}
