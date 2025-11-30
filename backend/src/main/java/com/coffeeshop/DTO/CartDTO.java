package com.coffeeshop.DTO;

import java.util.List;


public class CartDTO {
    private List<DrinkDTO> items;
    private double totalPrice;

    public CartDTO() {} // default constructor for JSON deserialization

    public CartDTO(List<DrinkDTO> items, double totalPrice) {
        this.items = items;
        this.totalPrice = totalPrice;
    }

    // Getters and setters
    public List<DrinkDTO> getItems() { return items; }
    public void setItems(List<DrinkDTO> items) { this.items = items; }

    public double getTotalPrice() { return totalPrice; }
    public void setTotalPrice(double totalPrice) { this.totalPrice = totalPrice; }
}
