package com.Emazon.transactionMicroservice.domain.api;

import com.Emazon.transactionMicroservice.domain.model.CartDetails;
import com.Emazon.transactionMicroservice.domain.model.Sale;

public interface ISaleDetailsServicePort {
    void saveSaleDetails(CartDetails cartDetails, Sale sale);
}
