package com.android.myfirstandroidapplication.activity_sample;

public class Fruit {
    private String name;
    private String color;
    private String urlPicture;

    public Fruit(String name, String color) {
        this.name = name;
        this.color = color;
    }

    public Fruit(String name, String color, String urlPicture) {
        this.name = name;
        this.color = color;
        this.urlPicture = urlPicture;
    }

    public String getName() {
        return name;
    }

    public String getColor() {
        return color;
    }

    public String getUrlPicture() {
        return urlPicture;
    }
}
