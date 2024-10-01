package com.Emazon.transactionMicroservice.domain.model;

import java.math.BigDecimal;

public class SaleDetails {

    private Long id;
    private Long saleId;
    private Long itemId;
    private Integer quantity;
    private BigDecimal price;
    private BigDecimal subTotal;

    public SaleDetails() {
    }

    public SaleDetails(Long id, Long saleId, Long itemId, Integer quantity, BigDecimal price, BigDecimal subTotal) {
        this.id = id;
        this.saleId = saleId;
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

    public Long getSaleId() {
        return saleId;
    }

    public void setSaleId(Long saleId) {
        this.saleId = saleId;
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

    public void setSubTotal(BigDecimal subTotal) {
        this.subTotal = subTotal;
    }
}
