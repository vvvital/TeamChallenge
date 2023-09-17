package com.vvvital.teamchallenge.entity;

public enum Location {
    KYIV ("Київ"),
    ODESSA ("Одесса"),
    DNIPRO ("Дніпро"),
    LVIV ("Львів");

    private final String displayLocation;

    Location(String displayLocation) {
        this.displayLocation = displayLocation;
    }

    @Override
    public String toString() {
        return displayLocation;
    }

//    public static Location strToLocation(String string){
//        return switch (string){
//            case ("Київ")-> KYIV;
//            case ("Одесса")-> ODESSA;
//            case ("Дніпро")-> DNIPRO;
//            case ("Львів")-> LVIV;
//            default -> throw new IllegalStateException("Unexpected value: " + string);
//        };
//    }
}
