package com.example.jpa_study.project.web.dto.item_dto.request;

import lombok.Getter;

import javax.validation.constraints.NotNull;

@Getter
public class RequestSearchItemDto {

    @NotNull
    private String dType;

    @NotNull
    private String itemName;
}
