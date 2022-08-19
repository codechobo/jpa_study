package com.example.jpa_study.project.service.item_converter;

import com.example.jpa_study.project.domain.Item;
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
    public Item convertItem(ServiceItemDto serviceItemDto) {
        return serviceItemDto.toBookEntity();
    }
}
