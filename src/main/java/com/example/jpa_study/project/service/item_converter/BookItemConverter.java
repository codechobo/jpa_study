package com.example.jpa_study.project.service.item_converter;

import com.example.jpa_study.project.domain.Item;
import com.example.jpa_study.project.domain.type.ItemType;
import com.example.jpa_study.project.service.item_converter.dto.ServiceItemDto;
import org.springframework.stereotype.Component;

@Component
public class BookItemConverter implements ItemConverter {

    @Override
    public boolean isSupported(ServiceItemDto serviceItemDto) {
        return isCheck(serviceItemDto);
    }

    @Override
    public Item convertItem(ServiceItemDto serviceItemDto) {
        return serviceItemDto.toBookEntity();
    }

    private boolean isCheck(ServiceItemDto serviceItemDto) {
        return isItemTypeCheck(serviceItemDto) && isExistsFieldsCheck(serviceItemDto);
    }

    private boolean isExistsFieldsCheck(ServiceItemDto serviceItemDto) {
        return serviceItemDto.getIsbn() != null && serviceItemDto.getAuthor() != null;
    }

    private boolean isItemTypeCheck(ServiceItemDto serviceItemDto) {
        return ItemType.BOOK.equals(serviceItemDto.getItemType());
    }
}
