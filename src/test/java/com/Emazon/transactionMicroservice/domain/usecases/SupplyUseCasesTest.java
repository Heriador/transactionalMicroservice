package com.Emazon.transactionMicroservice.domain.usecases;

import com.Emazon.transactionMicroservice.domain.exception.ItemNotFoundException;
import com.Emazon.transactionMicroservice.domain.exception.SupplyTransactionException;
import com.Emazon.transactionMicroservice.domain.model.Supply;
import com.Emazon.transactionMicroservice.domain.spi.IAuthenticationPersistencePort;
import com.Emazon.transactionMicroservice.domain.spi.IStockPersistencePort;
import com.Emazon.transactionMicroservice.domain.spi.ISupplyPersistencePort;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;


@ExtendWith(MockitoExtension.class)
class SupplyUseCasesTest {

    @Mock
    private ISupplyPersistencePort supplyPersistencePort;

    @Mock
    private IAuthenticationPersistencePort authenticationPersistencePort;

    @Mock
    private IStockPersistencePort stockPersistencePort;

    @InjectMocks
    private SupplyUseCases supplyUseCases;


    @Test
    @DisplayName("Add supply should pass")
    void addSupplyShouldPass() {
        Supply supply = new Supply();
        supply.setItemId(1L);
        supply.setQuantity(1);
        supply.setNextSupplyDate(LocalDate.now());

        when(authenticationPersistencePort.getAuthenticatedUserId()).thenReturn(1L);
        when(stockPersistencePort.existsItem(1L)).thenReturn(true);
        when(stockPersistencePort.addStock(1L, 1)).thenReturn(true);
        doNothing().when(supplyPersistencePort).addSupply(any(Supply.class));

        supplyUseCases.addSupply(supply);

        verify(authenticationPersistencePort, times(1)).getAuthenticatedUserId();
        verify(stockPersistencePort, times(1)).existsItem(1L);
        verify(stockPersistencePort, times(1)).addStock(1L, 1);
        verify(supplyPersistencePort, times(1)).addSupply(any(Supply.class));
    }

    @Test
    @DisplayName("Add supply should fail and throw ItemNotFoundException")
    void addSupplyShouldFailAndThrowItemNotFoundException() {
        Supply supply = new Supply();
        supply.setItemId(1L);
        supply.setQuantity(1);
        supply.setNextSupplyDate(LocalDate.now());

        when(authenticationPersistencePort.getAuthenticatedUserId()).thenReturn(1L);
        when(stockPersistencePort.existsItem(1L)).thenReturn(false);

        assertThrows(ItemNotFoundException.class, () -> supplyUseCases.addSupply(supply));

        verify(authenticationPersistencePort, times(1)).getAuthenticatedUserId();
        verify(stockPersistencePort, times(1)).existsItem(1L);
        verify(stockPersistencePort, times(0)).addStock(1L, 1);
        verify(supplyPersistencePort, times(0)).addSupply(any(Supply.class));
    }

    @Test
    @DisplayName("Add supply should fail with Next Supply Date Null and throw SupplyTransactionException")
    void addSupplyShouldFailWithNextSupplyDateNullAndThrowSupplyTransactionException() {
        Supply supply = new Supply();
        supply.setItemId(1L);
        supply.setQuantity(1);


        when(authenticationPersistencePort.getAuthenticatedUserId()).thenReturn(1L);
        when(stockPersistencePort.existsItem(1L)).thenReturn(true);

        assertThrows(SupplyTransactionException.class, () -> supplyUseCases.addSupply(supply));

        verify(authenticationPersistencePort, times(1)).getAuthenticatedUserId();
        verify(stockPersistencePort, times(1)).existsItem(1L);
        verify(stockPersistencePort, times(0)).addStock(1L, 1);
        verify(supplyPersistencePort, times(0)).addSupply(any(Supply.class));
    }

    @Test
    @DisplayName("Add supply should fail and throw SupplyTransactionException")
    void addSupplyShouldFailAndThrowSupplyTransactionException() {
        Supply supply = new Supply();
        supply.setItemId(1L);
        supply.setQuantity(1);
        supply.setNextSupplyDate(LocalDate.now());

        when(authenticationPersistencePort.getAuthenticatedUserId()).thenReturn(1L);
        when(stockPersistencePort.existsItem(1L)).thenReturn(true);
        when(stockPersistencePort.addStock(1L, 1)).thenReturn(false);

        assertThrows(SupplyTransactionException.class, () -> supplyUseCases.addSupply(supply));

        verify(authenticationPersistencePort, times(1)).getAuthenticatedUserId();
        verify(stockPersistencePort, times(1)).existsItem(1L);
        verify(stockPersistencePort, times(1)).addStock(1L, 1);
        verify(supplyPersistencePort, times(0)).addSupply(any(Supply.class));
    }

    @Test
    @DisplayName("Get next supply date should pass")
    void getNextSupplyDateShouldPass() {
        LocalDate expectedDate = LocalDate.now();

        when(supplyPersistencePort.getNextSupplyDate(1L)).thenReturn(expectedDate);

        LocalDate nextSupplyDate = supplyUseCases.getNextSupplyDate(1L);

        assertEquals(expectedDate, nextSupplyDate);
        verify(supplyPersistencePort, times(1)).getNextSupplyDate(1L);
    }

}