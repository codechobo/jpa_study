package com.example.jpa_study.project.error;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@RequiredArgsConstructor
public enum ErrorCode {

    // member
    NOT_FOUND_MEMBER_ENTITY(HttpStatus.NOT_FOUND, "존재하지 않는 회원입니다."),
    EXISTS_MEMBER_INFO(HttpStatus.BAD_REQUEST, "이미 존재하는 회원입니다."),

    // order
    NOT_FOUND_ORDER_ENTITY(HttpStatus.NOT_FOUND, "존재하지 않는 주문입니다."),
    CAN_NOT_CANCEL(HttpStatus.BAD_REQUEST, "배송 완료된 아이템은 취소할 수 없습니다."),


    // item
    NOT_ENOUGH_STOCK(HttpStatus.BAD_REQUEST, "재고가 충분하지 않습니다."),
    NOT_FOUND_ITEM_ENTITY(HttpStatus.NOT_FOUND, "존재하지 않는 아이템입니다."),
    EXISTS_ITEM_INFO(HttpStatus.BAD_REQUEST, "이미 존재하는 아이템입니다."),
    ITEM_SAVE_FAIL(HttpStatus.INTERNAL_SERVER_ERROR, "아이템 저장을 실패했습니다."),

    // item type
    NOT_FOUND_ITEM_TYPE(HttpStatus.BAD_REQUEST, "아이템 타입을 찾을 수 없습니다."),
    ITEM_INFO_BAD_REQUEST(HttpStatus.BAD_REQUEST, "아이템 속성이 잘못 요청되었습니다.");



    private final HttpStatus httpStatus;
    private final String message;
}
