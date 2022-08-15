package com.example.jpa_study.project.web.dto;

import com.example.jpa_study.project.domain.Member;
import lombok.Getter;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.stream.Collectors;

@Getter
public class ResponseMembersPaging {

    private final List<ResponseMemberSaveDto> members;
    private final int pageSize;
    private final int totalPages;
    private final long totalElements;

    public ResponseMembersPaging(Page<Member> memberPage) {
        this.members = memberPage.getContent().stream()
                .map(ResponseMemberSaveDto::new)
                .collect(Collectors.toList());
        this.pageSize = memberPage.getSize();
        this.totalPages = memberPage.getTotalPages();
        this.totalElements = memberPage.getTotalElements();
    }
}
