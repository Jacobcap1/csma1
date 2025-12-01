package com.coffeeshop.Classes;

public class LargeDripCoffee implements Drink{
    //PULL THESE FROM DATABASE AFTER IMPLEMENTATION
    public static String description;
    public static String name;
    public static double price;
    public static String size;

    public LargeDripCoffee(){
   this.description = "Plain ol' Black Coffee";
   this.name = "Large Drip Coffee";
    this.price = 5.0;
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

    public void updatePrice(Admin a, double newPrice){
        price = newPrice;
    }

}
