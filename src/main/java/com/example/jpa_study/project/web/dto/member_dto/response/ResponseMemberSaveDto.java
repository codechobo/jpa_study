package com.example.jpa_study.project.web.dto.member_dto.response;

import com.example.jpa_study.project.domain.Member;
import com.example.jpa_study.project.domain.type.Address;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class ResponseMemberSaveDto {

    private final String name;
    private final String email;
    private final Address address;
    private final LocalDateTime signUpTime;
    private final LocalDateTime updatedTime;

    public ResponseMemberSaveDto(Member member) {
        this.name = member.getName();
        this.email = member.getEmail();
        this.address = member.getAddress();
        this.signUpTime = member.getCreatedAt();
        this.updatedTime = member.getUpdatedAt();
    }
}
