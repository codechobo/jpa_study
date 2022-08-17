package com.example.jpa_study.project.service;

import com.example.jpa_study.project.domain.Album;
import com.example.jpa_study.project.domain.Book;
import com.example.jpa_study.project.domain.Movie;
import com.example.jpa_study.project.domain.repository.ItemRepository;
import com.example.jpa_study.project.domain.type.ItemType;
import com.example.jpa_study.project.error.ErrorCode;
import com.example.jpa_study.project.error.exception.ExistsItemInfoException;
import com.example.jpa_study.project.error.exception.ItemSaveFailException;
import com.example.jpa_study.project.error.exception.NotFoundItemEntityException;
import com.example.jpa_study.project.web.dto.item_dto.request.RequestItemSaveDto;
import com.example.jpa_study.project.web.dto.item_dto.response.ResponseAlbumDto;
import com.example.jpa_study.project.web.dto.item_dto.response.ResponseBookDto;
import com.example.jpa_study.project.web.dto.item_dto.response.ResponseItemSaveDto;
import com.example.jpa_study.project.web.dto.item_dto.response.ResponseMovieDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ItemService {

    private final ItemRepository itemRepository;

    @Transactional
    public ResponseItemSaveDto saveItem(String itemType, RequestItemSaveDto requestItemSaveDto) {
        if (ItemType.typeCheck(itemType) && isExistsCheck(requestItemSaveDto.getName())) {

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

    private boolean isExistsCheck(String itemName) {
        if (itemRepository.existsByName(itemName)) {
            throw new ExistsItemInfoException(ErrorCode.EXISTS_ITEM_INFO);
        }
        return true;
    }

    public ResponseBookDto findBook(String bookName) {
        Book book = getOptional(itemRepository.findBookByName(bookName));
        return new ResponseBookDto(book);
    }

    public ResponseAlbumDto findAlbum(String albumName) {
        Album album = getOptional(itemRepository.findAlbumByName(albumName));
        return new ResponseAlbumDto(album);
    }

    public ResponseMovieDto findMovie(String movieName) {
        Movie movie = getOptional(itemRepository.findMovieByName(movieName));
        return new ResponseMovieDto(movie);
    }

    private <T> T getOptional(Optional<T> optional) {
        return optional.orElseThrow(() -> new NotFoundItemEntityException(ErrorCode.NOT_FOUND_ITEM_ENTITY));
    }
}
