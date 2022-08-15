package com.example.jpa_study.project.web.dto;

import com.example.jpa_study.project.domain.MemberHistory;
import com.example.jpa_study.project.domain.type.Address;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class ResponseJoinStatusMemberDto {

    private final String name;

    private final String email;

    private final Address address;

    private final LocalDateTime signUpTime;

    private final LocalDateTime updatedTime;

    public ResponseJoinStatusMemberDto(MemberHistory memberHistory) {
        this.name = memberHistory.getName();
        this.email = memberHistory.getEmail();
        this.address = memberHistory.getAddress();
        this.signUpTime = memberHistory.getCreatedAt();
        this.updatedTime = memberHistory.getUpdatedAt();
    }
}
