package com.bbp.purchaseservice.rest.controller;


import com.bbp.purchaseservice.facade.PurchaseFacade;
import com.bbp.purchaseservice.rest.dto.PurchaseCreateRestRequestDto;
import com.bbp.purchaseservice.rest.dto.PurchaseRestResponseDto;
import com.bbp.purchaseservice.service.mapper.PurchaseMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static com.bbp.purchaseservice.config.Constants.PURCHASE_PATH;

@RequiredArgsConstructor
@RestController
@RequestMapping(PURCHASE_PATH + "/purchases/")
public class PurchaseController {

    private final PurchaseFacade facade;
    private final PurchaseMapper mapper;

    @GetMapping(path = "{purchaseId}")
    public ResponseEntity<PurchaseRestResponseDto> readPurchase(@PathVariable String purchaseId) {
        var purchase = facade.readPurchase(purchaseId);
        return ResponseEntity.ok().body(mapper.toRestResponse(purchase));
    }

    @GetMapping
    public ResponseEntity<Page<PurchaseRestResponseDto>> readPurchases(Pageable pageable) {
        var inventories = facade.readPurchases(pageable);
        return ResponseEntity.ok().body(mapper.toRestResponsePage(inventories));
    }

    @PostMapping
    public ResponseEntity<PurchaseRestResponseDto> createPurchase(@RequestBody PurchaseCreateRestRequestDto restDto) {
        var facadeDto = mapper.toCreateFacadeRequest(restDto);
        var purchase = facade.createPurchase(facadeDto);
        //TODO fix null in location
        return ResponseEntity.created(null).body(mapper.toRestResponse(purchase));
    }

    @DeleteMapping(path = "/{purchaseId}")
    public ResponseEntity<Void> deletePurchase(@PathVariable String purchaseId) {
        facade.deletePurchase(purchaseId);
        return ResponseEntity.noContent().build();
    }
}
