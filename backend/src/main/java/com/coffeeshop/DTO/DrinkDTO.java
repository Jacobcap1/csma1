package com.coffeeshop.DTO;

public class DrinkDTO {
private String name;
private double price;
private String description;
private char size;

public DrinkDTO(){};

public DrinkDTO(String name, char size, double price, String description){
    this.name = name;
    this.price=price;
    this.description = description;
    this.size = size;
}
public String getName(){
    return name;
}
public double getPrice(){
    return price;}

public char getSize(){
    return size;
}
public String getDescription(){
    return description;
}

}
