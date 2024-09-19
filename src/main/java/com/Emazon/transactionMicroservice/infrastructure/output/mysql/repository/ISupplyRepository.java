package com.Emazon.transactionMicroservice.infrastructure.output.mysql.repository;

import com.Emazon.transactionMicroservice.infrastructure.output.mysql.entity.SupplyEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ISupplyRepository extends JpaRepository<SupplyEntity, Long> {

}
