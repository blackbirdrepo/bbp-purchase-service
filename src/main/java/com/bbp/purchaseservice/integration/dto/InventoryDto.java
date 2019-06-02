package com.bbp.purchaseservice.integration.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class InventoryDto {

    private Long id;

    private String sku;

    private String name;

    private String model;

    private String price;

    private int quantity;

    private Long brandId;

    private Long categoryId;
}