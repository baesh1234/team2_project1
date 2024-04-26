package com.team2_project1.project1.domain;

import jakarta.persistence.*;
public class Reservations {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String Android_num;
    private String ios_num;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAndroid_num() {
        return Android_num;
    }

    public void setAndroid_num(String android_num) {
        Android_num = android_num;
    }

    public String getIos_num() {
        return ios_num;
    }

    public void setIos_num(String ios_num) {
        this.ios_num = ios_num;
    }
}

