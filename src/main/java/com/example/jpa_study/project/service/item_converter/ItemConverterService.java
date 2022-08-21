package com.example.jpa_study.project.service.item_converter;

import com.example.jpa_study.project.domain.type.ItemType;
import com.example.jpa_study.project.service.item_converter.dto.ServiceItemDto;

public interface ItemConverterService  {

    default boolean isItemTypeCheck(ServiceItemDto serviceItemDto) {
        return ItemType.ALBUM.equals(serviceItemDto.getItemType());
    }

    boolean isExistsFieldsCheck(ServiceItemDto serviceItemDto);

}
