package com.example.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Item {

    @Id
    @GeneratedValue
    Integer id;

    String description;
    double weightFactor;
    double price;
    String image;

    public Item() {}

    public Item(String description, double weightFactor, double price, String image) {
        this.description = description;
        this.weightFactor = weightFactor;
        this.price = price;
        this.image = image;
    }

    public Integer getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public double getWeightFactor() {
        return weightFactor;
    }

    public double getPrice() {
        return price;
    }

    public String getImage() { 
        return image; 
    }
}
