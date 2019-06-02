package com.bbp.purchaseservice.service.mapper;

import com.bbp.purchaseservice.domain.Purchase;
import com.bbp.purchaseservice.facade.dto.PurchaseCreateFacadeRequestDto;
import com.bbp.purchaseservice.rest.dto.PurchaseCreateRestRequestDto;
import com.bbp.purchaseservice.rest.dto.PurchaseRestResponseDto;
import com.bbp.purchaseservice.service.dto.PurchaseCreateServiceRequestDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.data.domain.Page;

@Mapper(componentModel = "spring")
public interface PurchaseMapper {

    PurchaseCreateFacadeRequestDto toCreateFacadeRequest(PurchaseCreateRestRequestDto requestDto);

    PurchaseCreateServiceRequestDto toCreateServiceRequest(PurchaseCreateFacadeRequestDto requestDto);

    @Mapping(target = "userId", source = "purchase.user")
    @Mapping(target = "inventoryId", source = "purchase.inventory")
    PurchaseRestResponseDto toRestResponse(Purchase purchase);

    default Page<PurchaseRestResponseDto> toRestResponsePage(Page<Purchase> purchasePage) {
        return purchasePage.map(this::toRestResponse);
    }
}
