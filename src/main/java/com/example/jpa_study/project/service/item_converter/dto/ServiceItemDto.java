package com.example.jpa_study.project.service.item_converter.dto;

import com.example.jpa_study.project.domain.Album;
import com.example.jpa_study.project.domain.Book;
import com.example.jpa_study.project.domain.Movie;
import com.example.jpa_study.project.domain.type.ItemType;
import com.example.jpa_study.project.web.dto.item_dto.request.RequestItemSaveDto;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;


@Getter
public class ServiceItemDto {

    @NotNull
    private ItemType itemType;

    @NotEmpty
    @JsonProperty
    private String name;

    @JsonProperty
    private int price;

    @JsonProperty("quantity")
    private int stockQuantity;

    // movie
    @JsonProperty
    private String director;

    @JsonProperty
    private String actor;

    // book
    @JsonProperty
    private String author;

    @JsonProperty
    private String isbn;

    // album
    @JsonProperty
    private String artist;

    @JsonProperty
    private String etc;

    public ServiceItemDto(RequestItemSaveDto requestItemSaveDto) {
        this.itemType = requestItemSaveDto.getItemType();
        this.name = requestItemSaveDto.getName();
        this.price = requestItemSaveDto.getPrice();
        this.stockQuantity = requestItemSaveDto.getStockQuantity();
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
                .stockQuantity(this.stockQuantity)
                .author(this.author)
                .isbn(this.isbn)
                .build();
    }

    public Album toAlbumEntity() {
        return Album.builder()
                .name(this.name)
                .price(this.price)
                .stockQuantity(this.stockQuantity)
                .etc(this.etc)
                .artist(this.artist)
                .build();
    }

    public Movie toMovieEntity() {
        return Movie.builder()
                .name(this.name)
                .price(this.price)
                .stockQuantity(this.stockQuantity)
                .actor(this.actor)
                .director(this.director)
                .build();
    }
}
