package com.example.jpa_study.project.service.item_converter;

import com.example.jpa_study.project.domain.Album;
import com.example.jpa_study.project.domain.type.ItemType;
import com.example.jpa_study.project.service.item_converter.dto.ServiceItemDto;
import org.springframework.stereotype.Component;

@Component
public class AlbumItemConverter implements ItemConverter {
    @Override
    public boolean isTypeCheck(ItemType itemType) {
        return ItemType.ALBUM.equals(itemType);
    }

    @Override
    public boolean isFieldCheck(ServiceItemDto serviceItemDto) {
        if (serviceItemDto.getEtc() == null && serviceItemDto.getArtist() == null) {
            throw new IllegalArgumentException("아템 속성을 잘못 입력했습니다.");
        } else {
            return true;
        }
    }

    @Override
    public Album convertItem(ServiceItemDto serviceItemDto) {
        return serviceItemDto.toAlbumEntity();
    }
}
