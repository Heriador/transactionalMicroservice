package com.Emazon.transactionMicroservice.application.handler;

import com.Emazon.transactionMicroservice.Factory.SupplyFactory;
import com.Emazon.transactionMicroservice.application.dto.request.SupplyRequest;
import com.Emazon.transactionMicroservice.application.mapper.SupplyRequestMapper;
import com.Emazon.transactionMicroservice.domain.api.ISupplyServicePort;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class SupplyHandlerTest {

    @Mock
    private ISupplyServicePort supplyServicePort;

    @Mock
    private SupplyRequestMapper supplyRequestMapper;

    @InjectMocks
    private SupplyHandler supplyHandler;


    @Test
    @DisplayName("Add supply should pass")
    void addSupplyShouldPass() {
        SupplyRequest supplyRequest = SupplyFactory.getSupplyRequest();

        when(supplyRequestMapper.toSupply(supplyRequest)).thenReturn(SupplyFactory.getSupply());
        doNothing().when(supplyServicePort).addSupply(SupplyFactory.getSupply());

        supplyHandler.addSupply(supplyRequest);

        verify(supplyRequestMapper, times(1)).toSupply(supplyRequest);
        verify(supplyServicePort, times(1)).addSupply(SupplyFactory.getSupply());

    }

    @Test
    @DisplayName("Get next supply date should pass")
    void getNextSupplyDateShouldPass() {
        Long itemId = 1L;

        when(supplyServicePort.getNextSupplyDate(itemId)).thenReturn(SupplyFactory.getSupply().getNextSupplyDate());

        assertEquals(SupplyFactory.getSupply().getNextSupplyDate(), supplyHandler.getNextSupplyDate(itemId));

        verify(supplyServicePort, times(1)).getNextSupplyDate(itemId);

    }

}