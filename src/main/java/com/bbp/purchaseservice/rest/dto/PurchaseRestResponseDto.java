package com.bbp.purchaseservice.rest.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class PurchaseRestResponseDto {

    private String id;

    private int quantity;

    private String inventoryId;

    private String userId;
}
