package com.example.jpa_study.project.service;

import com.example.jpa_study.project.domain.Item;
import com.example.jpa_study.project.domain.repository.ItemRepository;
import com.example.jpa_study.project.error.ErrorCode;
import com.example.jpa_study.project.error.exception.ExistsItemInfoException;
import com.example.jpa_study.project.error.exception.ItemSaveFailException;
import com.example.jpa_study.project.error.exception.NotFoundItemEntityException;
import com.example.jpa_study.project.service.item_converter.ItemConverter;
import com.example.jpa_study.project.service.item_converter.dto.ServiceItemDto;
import com.example.jpa_study.project.web.dto.item_dto.request.RequestItemSaveDto;
import com.example.jpa_study.project.web.dto.item_dto.response.ResponseItemSaveDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ItemService {

    private final ItemRepository itemRepository;
    private final List<ItemConverter> itemConverterList;

    @Transactional
    public ResponseItemSaveDto saveItem(RequestItemSaveDto requestItemSaveDto) {
        if (isNotExistsItem(requestItemSaveDto)) {
            ServiceItemDto serviceItemDto = createServiceItemDto(requestItemSaveDto);

            Item item = itemConverter(serviceItemDto);

            Item saveItem = itemRepository.save(item);
            return new ResponseItemSaveDto(saveItem);
        }
        throw new ItemSaveFailException(ErrorCode.ITEM_SAVE_FAIL);
    }

    public ResponseItemSaveDto findItem(Long itemId) {
        Item item = getOptional(itemRepository.findById(itemId));
        return new ResponseItemSaveDto(item);
    }

    private Item itemConverter(ServiceItemDto serviceItemDto) {
        return itemConverterList.stream()
                .filter(itemConverterList -> itemConverterList.isSupported(serviceItemDto))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("itemType 을 지원하는 converter 가 존재하지 않습니다"))
                .convertItem(serviceItemDto);
    }

    private ServiceItemDto createServiceItemDto(RequestItemSaveDto requestItemSaveDto) {
        return new ServiceItemDto(requestItemSaveDto);
    }

    private boolean isNotExistsItem(RequestItemSaveDto dto) {
        if (itemRepository.existsByName(dto.getName())) {
            throw new ExistsItemInfoException(ErrorCode.EXISTS_ITEM_INFO);
        }
        return true;
    }

    private <T> T getOptional(Optional<T> optional) {
        return optional
                .orElseThrow(() -> new NotFoundItemEntityException(ErrorCode.NOT_FOUND_ITEM_ENTITY));
    }
}
