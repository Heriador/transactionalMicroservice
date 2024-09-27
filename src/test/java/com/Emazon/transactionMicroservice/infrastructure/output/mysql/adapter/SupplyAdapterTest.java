package com.Emazon.transactionMicroservice.infrastructure.output.mysql.adapter;

import com.Emazon.transactionMicroservice.Factory.SupplyFactory;
import com.Emazon.transactionMicroservice.domain.model.Supply;
import com.Emazon.transactionMicroservice.infrastructure.output.mysql.entity.SupplyEntity;
import com.Emazon.transactionMicroservice.infrastructure.output.mysql.mapper.SupplyEntityMapper;
import com.Emazon.transactionMicroservice.infrastructure.output.mysql.repository.ISupplyRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class SupplyAdapterTest {

    @Mock
    private ISupplyRepository supplyRepository;

    @Mock
    private SupplyEntityMapper supplyEntityMapper;

    @InjectMocks
    private SupplyAdapter supplyAdapter;


    @Test
    void addSupplyShouldPass() {

        Supply supply = SupplyFactory.getSupply();

        when(supplyEntityMapper.toEntity(supply)).thenReturn(SupplyFactory.getSupplyEntity());
        when(supplyRepository.save(SupplyFactory.getSupplyEntity())).thenReturn(any(SupplyEntity.class));

        supplyAdapter.addSupply(supply);

        verify(supplyEntityMapper, times(1)).toEntity(supply);
        verify(supplyRepository, times(1)).save(SupplyFactory.getSupplyEntity());

    }

    @Test
    void getNextSupplyDateShouldPass() {

        Long itemId = 1L;

        when(supplyRepository.getNextSupplyDateByItemId(itemId)).thenReturn(SupplyFactory.getSupply().getNextSupplyDate());

        assertEquals(SupplyFactory.getSupply().getNextSupplyDate(), supplyAdapter.getNextSupplyDate(itemId));

        verify(supplyRepository, times(1)).getNextSupplyDateByItemId(itemId);

    }


}