package com.bbp.purchaseservice.facade.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.AssertTrue;
import java.util.Arrays;

@Getter
@Setter
@NoArgsConstructor
public class PurchaseCreateFacadeRequestDto {

    private int quantity;

    private String inventoryId;

    private String userId;
}
