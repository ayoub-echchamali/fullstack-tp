package fr.polytech.backend.entity.enums;

import lombok.Getter;

import java.util.Arrays;

public enum Tag {
    GASTRONOMIQUE("Gastronomique", 1),
    BISTROT("Bistrot", 2),
    BISTRONOMIQUE("Bistronomique", 3),
    BRASSERIE("Brasserie", 4),
    FASTFOOD("Fastfood", 5);

    private final String value;
    @Getter
    private final int code;

    Tag(String value, int code) {
        this.value = value;
        this.code = code;
    }

    public static Tag findByCode(int code) throws Exception {
        return Arrays.stream(values()).filter(tag -> tag.getCode() == code).findFirst().orElseThrow();
    }

    public static boolean codeExists(int code) {
        return Arrays.stream(values()).anyMatch(tag -> tag.getCode() == code);
    }


}
