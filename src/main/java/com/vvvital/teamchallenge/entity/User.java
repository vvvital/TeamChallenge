package com.vvvital.teamchallenge.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

import java.util.List;

@Entity
public class User {

    @Id
    private Integer id;
    @Email
    @NotBlank
    private String email;
    @NotBlank
    private String name;
    private String surName;
    private String phone;
    @NotBlank
    private String password;
    @Enumerated
    private Role role;
    @Enumerated
    private List<Categories> categories;

    public User(String mail, String name, String surname, String phone, String password) {
        this.email = mail;
        this.name = name;
        this.surName = surname;
        this.phone = phone;
        this.password = password;
    }

    public User() {

    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", name='" + name + '\'' +
                ", surName='" + surName + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }

    //****GETTERS*****
    public Integer getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getName() {
        return name;
    }

    public String getSurName() {
        return surName;
    }

    public String getPhone() {
        return phone;
    }

    public String getPassword() {
        return password;
    }

    public Role getRole() {
        return role;
    }

    public List<Categories> getCategories() {
        return categories;
    }

    //********SETTERS*************
    public void setId(Integer id) {
        this.id = id;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurName(String surName) {
        this.surName = surName;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public void setCategories(Categories ... categories) {
        this.categories.addAll(List.of(categories));
    }
}
