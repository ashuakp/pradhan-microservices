package com.pradhan.inventory.repository;

import com.pradhan.inventory.entity.InventoryBatch;
import jakarta.persistence.LockModeType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface InventoryBatchRepository extends JpaRepository<InventoryBatch, Long> {

    List<InventoryBatch> findByProductIdOrderByExpiryDateAscIdAsc(Long productId);

    @Lock(LockModeType.PESSIMISTIC_WRITE)
    @Query("""
        select b from InventoryBatch b
        where b.productId = :productId
        order by b.expiryDate asc, b.id asc
        """)
    List<InventoryBatch> findForReservation(@Param("productId") Long productId);
}
