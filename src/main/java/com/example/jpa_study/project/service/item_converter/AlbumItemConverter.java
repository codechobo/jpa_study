package com.example.jpa_study.project.service.item_converter;

import com.example.jpa_study.project.domain.Album;
import com.example.jpa_study.project.domain.type.ItemType;
import com.example.jpa_study.project.error.ErrorCode;
import com.example.jpa_study.project.service.item_converter.dto.ServiceItemDto;
import org.springframework.stereotype.Component;

@Component
public class AlbumItemConverter implements ItemConverter {

    @Override
    public boolean isSupported(ServiceItemDto serviceItemDto) {
        if (isCheck(serviceItemDto)) {
            return true;
        } else {
            throw new IllegalArgumentException(ErrorCode.ITEM_INFO_BAD_REQUEST.getMessage());
        }
    }

    @Override
    public Album convertItem(ServiceItemDto serviceItemDto) {
        return serviceItemDto.toAlbumEntity();
    }

    @Override
    public boolean isExistsFieldsCheck(ServiceItemDto serviceItemDto) {
        return serviceItemDto.getEtc() != null && serviceItemDto.getArtist() != null;
    }

    @Override
    public boolean isItemTypeCheck(ServiceItemDto serviceItemDto) {
        return ItemType.ALBUM.equals(serviceItemDto.getItemType());
    }

    private boolean isCheck(ServiceItemDto serviceItemDto) {
        return isItemTypeCheck(serviceItemDto) && isExistsFieldsCheck(serviceItemDto);
    }
}
