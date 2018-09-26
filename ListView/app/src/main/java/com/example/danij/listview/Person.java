package com.example.danij.listview;

import java.io.Serializable;

/**
 * Created by danij on 31-Aug-18.
 */

public class Person implements Serializable{
    private String name;
    private String sex;
    private String birthday;
    private String imageUrl;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public Person(String name, String sex, String birthday, String imageUrl) {
        this.name = name;
        this.sex = sex;
        this.birthday = birthday;
        this.imageUrl = imageUrl;
    }

    public Person() {
    }
}
