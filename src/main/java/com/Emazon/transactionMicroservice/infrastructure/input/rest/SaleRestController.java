package com.Emazon.transactionMicroservice.infrastructure.input.rest;

import com.Emazon.transactionMicroservice.application.handler.ISaleHandler;
import com.Emazon.transactionMicroservice.infrastructure.input.util.RestControllerConstants;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/sale")
@RequiredArgsConstructor
public class SaleRestController {

    private final ISaleHandler saleHandler;

    @PreAuthorize(RestControllerConstants.HAS_ROLE_CLIENT)
    @GetMapping("/create")
    public void createSale() {
        saleHandler.createSale();
    }

}
