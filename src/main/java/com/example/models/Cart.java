package com.example.models;

import java.util.List;

public class Cart {
    List<CartOrder> orders;

    double totalPrice;
    boolean discountEligible;


    private double calculateTotalPrice() {
        double total = 0;
        double shipping = 0;

        for (CartOrder order : orders) {
            total += order.getPrice();
            shipping += order.getShippingCost();
        }
        return total + shipping;
    }


    public Cart(List<CartOrder> orders) {
        this.orders = orders;
        double initialPrice = calculateTotalPrice();

        if (initialPrice > 100) {
            totalPrice = 0.9 * initialPrice;
            discountEligible = true;
        } else {
            totalPrice = initialPrice;
            discountEligible = false;
        }
    }

    public List<CartOrder> getOrders() {
        return orders;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public boolean isDiscountEligible() {
        return discountEligible;
    }
}
