package com.example.jpa_study.project.service;

import com.example.jpa_study.project.domain.Album;
import com.example.jpa_study.project.domain.Book;
import com.example.jpa_study.project.domain.Movie;
import com.example.jpa_study.project.domain.repository.ItemRepository;
import com.example.jpa_study.project.domain.type.ItemType;
import com.example.jpa_study.project.error.ErrorCode;
import com.example.jpa_study.project.error.exception.ItemSaveFailException;
import com.example.jpa_study.project.web.dto.item_dto.RequestItemSaveDto;
import com.example.jpa_study.project.web.dto.item_dto.ResponseItemSaveDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class ItemService {

    private final ItemRepository itemRepository;

    @Transactional
    public ResponseItemSaveDto saveItem(String itemType, RequestItemSaveDto requestItemSaveDto) {
        if (ItemType.typeCheck(itemType) && !isExistsCheck(requestItemSaveDto)) {

            if (ItemType.BOOK.getTypeName().equals(itemType)) {
                Book book = itemRepository.save(requestItemSaveDto.toBookEntity());
                return new ResponseItemSaveDto(book);
            }

            if (ItemType.ALBUM.getTypeName().equals(itemType)) {
                Album album = itemRepository.save(requestItemSaveDto.toAlbumEntity());
                return new ResponseItemSaveDto(album);
            }

            if (ItemType.MOVIE.getTypeName().equals(itemType)) {
                Movie movie = itemRepository.save(requestItemSaveDto.toMovieEntity());
                return new ResponseItemSaveDto(movie);
            }
        }

        throw new ItemSaveFailException(ErrorCode.ITEM_SAVE_FAIL);
    }

    private boolean isExistsCheck(RequestItemSaveDto requestItemSaveDto) {
        return itemRepository.existsByName(requestItemSaveDto.getName());
    }

}
