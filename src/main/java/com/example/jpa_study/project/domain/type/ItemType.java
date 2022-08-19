package com.example.jpa_study.project.domain.type;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.Arrays;

@Getter
@RequiredArgsConstructor
public enum ItemType {

    BOOK("book"),
    ALBUM("album"),
    MOVIE("movie");

    private final String typeName;

    public static boolean typeCheck(String typeName) {
        return Arrays.stream(values())
                .anyMatch(itemType -> itemType.typeName.equals(typeName));
    }

}
