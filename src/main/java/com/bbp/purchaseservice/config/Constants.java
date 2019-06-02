package com.bbp.purchaseservice.config;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class Constants {

    private static final String REST_PATH = "/api/v1";
    public static final String PURCHASE_PATH = REST_PATH + "/purchaseservice";
    public static final String WAREHOUSE_PATH = REST_PATH + "/warehouseservice";
}
