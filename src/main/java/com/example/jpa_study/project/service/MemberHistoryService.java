package com.example.jpa_study.project.service;

import com.example.jpa_study.project.domain.MemberHistory;
import com.example.jpa_study.project.domain.repository.MemberHistoryRepository;
import com.example.jpa_study.project.web.dto.member_dto.response.ResponseJoinStatusMemberPaging;
import lombok.RequiredArgsConstructor;
import org.hibernate.engine.transaction.spi.JoinStatus;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberHistoryService {

    private final MemberHistoryRepository memberHistoryRepository;

    public ResponseJoinStatusMemberPaging findMemberByStatus(JoinStatus joinStatus, Pageable pageable) {
        Page<MemberHistory> memberHistoryPage = memberHistoryRepository
                .findAllByJoinStatus(joinStatus, pageable);
        return new ResponseJoinStatusMemberPaging(memberHistoryPage);
    }
}
