package com.bbp.purchaseservice.integration;

import com.bbp.purchaseservice.integration.dto.InventoryDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient("bbp-warehouse-service")
@Service
public interface InventoryClient {

    @GetMapping(path = "/api/v1/warehouseservice/inventories/{inventoryId}")
    InventoryDto readInventory(@PathVariable("inventoryId") String inventoryId);

    @PostMapping(path = "/api/v1/warehouseservice/inventories/{inventoryId}/quantity/reduce")
    void reduceInventoryQuantity(@PathVariable("inventoryId") String inventoryId,
                                 @RequestParam("amount") int amount);
}
