package com.example.jpa_study.project.domain;

import com.example.jpa_study.project.config.BeanUtil;
import com.example.jpa_study.project.domain.repository.MemberHistoryRepository;
import com.example.jpa_study.project.error.ErrorCode;
import com.example.jpa_study.project.error.exception.NotFoundMemberEntityException;
import org.hibernate.engine.transaction.spi.JoinStatus;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.PostPersist;
import javax.persistence.PostUpdate;
import javax.persistence.PreRemove;

public class MemberHistoryListener {

    @PostPersist
    @PostUpdate
    public void insertAndUpdateMemberHistorySave(Object o) {
        MemberHistoryRepository memberHistoryRepository = BeanUtil.getBean(MemberHistoryRepository.class);

        Member member = (Member) o;

        MemberHistory memberHistory = createMemberHistory(member);
        memberHistoryRepository.save(memberHistory);
    }

    @PreRemove
    @Transactional
    public void deleteMemberHistorySave(Object o) {
        MemberHistoryRepository memberHistoryRepository = BeanUtil.getBean(MemberHistoryRepository.class);

        Member member = (Member) o;
        MemberHistory memberHistory = getMemberHistory(memberHistoryRepository, member);

        memberHistory.updateJoinStatus(JoinStatus.NOT_JOINED);
    }

    private static MemberHistory getMemberHistory(MemberHistoryRepository memberHistoryRepository, Member member) {
        return memberHistoryRepository.findById(member.getId())
                .orElseThrow(() -> new NotFoundMemberEntityException(
                        ErrorCode.NOT_FOUND_MEMBER_ENTITY.getMessage(), ErrorCode.NOT_FOUND_MEMBER_ENTITY));
    }

    private static MemberHistory createMemberHistory(Member member) {
        return MemberHistory.builder()
                .name(member.getName())
                .email(member.getEmail())
                .address(member.getAddress())
                .joinStatus(member.getJoinStatus())
                .build();
    }


}
