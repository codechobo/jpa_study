package com.example.jpa_study.project.web;

import com.example.jpa_study.project.service.MemberService;
import com.example.jpa_study.project.web.dto.*;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/members")
@RequiredArgsConstructor
public class MemberAccountController {

    private final MemberService memberService;

    @PostMapping("/sign-up")
    public ResponseEntity<ResponseMemberSaveDto> signUp(
            @Valid @RequestBody RequestMemberSaveDto requestMemberSaveDto) {
        ResponseMemberSaveDto memberSaveResponseDto = memberService.signUp(requestMemberSaveDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(memberSaveResponseDto);
    }

    @GetMapping("/{email}")
    public ResponseEntity<ResponseMemberSaveDto> memberDetailInfo(
            @PathVariable("email") String email) {
        ResponseMemberSaveDto memberInfo = memberService.getMember(email);
        return ResponseEntity.status(HttpStatus.OK).body(memberInfo);
    }

    @PutMapping("/{email}")
    public ResponseEntity<Long> updateAddressInfo(
            @PathVariable("email") String email,
            @Valid @RequestBody RequestMemberUpdateDto requestMemberUpdateDto) {
        Long updateId = memberService.updateMember(email, requestMemberUpdateDto);
        return ResponseEntity.status(HttpStatus.OK).body(updateId);
    }

    @DeleteMapping("/{email}")
    public ResponseEntity<Long> deleteMemberInfo(
            @PathVariable("email") String email) {
        Long deleteId = memberService.deleteMember(email);
        return ResponseEntity.status(HttpStatus.OK).body(deleteId);
    }
}
