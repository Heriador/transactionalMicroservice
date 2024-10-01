package com.Emazon.transactionMicroservice.infrastructure.output.mysql.repository;

import com.Emazon.transactionMicroservice.infrastructure.output.mysql.entity.SaleEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ISaleRepository extends JpaRepository<SaleEntity, Long> {
}
