package com.Emazon.transactionMicroservice.application.handler;

import com.Emazon.transactionMicroservice.application.dto.request.SupplyRequest;
import com.Emazon.transactionMicroservice.application.mapper.SupplyRequestMapper;
import com.Emazon.transactionMicroservice.domain.api.ISupplyServicePort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SupplyHandler implements ISupplyHandler{

    private final ISupplyServicePort supplyServicePort;
    private final SupplyRequestMapper supplyRequestMapper;

    @Override
    public void addSupply(SupplyRequest supplyRequest) {

        supplyServicePort.addSupply(supplyRequestMapper.toSupply(supplyRequest));
    }
}
