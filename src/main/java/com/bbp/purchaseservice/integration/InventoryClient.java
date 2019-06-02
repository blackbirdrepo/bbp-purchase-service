package com.bbp.purchaseservice.integration;

import com.bbp.purchaseservice.integration.dto.InventoryDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import static com.bbp.purchaseservice.config.Constants.WAREHOUSE_PATH;

@FeignClient("bbp-warehouse-service")
@Service
public interface InventoryClient {
    //TODO implement fallback
    @GetMapping(path = WAREHOUSE_PATH + "/inventories/{inventoryId}")
    InventoryDto readInventory(@PathVariable("inventoryId") String inventoryId);

    @PostMapping(path = WAREHOUSE_PATH + "/inventories/{inventoryId}/quantity/reduce")
    void reduceInventoryQuantity(@PathVariable("inventoryId") String inventoryId,
                                 @RequestParam("amount") int amount);
}
