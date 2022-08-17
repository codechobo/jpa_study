package com.example.jpa_study.project.web;

import com.example.jpa_study.project.service.ItemService;
import com.example.jpa_study.project.web.dto.item_dto.request.RequestItemSaveDto;
import com.example.jpa_study.project.web.dto.item_dto.response.ResponseAlbumDto;
import com.example.jpa_study.project.web.dto.item_dto.response.ResponseBookDto;
import com.example.jpa_study.project.web.dto.item_dto.response.ResponseItemSaveDto;
import com.example.jpa_study.project.web.dto.item_dto.response.ResponseMovieDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/items")
@RequiredArgsConstructor
public class ItemController {

    private final ItemService itemService;

    @PostMapping("/{item-type}")
    public ResponseEntity<ResponseItemSaveDto> createItem(
            @PathVariable("item-type") String itemType,
            @RequestBody RequestItemSaveDto requestItemSaveDto) {
        ResponseItemSaveDto responseItemSaveDto = itemService.saveItem(itemType, requestItemSaveDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(responseItemSaveDto);
    }

    @GetMapping("/book")
    public ResponseEntity<ResponseBookDto> getBook(
            @RequestParam("name") String bookName) {
        ResponseBookDto book = itemService.findBook(bookName);
        return ResponseEntity.status(HttpStatus.OK).body(book);
    }

    @GetMapping("/album")
    public ResponseEntity<ResponseAlbumDto> getAlbum(
            @RequestParam("name") String albumName) {
        ResponseAlbumDto album = itemService.findAlbum(albumName);
        return ResponseEntity.status(HttpStatus.OK).body(album);
    }

    @GetMapping("/movie")
    public ResponseEntity<ResponseMovieDto> getMovie(
            @RequestParam("name") String movieName) {
        ResponseMovieDto movie = itemService.findMovie(movieName);
        return ResponseEntity.status(HttpStatus.OK).body(movie);
    }
}
