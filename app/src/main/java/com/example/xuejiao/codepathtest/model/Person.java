package com.example.xuejiao.codepathtest.model;

/**
 * Created by xuejiao on 15/10/13.
 */
public class Person {
    private String name;
    private String city;
    public Person(String name, String city) {
        this.name = name;
        this.city = city;
    }
    public Person() {
        this("none","none");
    }

    public String getName() {
        return name;
    }

    public String getCity() {
        return city;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
