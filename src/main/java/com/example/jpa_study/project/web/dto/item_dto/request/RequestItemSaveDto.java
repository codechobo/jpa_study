package com.example.jpa_study.project.web.dto.item_dto.request;

import com.example.jpa_study.project.domain.type.ItemType;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;


@Getter
@NoArgsConstructor
public class RequestItemSaveDto {

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

}
