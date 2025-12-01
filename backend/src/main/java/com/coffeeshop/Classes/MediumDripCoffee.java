package com.coffeeshop.Classes;

public class MediumDripCoffee implements Drink{
    //PULL THESE FROM DATABASE AFTER IMPLEMENTATION
    public static String description;
    public static String name;
    public static double price;
    public static String size;

    public MediumDripCoffee(){
   this.description = "Plain ol' Black Coffee";
   this.name = "Medium Drip Coffee";
    this.price = 4.0;
   this.size = "medium";
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
