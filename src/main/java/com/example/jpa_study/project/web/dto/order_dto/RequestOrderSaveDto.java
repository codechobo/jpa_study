package com.example.jpa_study.project.web.dto.order_dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

import javax.validation.constraints.NotNull;

@Getter
public class RequestOrderSaveDto {

    @NotNull
    @JsonProperty("member_id")
    private Long memberId;

    @NotNull
    @JsonProperty("item_id")
    private Long itemId;

    @JsonProperty("order_quantity")
    private int orderQuantity;
}
