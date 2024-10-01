package com.Emazon.transactionMicroservice.infrastructure.output.mysql.entity;

import com.Emazon.transactionMicroservice.domain.model.Sale;
import com.Emazon.transactionMicroservice.infrastructure.output.mysql.util.EntityConstants;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = EntityConstants.SALE_DETAILS_TABLE)
public class SaleDetailsEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = EntityConstants.SALE_JOIN_COLUMN, nullable = false)
    private SaleEntity sale;

    @Column(nullable = false)
    private Long itemId;

    @Column(nullable = false)
    private Integer quantity;

    @Column(nullable = false)
    private BigDecimal price;

    @Column(nullable = false)
    private BigDecimal subtotal;

    public BigDecimal calculateSubtotal() {
        setSubtotal(price.multiply(BigDecimal.valueOf(quantity)));

        return getSubtotal();
    }

}
