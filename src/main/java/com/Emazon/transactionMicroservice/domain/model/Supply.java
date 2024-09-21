package com.Emazon.transactionMicroservice.domain.model;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Supply {

    private Long id;
    private Long userId;
    private Long itemId;
    private Integer quantity;
    private LocalDateTime createdAt;
    private LocalDate nextSupplyDate;

    public Supply() {
    }

    public Supply(Long id, Long userId, Long itemId, Integer quantity, LocalDateTime createdAt, LocalDate nextSupplyDate) {
        this.id = id;
        this.userId = userId;
        this.itemId = itemId;
        this.quantity = quantity;
        this.createdAt = createdAt;
        this.nextSupplyDate = nextSupplyDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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


    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public LocalDate getNextSupplyDate() {
        return nextSupplyDate;
    }

    public void setNextSupplyDate(LocalDate nextSupplyDate) {
        this.nextSupplyDate = nextSupplyDate;
    }
}
