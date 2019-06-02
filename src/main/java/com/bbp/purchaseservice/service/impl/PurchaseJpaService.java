package com.bbp.purchaseservice.service.impl;

import com.bbp.purchaseservice.domain.Purchase;
import com.bbp.purchaseservice.repository.PurchaseRepository;
import com.bbp.purchaseservice.service.PurchaseService;
import com.bbp.purchaseservice.service.dto.PurchaseCreateServiceRequestDto;
import com.bbp.purchaseservice.service.exception.ObjectNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@RequiredArgsConstructor
@Service
public class PurchaseJpaService implements PurchaseService {

    private final PurchaseRepository repository;

    @Override
    public Purchase readPurchase(String purchaseId) {
        return repository
                .findById(Long.valueOf(purchaseId))
                .orElseThrow(() -> new ObjectNotFoundException(String.format("Purchase with id: %s not found", purchaseId)));
    }

    @Override
    public Page<Purchase> readPurchases(Pageable pageable) {
        return repository.findAll(pageable);
    }

    @Override
    public Purchase createPurchase(PurchaseCreateServiceRequestDto requestDto) {
        var purchase = Purchase.create(
                requestDto.getQuantity(),
                requestDto.getInventoryId(),
                requestDto.getUserId());
        return repository.save(purchase);
    }

    @Override
    public void deletePurchase(String purchaseId) {
        repository.delete(readPurchase(purchaseId));
    }
}
