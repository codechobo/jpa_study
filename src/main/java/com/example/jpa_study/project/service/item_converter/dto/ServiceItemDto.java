package com.example.jpa_study.project.service.item_converter.dto;

import com.example.jpa_study.project.domain.Album;
import com.example.jpa_study.project.domain.Book;
import com.example.jpa_study.project.domain.Movie;
import com.example.jpa_study.project.domain.type.ItemType;
import com.example.jpa_study.project.web.dto.item_dto.request.RequestItemSaveDto;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;


@Getter
@NoArgsConstructor
public class ServiceItemDto {

    @NotNull
    private ItemType itemType;

    @NotEmpty
    private String name;
    private int price;
    private int quantity;

    private String director;
    private String actor;
    private String author;
    private String isbn;
    private String artist;
    private String etc;

    public ServiceItemDto(RequestItemSaveDto requestItemSaveDto) {
        this.itemType = requestItemSaveDto.getItemType();
        this.name = requestItemSaveDto.getName();
        this.price = requestItemSaveDto.getPrice();
        this.quantity = requestItemSaveDto.getQuantity();
        this.director = requestItemSaveDto.getDirector();
        this.actor = requestItemSaveDto.getActor();
        this.author = requestItemSaveDto.getAuthor();
        this.isbn = requestItemSaveDto.getIsbn();
        this.artist = requestItemSaveDto.getArtist();
        this.etc = requestItemSaveDto.getEtc();
    }

    public Book toBookEntity() {
        return Book.builder()
                .name(this.name)
                .price(this.price)
                .stockQuantity(this.quantity)
                .author(this.author)
                .isbn(this.isbn)
                .build();
    }

    public Album toAlbumEntity() {
        return Album.builder()
                .name(this.name)
                .price(this.price)
                .stockQuantity(this.quantity)
                .etc(this.etc)
                .artist(this.artist)
                .build();
    }

    public Movie toMovieEntity() {
        return Movie.builder()
                .name(this.name)
                .price(this.price)
                .stockQuantity(this.quantity)
                .actor(this.actor)
                .director(this.director)
                .build();
    }
}
