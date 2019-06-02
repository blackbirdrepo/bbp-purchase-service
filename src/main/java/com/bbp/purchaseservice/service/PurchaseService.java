package com.bbp.purchaseservice.service;


import com.bbp.purchaseservice.domain.Purchase;
import com.bbp.purchaseservice.service.dto.PurchaseCreateServiceRequestDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface PurchaseService {

    Purchase readPurchase(String id);

    Page<Purchase> readPurchases(Pageable pageable);

    Purchase createPurchase(PurchaseCreateServiceRequestDto requestDto);

    void deletePurchase(String id);
}
