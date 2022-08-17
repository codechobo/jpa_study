package com.example.jpa_study.project.web.dto.item_dto.request;

import com.example.jpa_study.project.domain.Book;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

import javax.validation.constraints.NotNull;

@Getter
public class RequestBookSaveDto {

    // common
    @NotNull
    @JsonProperty
    private String name;

    @JsonProperty
    private int price;

    @JsonProperty("quantity")
    private int stockQuantity;

    @JsonProperty
    private String author;

    @JsonProperty
    private String isbn;

    public Book toBookEntity() {
        return Book.builder()
                .name(this.name)
                .price(this.price)
                .stockQuantity(this.stockQuantity)
                .author(this.author)
                .isbn(this.isbn)
                .build();
    }
}
