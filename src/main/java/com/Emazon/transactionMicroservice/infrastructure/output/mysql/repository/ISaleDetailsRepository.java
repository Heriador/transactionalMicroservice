package com.Emazon.transactionMicroservice.infrastructure.output.mysql.repository;

import com.Emazon.transactionMicroservice.infrastructure.output.mysql.entity.SaleDetailsEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ISaleDetailsRepository extends JpaRepository<SaleDetailsEntity, Long> {
}
