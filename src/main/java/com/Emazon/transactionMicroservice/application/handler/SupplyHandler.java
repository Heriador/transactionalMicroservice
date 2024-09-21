package com.Emazon.transactionMicroservice.application.handler;

import com.Emazon.transactionMicroservice.application.dto.request.SupplyRequest;
import com.Emazon.transactionMicroservice.application.mapper.SupplyRequestMapper;
import com.Emazon.transactionMicroservice.domain.api.ISupplyServicePort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
@RequiredArgsConstructor
public class SupplyHandler implements ISupplyHandler{

    private final ISupplyServicePort supplyServicePort;
    private final SupplyRequestMapper supplyRequestMapper;

    @Override
    public void addSupply(SupplyRequest supplyRequest) {

        supplyServicePort.addSupply(supplyRequestMapper.toSupply(supplyRequest));
    }

    @Override
    public LocalDate getNextSupplyDate(Long itemId) {
        return supplyServicePort.getNextSupplyDate(itemId);
    }
}
