package com.example.jpa_study.project.web.dto.item_dto.response;

import com.example.jpa_study.project.domain.Item;
import lombok.Getter;

@Getter
public class ResponseItemSaveDto {

    private final String name;

    private final int price;

    private final int stockQuantity;

    public ResponseItemSaveDto(Item item) {
        this.name = item.getName();
        this.price = item.getPrice();
        this.stockQuantity = item.getStockQuantity();
    }
}
