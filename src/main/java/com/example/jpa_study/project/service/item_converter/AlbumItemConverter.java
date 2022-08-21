package com.example.jpa_study.project.service.item_converter;

import com.example.jpa_study.project.domain.Item;
import com.example.jpa_study.project.domain.type.ItemType;
import com.example.jpa_study.project.service.item_converter.dto.ServiceItemDto;
import org.springframework.stereotype.Component;

@Component
public class AlbumItemConverter implements ItemConverter {

    @Override
    public boolean isSupported(ServiceItemDto serviceItemDto) {
        return isCheck(serviceItemDto);
    }

    @Override
    public Item convertItem(ServiceItemDto serviceItemDto) {
        return serviceItemDto.toAlbumEntity();
    }

    private boolean isCheck(ServiceItemDto serviceItemDto) {
        return isItemTypeCheck(serviceItemDto) && isExistsFieldsCheck(serviceItemDto);
    }

    private boolean isExistsFieldsCheck(ServiceItemDto serviceItemDto) {
        return serviceItemDto.getEtc() != null && serviceItemDto.getArtist() != null;
    }

    private boolean isItemTypeCheck(ServiceItemDto serviceItemDto) {
        return ItemType.ALBUM.equals(serviceItemDto.getItemType());
    }
}
