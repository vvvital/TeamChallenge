package com.vvvital.teamchallenge.entity;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public enum Categories {

    CLINICAL_PSYCHOLOGIST("Клінічний психолог"),
    CHILD_PSYCHOLOGIST("Дитячий психолог"),
    FAMILY_PSYCHOLOGIST("Сімейний психолог"),
    ORGANIZATIONAL_PSYCHOLOGIST("Організаційний психолог"),
    PSYCHOTHERAPIST("Психотерапевт"),
    PSYCHOLOGIST_ON_ADDICTION_PROBLEMS("Психолог з проблем залежностей"),
    SCHOOL_PSYCHOLOGIST("Шкільний психолог"),
    PSYCHOLOGIST_FOR_TEENAGERS("Психолог для підлітків"),
    PSYCHOLOGIST_FOR_AGER("Психолог для старшої вікової категорії"),
    SPORTS_PSYCHOLOGIST("Спортивний психолог"),
    PSYCHOLOGIST_SEXOLOGIST("Психолог-сексолог"),
    GROUP_THERAPY("Групова терапія"),
    ONLINE_CONSULTATION("Онлайн консультації"),
    RECOMMENDED_PSYCHOLOGIST("Рекомендовані психологи"),
    HAVE_ARTICLES("Мають статті"),
    PSYCHOLOGIST_CLOSE("Психологи поруч зі мною");

    private String displayCategories;

    Categories(String displayCategories) {
        this.displayCategories = displayCategories;
    }

    @Override
    public String toString() {
        return displayCategories;
    }

    public static Set<Categories> arrToSet(String[] categories) {
        return Arrays.stream(categories).map(Categories::strToEnum).collect(Collectors.toSet());
    }

    public static Categories strToEnum(String string) {
        return switch (string) {
            case ("Клінічний психолог") -> CLINICAL_PSYCHOLOGIST;
            case ("Дитячий психолог") -> CHILD_PSYCHOLOGIST;
            case ("Сімейний психолог") -> FAMILY_PSYCHOLOGIST;
            case ("Організаційний психолог") -> ORGANIZATIONAL_PSYCHOLOGIST;
            case ("Психотерапевт") -> PSYCHOTHERAPIST;
            case ("Психолог з проблем залежностей") -> PSYCHOLOGIST_ON_ADDICTION_PROBLEMS;
            case ("Шкільний психолог") -> SCHOOL_PSYCHOLOGIST;
            case ("Психолог для підлітків") -> PSYCHOLOGIST_FOR_TEENAGERS;
            case ("Психолог для старшої вікової категорії") -> PSYCHOLOGIST_FOR_AGER;
            case ("Спортивний психолог") -> SPORTS_PSYCHOLOGIST;
            case ("Психолог-сексолог") -> PSYCHOLOGIST_SEXOLOGIST;
            case ("Групова терапія") -> GROUP_THERAPY;
            case ("Онлайн консультації") -> ONLINE_CONSULTATION;
            case ("Рекомендовані психологи") -> RECOMMENDED_PSYCHOLOGIST;
            case ("Мають статті") -> HAVE_ARTICLES;
            case ("Психологи поруч зі мною") -> PSYCHOLOGIST_CLOSE;

            default -> throw new IllegalStateException("Unexpected value: " + string);
        };
    }
}
