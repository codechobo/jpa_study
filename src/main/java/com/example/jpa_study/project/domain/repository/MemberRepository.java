package com.example.jpa_study.project.domain.repository;

import com.example.jpa_study.project.domain.Member;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member, Long> {
    boolean existsByEmail(String email);
    Optional<Member> findByEmail(String email);
    Page<Member> findAllByNameContaining(String name, Pageable pageable);
}
