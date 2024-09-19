package com.Emazon.transactionMicroservice.infrastructure.input.rest;

import com.Emazon.transactionMicroservice.application.dto.request.SupplyRequest;
import com.Emazon.transactionMicroservice.application.handler.ISupplyHandler;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import static com.Emazon.transactionMicroservice.infrastructure.input.util.RestControllerConstants.*;

@RestController
@RequestMapping(SUPPLY_ROUTE)
@RequiredArgsConstructor
public class SupplyRestController {

    private final ISupplyHandler supplyHandler;

    @PreAuthorize(HAS_ROLE_WAREHOUSE_ASSISTANT)
    @PostMapping(ADD_SUPPLY_ROUTE)
    public ResponseEntity<Void> addSupply(@RequestBody @Valid SupplyRequest supplyRequest) {

        supplyHandler.addSupply(supplyRequest);

        return ResponseEntity.ok().build();
    }
}
