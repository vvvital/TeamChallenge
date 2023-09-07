package com.vvvital.teamchallenge.entity;

public enum Role {
    USER,
    PSYCHOLOGIST,
    ADMIN;

    public static Role stringToRole(String roleIn) {
        roleIn=roleIn.toUpperCase().trim();
        return switch (roleIn) {
            case ("USER") -> USER;
            case ("PSYCHOLOGIST") -> PSYCHOLOGIST;
            case ("ADMIN") -> ADMIN;
            default -> null;
        };
    }
}
