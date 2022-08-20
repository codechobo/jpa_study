package com.example.jpa_study.project.service.item_converter;

import com.example.jpa_study.project.domain.Book;
import com.example.jpa_study.project.domain.type.ItemType;
import com.example.jpa_study.project.service.item_converter.dto.ServiceItemDto;
import org.springframework.stereotype.Component;

@Component
public class BookItemConverter implements ItemConverter {
    @Override
    public boolean isTypeCheck(ItemType itemType) {
        return ItemType.BOOK.equals(itemType);
    }

    @Override
    public boolean isFieldCheck(ServiceItemDto serviceItemDto) {
        if (serviceItemDto.getIsbn() == null && serviceItemDto.getAuthor() == null) {
            throw new IllegalArgumentException("아템 속성을 잘못 입력했습니다.");
        } else {
            return true;
        }
    }

    @Override
    public Book convertItem(ServiceItemDto serviceItemDto) {
        return serviceItemDto.toBookEntity();
    }
}
