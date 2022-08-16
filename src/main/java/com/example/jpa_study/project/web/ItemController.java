package com.example.jpa_study.project.web;

import com.example.jpa_study.project.service.ItemService;
import com.example.jpa_study.project.web.dto.item_dto.RequestItemSaveDto;
import com.example.jpa_study.project.web.dto.item_dto.ResponseItemSaveDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/items")
@RequiredArgsConstructor
public class ItemController {

    private final ItemService itemService;

    @PostMapping("/{type}")
    public ResponseEntity<ResponseItemSaveDto> createItem(
            @PathVariable("type") String itemType,
            @RequestBody RequestItemSaveDto requestItemSaveDto) {
        ResponseItemSaveDto responseItemSaveDto = itemService.saveItem(itemType, requestItemSaveDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(responseItemSaveDto);
    }

}
