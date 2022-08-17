package com.example.jpa_study.project.web.dto.item_dto.request;

import com.example.jpa_study.project.domain.Album;
import com.example.jpa_study.project.domain.Book;
import com.example.jpa_study.project.domain.Movie;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

import javax.validation.constraints.NotNull;


@Getter
public class RequestItemSaveDto {

    // common
    @NotNull
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
