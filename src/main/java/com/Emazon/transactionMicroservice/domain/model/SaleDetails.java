package com.Emazon.transactionMicroservice.domain.model;

import java.math.BigDecimal;

public class SaleDetails {

    private Long id;
    private Sale sale;
    private Long itemId;
    private Integer quantity;
    private BigDecimal price;
    private BigDecimal subTotal;

    public SaleDetails() {
    }

    public SaleDetails(Long id, Sale sale, Long itemId, Integer quantity, BigDecimal price, BigDecimal subTotal) {
        this.id = id;
        this.sale = sale;
        this.itemId = itemId;
        this.quantity = quantity;
        this.price = price;
        this.subTotal = subTotal;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Sale getSale() {
        return sale;
    }

    public void setSale(Sale sale) {
        this.sale = sale;
    }

    public Long getItemId() {
        return itemId;
    }

    public void setItemId(Long itemId) {
        this.itemId = itemId;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public BigDecimal getSubTotal() {
        return subTotal;
    }

    public void calculateSubTotal() {
        this.subTotal = this.price.multiply(BigDecimal.valueOf(this.quantity));
    }
}
