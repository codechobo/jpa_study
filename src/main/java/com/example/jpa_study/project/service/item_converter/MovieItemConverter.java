package com.example.jpa_study.project.service.item_converter;

import com.example.jpa_study.project.domain.Movie;
import com.example.jpa_study.project.domain.type.ItemType;
import com.example.jpa_study.project.error.ErrorCode;
import com.example.jpa_study.project.service.item_converter.dto.ServiceItemDto;
import org.springframework.stereotype.Component;

@Component
public class MovieItemConverter implements ItemConverter {

    @Override
    public boolean isSupported(ServiceItemDto serviceItemDto) {
        if (isCheck(serviceItemDto)) {
            throw new IllegalArgumentException(ErrorCode.ITEM_INFO_BAD_REQUEST.getMessage());
        } else {
            return true;
        }
    }

    @Override
    public Movie convertItem(ServiceItemDto serviceItemDto) {
        return serviceItemDto.toMovieEntity();
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
