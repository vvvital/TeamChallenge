package com.vvvital.teamchallenge.entity;

import java.util.HashSet;
import java.util.Set;

public class PsychologistToSend {

    private final Integer id;
    private final String name;
    private final String surName;
    private final String email;
    //private String password;
    private final String phone;
    private final Integer price;
    private final String location;
    //private Boolean online;
    //private Boolean offline;
    private final Integer experience;
    private final Integer rating;
    private final String description;
    private final Set<String> categoriesSet=new HashSet<>();
    private final String photoLink;

    public Integer getId() {
        return id;
    }

    public PsychologistToSend(Integer id, String name, String surName, String email, String phone, Integer price,
                              String location, Integer experience,Integer rating, String description, String photoLink, Set<Categories> categories) {
        this.id = id;
        this.name = name;
        this.surName = surName;
        this.email = email;
        this.phone = phone;
        this.price = price;
        this.location = location;
        this.experience = experience;
        this.rating=rating;
        this.description = description;
        this.photoLink = photoLink;
        for (Categories c : categories
        ) {
            categoriesSet.add(c.toString());
        }
    }

    public String getName() {
        return name;
    }

    public String getSurName() {
        return surName;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public Integer getPrice() {
        return price;
    }

    public String getLocation() {
        return location;
    }

    public Integer getExperience() {
        return experience;
    }

    public Integer getRating() {
        return rating;
    }

    public String getDescription() {
        return description;
    }

    public Set<String> getCategories() {
        return categoriesSet;
    }

    public String getPhotoLink() {
        return photoLink;
    }

    @Override
    public String toString() {
        return "PsychologistToSend{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surName='" + surName + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", price=" + price +
                ", location='" + location + '\'' +
                ", experience=" + experience +
                ", rating=" + rating +
                ", description='" + description + '\'' +
                ", categories=" + categoriesSet +
                ", photoLink='" + photoLink + '\'' +
                '}';
    }
}
