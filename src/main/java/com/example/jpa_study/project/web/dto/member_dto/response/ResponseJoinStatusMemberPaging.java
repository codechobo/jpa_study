package com.example.jpa_study.project.web.dto.member_dto.response;

import com.example.jpa_study.project.domain.MemberHistory;
import lombok.Getter;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.stream.Collectors;

@Getter
public class ResponseJoinStatusMemberPaging {

    private final List<ResponseJoinStatusMemberDto> members;
    private final int pageSize;
    private final int totalPages;
    private final long totalElements;

    public ResponseJoinStatusMemberPaging(Page<MemberHistory> memberPage) {
        this.members = memberPage.getContent().stream()
                .map(ResponseJoinStatusMemberDto::new)
                .collect(Collectors.toList());
        this.pageSize = memberPage.getSize();
        this.totalPages = memberPage.getTotalPages();
        this.totalElements = memberPage.getTotalElements();
    }
}
