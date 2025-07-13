package com.Emazon.transactionMicroservice.infrastructure.output.mysql.adapter;

import com.Emazon.transactionMicroservice.domain.model.Sale;
import com.Emazon.transactionMicroservice.domain.spi.ISalePersistencePort;
import com.Emazon.transactionMicroservice.infrastructure.output.mysql.entity.SaleDetailsEntity;
import com.Emazon.transactionMicroservice.infrastructure.output.mysql.entity.SaleEntity;
import com.Emazon.transactionMicroservice.infrastructure.output.mysql.mapper.ISaleDetailsEntityMapper;
import com.Emazon.transactionMicroservice.infrastructure.output.mysql.mapper.ISaleEntityMapper;
import com.Emazon.transactionMicroservice.infrastructure.output.mysql.repository.ISaleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Transactional
public class SaleAdapter implements ISalePersistencePort {

    private final ISaleRepository saleRepository;
    private final ISaleEntityMapper saleEntityMapper;
    private final ISaleDetailsEntityMapper saleDetailsEntityMapper;

    @Override
    public void createSale(Sale sale) {

        SaleEntity saleEntity = saleEntityMapper.toEntity(sale);
        List<SaleDetailsEntity> saleDetailsEntities = sale.getItems().stream().map( item -> {
            SaleDetailsEntity saleDetailsEntity = saleDetailsEntityMapper.toEntity(item);
            saleDetailsEntity.setSale(saleEntity);
            return saleDetailsEntity;
        }).toList();

        saleEntity.setItems(saleDetailsEntities);

        saleRepository.save(saleEntity);

    }
}
