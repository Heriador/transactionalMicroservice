package com.Emazon.transactionMicroservice.infrastructure.output.mysql.repository;

import com.Emazon.transactionMicroservice.infrastructure.output.mysql.entity.SupplyEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;

public interface ISupplyRepository extends JpaRepository<SupplyEntity, Long> {

    @Query("SELECT s.nextSupplyDate FROM SupplyEntity s WHERE s.itemId = :itemId ORDER BY s.nextSupplyDate DESC LIMIT 1")
    LocalDate getNextSupplyDateByItemId(@Param("itemId") Long itemId);
}
