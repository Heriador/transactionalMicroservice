package com.Emazon.transactionMicroservice.domain.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

public class Sale {
    private Long id;
    private Long userId;
    private LocalDateTime createdAt;
    private List<SaleDetails> items;
    private BigDecimal total;

    public Sale() {
    }

    public Sale(Long id, Long userId, LocalDateTime createdAt, List<SaleDetails> items) {
        this.id = id;
        this.userId = userId;
        this.createdAt = createdAt;
        this.items = items;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public List<SaleDetails> getItems() {
        return items;
    }

    public void setItems(List<SaleDetails> items) {
        this.items = items;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }
}
