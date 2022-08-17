package com.example.jpa_study.project.web.dto.member_dto.request;

import com.example.jpa_study.project.domain.type.Address;
import lombok.Getter;

import javax.validation.constraints.NotNull;

@Getter
public class RequestMemberUpdateDto {

    @NotNull
    private Address address;

}
