package com.example.jpa_study.project.web.dto.order_dto;

import com.example.jpa_study.project.domain.OrderItem;
import lombok.Builder;
import lombok.Getter;

@Getter
public class ResponseOrderItemListDto {

    private final String itemName;
    private final int itemPrice;
    private final int count;
    private final int toTalPrice;

    @Builder
    public ResponseOrderItemListDto(OrderItem orderItem) {
        this.itemName = orderItem.getItem().getName();
        this.itemPrice = orderItem.getItem().getPrice();
        this.count = orderItem.getCount();
        this.toTalPrice = orderItem.getTotalPrice();
    }
}
