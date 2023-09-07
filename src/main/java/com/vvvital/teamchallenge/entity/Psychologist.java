package com.vvvital.teamchallenge.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

import java.util.Set;

@Entity
public class Psychologist {

    @Id
    private Integer id;
    @NotBlank
    private String name;
    @NotBlank
    private String surName;
    @Email
    private String email;
    @NotBlank
    private String password;
    @NotBlank
    private String phone;
    private Integer price;
    private String location;
    private Boolean online;
    private Boolean offline;
    private Integer experience;
    private Integer rating;
    private String description;
    @Enumerated
    private Set<Categories> categories;
    private String photoLink;

    public Psychologist(String name, String surName, String email, String password, String phone,
                        Integer price, String location, Boolean online, Boolean offline,
                        Integer experience, String description, String photoLink) {
        this.name = name;
        this.surName = surName;
        this.email = email;
        this.password=password;
        this.phone = phone;
        this.price = price;
        this.location = location;
        this.online = online;
        this.offline = offline;
        this.experience = experience;
        this.description = description;
        this.photoLink = photoLink;
    }

    public Psychologist(){}

    //<-----getters----->
    public Integer getId() {
        return id;
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

    public String getPassword() {
        return password;
    }

    public String getPhone() {
        return phone;
    }

    public Integer getRating() {
        return rating;
    }

    public String getDescription() {
        return description;
    }

    public Set<Categories> getCategories() {
        return categories;
    }

    public String getPhotoLink() {
        return photoLink;
    }

    public Integer getPrice() {
        return price;
    }

    public String getLocation() {
        return location;
    }

    public Boolean getOnline() {
        return online;
    }

    public Boolean getOffline() {
        return offline;
    }

    public Integer getExperience() {
        return experience;
    }
    //<-----setters----->

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurName(String surName) {
        this.surName = surName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setCategories(Set<Categories> categories) {
        this.categories = categories;
    }

    public void setPhotoLink(String photoLink) {
        this.photoLink = photoLink;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setOnline(Boolean online) {
        this.online = online;
    }

    public void setOffline(Boolean offline) {
        this.offline = offline;
    }

    public void setExperience(Integer experience) {
        this.experience = experience;
    }
}
