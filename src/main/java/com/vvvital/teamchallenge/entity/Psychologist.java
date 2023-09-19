package com.vvvital.teamchallenge.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.springframework.data.relational.core.mapping.MappedCollection;

import java.util.Collections;
import java.util.HashSet;
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
    private Location location;
    private Boolean online;
    private Boolean offline;
    private Integer experience;
    private Integer rating;
    private String description;
    @Enumerated(EnumType.STRING)
    @CollectionTable(name = "psychologist_categories", joinColumns = @JoinColumn(name = "psychologist_id"),
            uniqueConstraints = {@UniqueConstraint(columnNames = {"psychologist_id", "categories"}, name = "psychologist_categories")})
    @Column(name = "categories")
    @ElementCollection(fetch = FetchType.EAGER)
    //    @Fetch(FetchMode.SUBSELECT)
    @JoinColumn
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Set<Categories> categories;
    private String photoLink;

    public Psychologist(String name, String surName, String email, String password, String phone,
                        Integer price, Location location, Boolean online, Boolean offline,
                        Integer experience, String description, String photoLink, Categories...categoriesArr) {
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
        categories=new HashSet<Categories>();
        Collections.addAll(categories,categoriesArr);
    }

    public Psychologist(String name, String surName, String email, String password, String phone) {
        this.name = name;
        this.surName = surName;
        this.email = email;
        this.password = password;
        this.phone = phone;
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

    public Location getLocation() {
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


    public void setCategories(Categories[] categoriesArr) {
        Collections.addAll(categories,categoriesArr);
    }
    public void setCategoriesSet(Set<Categories>categoriesSet){
        categories=categoriesSet;
    }

    public void setPhotoLink(String photoLink) {
        this.photoLink = photoLink;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public void setLocation(Location location) {
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

    @Override
    public String toString() {
        return "Psychologist{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surName='" + surName + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", phone='" + phone + '\'' +
                ", price=" + price +
                ", location='" + location + '\'' +
                ", online=" + online +
                ", offline=" + offline +
                ", experience=" + experience +
                ", rating=" + rating +
                ", description='" + description + '\'' +
                ", categories=" + categories +
                ", photoLink='" + photoLink + '\'' +
                '}';
    }
}
