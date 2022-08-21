package com.example.jpa_study.project.service.item_converter;

import com.example.jpa_study.project.domain.Item;
import com.example.jpa_study.project.service.item_converter.dto.ServiceItemDto;

public interface ItemConverter extends ItemConverterService {

    boolean isSupported(ServiceItemDto serviceItemDto);
    Item convertItem(ServiceItemDto serviceItemDto);

}
