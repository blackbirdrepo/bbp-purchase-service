package com.bbp.purchaseservice.service.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class PurchaseCreateServiceRequestDto {

    private int quantity;

    private long inventoryId;

    private long userId;
}
