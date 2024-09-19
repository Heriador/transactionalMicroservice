package com.Emazon.transactionMicroservice.infrastructure.output.mysql.adapter;

import com.Emazon.transactionMicroservice.domain.model.Supply;
import com.Emazon.transactionMicroservice.domain.spi.ISupplyPersistencePort;
import com.Emazon.transactionMicroservice.infrastructure.output.mysql.mapper.SupplyEntityMapper;
import com.Emazon.transactionMicroservice.infrastructure.output.mysql.repository.ISupplyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Transactional
public class SupplyAdapter implements ISupplyPersistencePort {

    private final ISupplyRepository supplyRepository;
    private final SupplyEntityMapper supplyEntityMapper;

    @Override
    public void addSupply(Supply supply) {
        supplyRepository.save(supplyEntityMapper.toEntity(supply));
    }
}
