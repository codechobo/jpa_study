package com.example.jpa_study.project.service.item_converter;

import com.example.jpa_study.project.domain.Movie;
import com.example.jpa_study.project.domain.type.ItemType;
import com.example.jpa_study.project.service.item_converter.dto.ServiceItemDto;
import org.springframework.stereotype.Component;

@Component
public class MovieItemConverter implements ItemConverter {
    @Override
    public boolean isTypeCheck(ItemType itemType) {
        return ItemType.MOVIE.equals(itemType);
    }

    @Override
    public boolean isFieldCheck(ServiceItemDto serviceItemDto) {
        if (serviceItemDto.getDirector() == null && serviceItemDto.getActor() == null) {
            throw new IllegalArgumentException("아템 속성을 잘못 입력했습니다.");
        } else {
            return true;
        }
    }

    @Override
    public Movie convertItem(ServiceItemDto serviceItemDto) {
        return serviceItemDto.toMovieEntity();
    }
}
