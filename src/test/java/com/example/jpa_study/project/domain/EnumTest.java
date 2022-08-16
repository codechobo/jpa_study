package com.example.jpa_study.project.domain;

import com.example.jpa_study.project.domain.type.ItemType;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class EnumTest {

    @Test
    @DisplayName("")
    void EnumTest() {
        String typeName = ItemType.BOOK.getTypeName();
        System.out.println(typeName);
    }
}
