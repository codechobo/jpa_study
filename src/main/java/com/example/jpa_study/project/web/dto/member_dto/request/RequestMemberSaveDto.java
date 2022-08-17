package com.example.jpa_study.project.web.dto.member_dto.request;

import com.example.jpa_study.project.domain.Member;
import com.example.jpa_study.project.domain.type.Address;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RequestMemberSaveDto {

    @NotNull
    @Size(max = 100)
    private String name;

    @NotBlank
    @Email
    @Size(max = 50)
    private String email;

    @NotNull
    private Address address;

    public Member toEntity() {
        return Member.builder()
                .name(this.name)
                .email(this.email)
                .address(this.address)
                .build();
    }

}
