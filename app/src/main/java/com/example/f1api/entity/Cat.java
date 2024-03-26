package com.example.f1api.entity;

import androidx.room.Entity;
import androidx.room.PrimaryKey;


@Entity(tableName = "cat")
public class Cat {
    @PrimaryKey
    private Long id;
    private String breed;
    private String country;
    private String origin;
    private String coat;
    private String pattern;

    public Cat(Long id, String breed, String country, String origin, String coat, String pattern) {
        this.id = id;
        this.breed = breed;
        this.country = country;
        this.origin = origin;
        this.coat = coat;
        this.pattern = pattern;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getCoat() {
        return coat;
    }

    public void setCoat(String coat) {
        this.coat = coat;
    }

    public String getPattern() {
        return pattern;
    }

    public void setPattern(String pattern) {
        this.pattern = pattern;
    }

    @Override
    public String toString() {
        return "Cat{" +
                "id=" + id+
                ", breed='" + breed + '\'' +
                ", country='" + country + '\'' +
                ", origin='" + origin + '\'' +
                ", coat='" + coat + '\'' +
                ", pattern='" + pattern + '\'' +
                '}';
    }




}
