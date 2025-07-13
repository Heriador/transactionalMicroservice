package com.Emazon.transactionMicroservice.domain.usecases;

import com.Emazon.transactionMicroservice.domain.api.ISaleDetailsServicePort;
import com.Emazon.transactionMicroservice.domain.api.ISaleServicePort;
import com.Emazon.transactionMicroservice.domain.exception.InsufficientStockException;
import com.Emazon.transactionMicroservice.domain.exception.SaleTransactionException;
import com.Emazon.transactionMicroservice.domain.model.CartDetails;
import com.Emazon.transactionMicroservice.domain.model.Sale;
import com.Emazon.transactionMicroservice.domain.model.SaleDetails;
import com.Emazon.transactionMicroservice.domain.spi.IAuthenticationPersistencePort;
import com.Emazon.transactionMicroservice.domain.spi.IShoppingCartPersistencePort;
import com.Emazon.transactionMicroservice.domain.spi.ISalePersistencePort;
import com.Emazon.transactionMicroservice.domain.spi.IStockPersistencePort;

import java.time.LocalDateTime;
import java.util.List;

public class SaleUseCases implements ISaleServicePort {

//    private final ISaleDetailsServicePort saleDetailsServicePort;
    private final ISalePersistencePort salePersistencePort;
    private final IAuthenticationPersistencePort authenticationPersistencePort;
    private final IStockPersistencePort stockPersistencePort;
    private final IShoppingCartPersistencePort cartPersistencePort;


    public SaleUseCases(ISalePersistencePort salePersistencePort,
                        IAuthenticationPersistencePort authenticationPersistencePort,
                        IStockPersistencePort stockPersistencePort,
                        IShoppingCartPersistencePort cartPersistencePort) {
        this.salePersistencePort = salePersistencePort;
        this.authenticationPersistencePort = authenticationPersistencePort;
        this.stockPersistencePort = stockPersistencePort;
        this.cartPersistencePort = cartPersistencePort;
    }

    @Override
    public void createSale() {
        Long userId = authenticationPersistencePort.getAuthenticatedUserId();

        List<CartDetails> items = cartPersistencePort.getCartItems(userId);

        try{

            items.forEach(this::validateStock);

            Sale sale = new Sale();
            sale.setUserId(userId);
            List<SaleDetails> saleDetails = items.stream().map(item -> {
                SaleDetails saleDetail = new SaleDetails();
                saleDetail.setSale(sale);
                saleDetail.setItemId(item.getItemId());
                saleDetail.setQuantity(item.getQuantity());
                saleDetail.setPrice(stockPersistencePort.getPriceById(item.getItemId()));
                saleDetail.calculateSubTotal();
                return saleDetail;

            }).toList();
            sale.setItems(saleDetails);
            sale.calculateTotal();
            sale.setCreatedAt(LocalDateTime.now());
            salePersistencePort.createSale(sale);

            items.forEach(this::removeStock);

        } catch (InsufficientStockException e){
            throw e;
        }
        catch (Exception e){
            throw new SaleTransactionException("Sale transaction failed");
        }

    }



    private void validateStock(CartDetails item){
        if(Boolean.FALSE.equals(stockPersistencePort.hasStock(item.getItemId(), item.getQuantity()))){
            throw new InsufficientStockException("Insufficient stock for item: " + item.getItemId());
        }
    }

    private void removeStock(CartDetails item){
        if(Boolean.FALSE.equals(stockPersistencePort.removeStock(item.getItemId(), item.getQuantity()))){
            throw new SaleTransactionException("Sale transaction failed");
        }
    }
}
