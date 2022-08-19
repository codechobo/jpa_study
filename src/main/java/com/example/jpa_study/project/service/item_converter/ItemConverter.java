package com.example.jpa_study.project.service.item_converter;

import com.example.jpa_study.project.domain.Item;
import com.example.jpa_study.project.domain.type.ItemType;
import com.example.jpa_study.project.web.dto.item_dto.request.RequestItemSaveDto;

public interface ItemConverter {

    boolean isTypeCheck(ItemType itemType);
    <T extends Item> T convertItem(RequestItemSaveDto requestItemSaveDto);

}
