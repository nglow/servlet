package com.example.servlet.basic;

import lombok.Getter;

@Getter
public class HelloData {

    private String username;

    private int age;

    public void setData(String username, int age) {
        this.username = username;
        this.age = age;
    }
}
