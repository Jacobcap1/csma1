package com.coffeeshop.Classes;

public class SmallDripCoffee implements Drink{
    //PULL THESE FROM DATABASE AFTER IMPLEMENTATION
    public static String description;
    public static String name;
    public static double price;
    public static String size;

    public static points = 10;

    public SmallDripCoffee(){
   this.description = "Plain ol' Black Coffee";
   this.name = "Small Drip Coffee";
    this.price = 3.0;
   this.size = "small";
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
