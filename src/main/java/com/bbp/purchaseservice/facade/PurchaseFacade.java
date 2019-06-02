package com.bbp.purchaseservice.facade;

import com.bbp.purchaseservice.domain.Purchase;
import com.bbp.purchaseservice.facade.dto.PurchaseCreateFacadeRequestDto;
import com.bbp.purchaseservice.integration.InventoryClient;
import com.bbp.purchaseservice.integration.dto.InventoryDto;
import com.bbp.purchaseservice.service.PurchaseService;
import com.bbp.purchaseservice.service.exception.NegativeQuantityBalanceException;
import com.bbp.purchaseservice.service.mapper.PurchaseMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.nio.CharBuffer;

@RequiredArgsConstructor
@Transactional
@Service
public class PurchaseFacade {

    private final PurchaseService purchaseService;
    private final InventoryClient inventoryClient;
    private final PurchaseMapper mapper;

    public Purchase readPurchase(String purchaseId) {
        return purchaseService.readPurchase(purchaseId);
    }

    public Page<Purchase> readPurchases(Pageable pageable) {
        return purchaseService.readPurchases(pageable);
    }

    public Purchase createPurchase(PurchaseCreateFacadeRequestDto requestDto) {
        var serviceRequestDto = mapper.toCreateServiceRequest(requestDto);
        var inventoryDto = inventoryClient.readInventory(requestDto.getInventoryId());
        //TODO fetch user and userId from Security Context
        if (inventoryDto.getQuantity() < requestDto.getQuantity()) {
            throw new NegativeQuantityBalanceException();
        }
        serviceRequestDto.setInventoryId(inventoryDto.getId());
        //TODO make transaction
        inventoryClient.reduceInventoryQuantity(requestDto.getInventoryId(), requestDto.getQuantity());
        return purchaseService.createPurchase(serviceRequestDto);
    }

    public void deletePurchase(String purchaseId) {
        purchaseService.deletePurchase(purchaseId);
    }
}
