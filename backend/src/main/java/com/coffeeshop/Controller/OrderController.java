package com.coffeeshop.Controller;

import com.coffeeshop.Classes.Cart;
import com.coffeeshop.Classes.Drink;
import com.coffeeshop.Classes.Order;
import com.coffeeshop.Database.DBMGR;

import java.io.IOException;
import java.util.Scanner;

public class OrderController {
    Scanner s = new Scanner(System.in);
    Cart c;
    Order o;
    DBMGR dbmgr;
    //When this class is instantiated, a new Cart will be created.
    //This makes sense because every person will call OrderController once and use it to add to cart and Order Cart
    public OrderController() throws IOException { //throws IOException {
        Cart c = new Cart();
        DBMGR dbmgr = new DBMGR();
        this.dbmgr = dbmgr;
        this.c = c;};

    //This method takes in a Drink object and passes that drink to the Cart Class addToCart Method
    public String addToCart(Drink d) {
        //System.out.println("Drink object passed to Cart class from the OrderController class addToCart Method");
        return c.addToCart(d);
    }
    public void viewCart(){
        c.viewCart();
    }
    //This method takes in the Cart object from above and adds a name and passes both to create an Order object
    //This order object contains a Cart Object +  String name for the order
    //It will pass this order to the Order addToQueue method
    public String placeOrder(Order o) {
        this.o = o;
       // System.out.println("Order object (which contains a Drink object) sent to addToQueue method from OrderController class");
        return (o.addToQueue(o));
    }
    public String orderHasBeenServed(){
        if(o != null){
            dbmgr.storeOrderInDB(o);
            return(o.removeFromQueue(o));
        }
        else
            return "Oops, order hasn't been placed";

    }

}
