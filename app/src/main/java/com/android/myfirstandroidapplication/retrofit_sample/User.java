package com.android.myfirstandroidapplication.retrofit_sample;

import com.google.gson.annotations.SerializedName;

public class User {
    @SerializedName("login")
    private String name;

    public User(String name) {
        this.name = name;
    }

    public String getUser() {
        return name;
    }

    public void setUser(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                '}';
    }
}