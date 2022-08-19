package com.example.jpa_study.project.web;

import com.example.jpa_study.project.service.ItemService;
import com.example.jpa_study.project.web.dto.item_dto.request.RequestItemSaveDto;
import com.example.jpa_study.project.web.dto.item_dto.response.ResponseItemSaveDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class ItemController {

    private final ItemService itemService;

    @PostMapping("/items")
    public ResponseEntity<ResponseItemSaveDto> createItem(@RequestBody RequestItemSaveDto requestItemSaveDto) {
        ResponseItemSaveDto responseItemSaveDto = itemService.saveItem(requestItemSaveDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(responseItemSaveDto);
    }

    @GetMapping("/items/{id}")
    public ResponseEntity<ResponseItemSaveDto> getItem(
            @PathVariable("id") Long itemId) {
        ResponseItemSaveDto item = itemService.findItem(itemId);
        return ResponseEntity.status(HttpStatus.OK).body(item);
    }
}
