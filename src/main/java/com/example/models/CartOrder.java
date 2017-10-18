package com.example.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class CartOrder {
    @Id
    @GeneratedValue
    Integer id;

    @ManyToOne
    Item item;

    Integer quantity;

    public CartOrder() {}

    public CartOrder(Item item, Integer quantity) {
        this.item = item;
        this.quantity = quantity;
    }

    public Integer getId() {
        return id;
    }

    public String getDescription() {
        return item.description;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return quantity * item.price;
    }

    public double getShippingCost() {
        return quantity * 5 * item.getWeightFactor();
    }

}
