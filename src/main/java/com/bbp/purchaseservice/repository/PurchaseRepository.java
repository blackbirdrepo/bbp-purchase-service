package com.bbp.purchaseservice.repository;

import com.bbp.purchaseservice.domain.Purchase;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PurchaseRepository extends JpaRepository<Purchase, Long> {
}
