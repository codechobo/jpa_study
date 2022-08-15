package com.example.jpa_study.project.web;

import com.example.jpa_study.project.service.MemberService;
import com.example.jpa_study.project.web.dto.ResponseMemberSaveDto;
import com.example.jpa_study.project.web.dto.ResponseMembersPaging;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin/members")
@RequiredArgsConstructor
public class MemberAdminController {

    private final MemberService memberService;

    @GetMapping("/{email}")
    public ResponseEntity<ResponseMemberSaveDto> getMemberInfo(
            @PathVariable String email) {
        ResponseMemberSaveDto responseMemberSaveDto = memberService.getMember(email);
        return ResponseEntity.status(HttpStatus.OK).body(responseMemberSaveDto);
    }

    @GetMapping
    public ResponseEntity<ResponseMembersPaging> getMemberList(
            @RequestParam(required = false) String name,
            @PageableDefault(size = 5, sort = "name") Pageable pageable) {
        ResponseMembersPaging responseMembersPaging = memberService.getMembers(name, pageable);
        return ResponseEntity.status(HttpStatus.OK).body(responseMembersPaging);
    }
}
