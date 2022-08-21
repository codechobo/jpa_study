package com.example.jpa_study.project.service.item_converter;

import com.example.jpa_study.project.domain.type.ItemType;
import com.example.jpa_study.project.service.item_converter.dto.ServiceItemDto;

public interface ItemConverterService  {

    private boolean isItemTypeCheck(ServiceItemDto serviceItemDto) {
        return ItemType.ALBUM.equals(serviceItemDto.getItemType());
    }

    public boolean isExistsFieldsCheck(ServiceItemDto serviceItemDto);

}
