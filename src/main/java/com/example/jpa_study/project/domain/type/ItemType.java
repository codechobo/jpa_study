package com.example.jpa_study.project.domain.type;

import com.example.jpa_study.project.error.ErrorCode;
import com.example.jpa_study.project.error.exception.NotFoundItemTypeException;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum ItemType {

    BOOK("book"),
    ALBUM("album"),
    MOVIE("movie");

    private final String typeName;

    public static boolean typeCheck(String typeName) {
        for (ItemType itemType : ItemType.values()) {
            if (itemType.getTypeName().equalsIgnoreCase(typeName)) {
                return true;
            }
        }
        throw new NotFoundItemTypeException(ErrorCode.NOT_FOUND_ITEM_TYPE);
    }

}
