package com.coffeeshop.Classes;

import java.util.ArrayList;
import java.util.List;

public class Cart {
    List<Drink> cart;
private static final Cart instance = new Cart();

    private Cart()
    {
        System.out.println("New arraylist initialized in the Cart class constructor");
        cart = new ArrayList<>();
    }
    public static Cart getInstance() {
        return instance;
    }
    //returns a list of drinknames that are in cart
    public List<Drink> getCart(){
        List <Drink> items = new ArrayList<Drink>();
        for (Drink drink : cart) {
            assert false;
            items.add(drink);
        }
        return items;
    }
    public double getCartPrice(){
        double total =0.0;
        for (Drink drink : cart) {
            total = total + drink.getPrice();
        }
        return total;
    }

    public String addToCart(Drink d){
       // System.out.println("Drink added to cart arraylist in the cart class");
        cart.add(d);
        return "Added to Cart";
    };
    public void viewCart(){
        double total = 0.0;
        for (Drink drink : cart) {
            //System.out.println("+ " + drink.getName() + ", " + drink.getSize() + ", " + "$" + drink.getPrice() + " + ");
            total = total + drink.getPrice();
           // System.out.println("+ ------------------ +");
        }

       // System.out.println("+ ======="+ " $" +total + " +");
       // System.out.println("++++++++++++++++++++++");
       // System.out.println();
    }

    /*public String removeFromCart(Drink d){
        cart.remove(d);
        return "Removed From Cart";
    };*/

}
