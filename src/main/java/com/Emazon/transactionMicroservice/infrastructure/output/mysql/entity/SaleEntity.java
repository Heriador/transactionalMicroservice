package com.Emazon.transactionMicroservice.infrastructure.output.mysql.entity;

import com.Emazon.transactionMicroservice.domain.model.SaleDetails;
import com.Emazon.transactionMicroservice.infrastructure.output.mysql.util.EntityConstants;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = EntityConstants.SALE_TABLE)
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class SaleEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Long userId;

    @Column(nullable = false)
    private Long cartId;

    @Column(nullable = false)
    private Long reportId;

    @Column(nullable = false)
    private LocalDateTime createdAt;

    @OneToMany(mappedBy = EntityConstants.SALE_MAPPED_BY, cascade = CascadeType.ALL)
    private List<SaleDetailsEntity> items;

    @Column(nullable = false)
    private BigDecimal total;

    public BigDecimal calculateTotal() {
        BigDecimal tempTotal = items.stream().map(SaleDetailsEntity::calculateSubtotal).reduce(BigDecimal.ZERO, BigDecimal::add);
        setTotal(tempTotal);
        return tempTotal;
    }
}
