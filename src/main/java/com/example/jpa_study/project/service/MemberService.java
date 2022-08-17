package com.example.jpa_study.project.service;

import com.example.jpa_study.project.domain.Member;
import com.example.jpa_study.project.domain.repository.MemberRepository;
import com.example.jpa_study.project.error.ErrorCode;
import com.example.jpa_study.project.error.exception.ExistsMemberInfoException;
import com.example.jpa_study.project.error.exception.NotFoundMemberEntityException;
import com.example.jpa_study.project.web.dto.member_dto.request.RequestMemberSaveDto;
import com.example.jpa_study.project.web.dto.member_dto.request.RequestMemberUpdateDto;
import com.example.jpa_study.project.web.dto.member_dto.response.ResponseMemberSaveDto;
import com.example.jpa_study.project.web.dto.member_dto.response.ResponseMembersPaging;
import lombok.RequiredArgsConstructor;
import org.hibernate.engine.transaction.spi.JoinStatus;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MemberService {

    private final MemberRepository memberRepository;

    @Transactional
    public ResponseMemberSaveDto signUp(RequestMemberSaveDto requestMemberSaveDto) {
        existsMember(requestMemberSaveDto.getEmail());

        Member member = requestMemberSaveDto.toEntity();
        member.joinStatus(JoinStatus.JOINED);

        memberRepository.save(member);
        return new ResponseMemberSaveDto(member);
    }

    private void existsMember(String email) {
        if (memberRepository.existsByEmail(email)) {
            throw new ExistsMemberInfoException(ErrorCode.EXISTS_MEMBER_INFO);
        }
    }

    public ResponseMemberSaveDto getMember(String email) {
        Member entity = getEntity(memberRepository.findByEmail(email));
        return new ResponseMemberSaveDto(entity);
    }

    public ResponseMembersPaging getMembers(String name, Pageable pageable) {
        Page<Member> memberPage = memberRepository.findAllByNameContaining(name, pageable);
        return new ResponseMembersPaging(memberPage);
    }

    @Transactional
    public Long updateMember(String email, RequestMemberUpdateDto requestMemberUpdateDto) {
        Member entity = getEntity(memberRepository.findByEmail(email));
        entity.updateAddress(requestMemberUpdateDto.getAddress());
        return entity.getId();
    }

    @Transactional
    public Long deleteMember(String email) {
        Member entity = getEntity(memberRepository.findByEmail(email));
        memberRepository.delete(entity);
        return entity.getId();
    }

    private Member getEntity(Optional<Member> optionalMember) {
        return optionalMember.orElseThrow(() -> new NotFoundMemberEntityException(
                ErrorCode.NOT_FOUND_MEMBER_ENTITY));
    }
}
