package com.example.jpa_study.project.domain.repository;

import com.example.jpa_study.project.domain.Member;
import com.example.jpa_study.project.domain.type.Address;
import com.example.jpa_study.project.web.dto.ResponseMemberSaveDto;
import com.example.jpa_study.project.web.dto.ResponseMembersPaging;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

@SpringBootTest
class MemberRepositoryTest {

    @Autowired
    MemberRepository memberRepository;

    @BeforeEach
    public void before() {
        Member member = Member.builder()
                .name("이기영")
                .email("기영@naver.com")
                .address(Address.builder()
                        .city("서울")
                        .street("어딘가")
                        .zipcode("삽니다")
                        .build())
                .build();

        Member member1 = Member.builder()
                .name("이기철")
                .email("기영1@naver.com")
                .address(Address.builder()
                        .city("서울")
                        .street("어딘가")
                        .zipcode("삽니다")
                        .build())
                .build();

        Member member2 = Member.builder()
                .name("스폰지밥")
                .email("기영2@naver.com")
                .address(Address.builder()
                        .city("서울")
                        .street("어딘가")
                        .zipcode("삽니다")
                        .build())
                .build();

        Member member3 = Member.builder()
                .name("이기영")
                .email("기영3@naver.com")
                .address(Address.builder()
                        .city("서울")
                        .street("어딘가")
                        .zipcode("삽니다")
                        .build())
                .build();

        memberRepository.saveAll(List.of(member, member1, member2, member3));
    }

    @Test
    @DisplayName("쿼리 메서드 테스트")
    void MemberRepositoryTest() {
        Page<Member> page = memberRepository
                .findAllByNameContaining("스", Pageable.ofSize(6));

        ResponseMembersPaging responseMembersPaging = new ResponseMembersPaging(page);

        List<ResponseMemberSaveDto> members = responseMembersPaging.getMembers();

        for (ResponseMemberSaveDto member : members) {
            System.out.println(member.toString());
        }
    }

}