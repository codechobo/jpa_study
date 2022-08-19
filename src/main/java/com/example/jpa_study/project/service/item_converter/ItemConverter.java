package com.example.jpa_study.project.service.item_converter;

import com.example.jpa_study.project.domain.Item;
import com.example.jpa_study.project.domain.type.ItemType;
import com.example.jpa_study.project.service.item_converter.dto.ServiceItemDto;

public interface ItemConverter {

    boolean isTypeCheck(ItemType itemType);
    <T extends Item> T convertItem(ServiceItemDto serviceItemDto);

}
