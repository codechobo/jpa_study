package com.example.jpa_study.project.domain.repository;

import com.example.jpa_study.project.domain.Member;
import com.example.jpa_study.project.domain.type.Address;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;


@SpringBootTest
class MemberRepositoryImplTest {

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
                        .zipcode("삽니다.")
                        .build())
                .build();

        Member member1 = Member.builder()
                .name("이기철")
                .email("기영1@naver.com")
                .address(Address.builder()
                        .city("서울")
                        .street("어딘가")
                        .zipcode("삽니다.")
                        .build())
                .build();

        memberRepository.saveAll(List.of(member, member1));
    }

    @Test
    @DisplayName("")
    void MemberRepositoryImplTest() {
    }

}