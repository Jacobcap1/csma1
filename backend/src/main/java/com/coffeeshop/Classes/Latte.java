package com.coffeeshop.Classes;




public class Latte implements Drink{
    //PULL THESE FROM DATABASE AFTER IMPLEMENTATION
    public static  String description;
    public static  String name;
    public static double price;
    public static String size;

    public static int points = 40;

    public Latte(char size){
        this.description = "Nice and Frothy";
        this.name = "Latte";

        this.size = "Large";
    }
    @Override
    public String getDescription(){
        return description;
    }
    @Override
    public String getName(){
        return name;
    }
    @Override

    public String getSize(){
        return size;
    }
    @Override

    public double getPrice() {
        return price;
    }

    public int getPoints(){
        return points;
    }

    public void updatePrice(Admin a, double newPrice){
        price = newPrice;
    }

}
