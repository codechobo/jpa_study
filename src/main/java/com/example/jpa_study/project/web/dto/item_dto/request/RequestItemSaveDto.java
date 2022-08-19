package com.example.jpa_study.project.web.dto.item_dto.request;

import com.example.jpa_study.project.domain.type.ItemType;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;


@Getter
public class RequestItemSaveDto {

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

}
