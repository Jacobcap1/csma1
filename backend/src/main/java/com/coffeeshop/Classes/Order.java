package com.coffeeshop.Classes;

import java.util.List;

public class Order {
    Cart c;
    String name;
    String number;
    String ccNumber;
    String cvc;
    String expDate;
   

    //When this class is instantiated, it will be created with a Cart and a name
    //This can be called as many times from different places as we like so their can be multiple Orders at a time
    public Order(Cart c, String name, String number, String ccNumber, String cvc, String expDate) {
        this.c = c;
        this.name = name;
        this.number = number;
        this.ccNumber = ccNumber;
        this.cvc = cvc;
        this.expDate=expDate;
    }

    public String getName(){
        return name;
    }
    public List<Drink> getItems(){
        return c.getCart();
    }
    public double getPrice(){
        return c.getCartPrice();
    }
    public String getNumber(){return number;}
    public String getCCNumber(){return ccNumber;}
    public String getCVC(){return cvc;}
    public String getExpDate(){return expDate;}

    

    //When this method is called it will create an instance of the OrderQueue class (singleton)
    //it will add the order Object to the queue
    public String addToQueue(Order o) {
        OrderQueue oq = OrderQueue.getInstance();
       // System.out.println("The order has been added to the queue");
        return (oq.addToOrderQueue(o));
    }
    public String removeFromQueue(Order o){
        OrderQueue oq = OrderQueue.getInstance();
       // System.out.println("Order has been paid for and delivered to customer---deleting order from queue");
        return (oq.removeFromOrderQueue(o));
    }
    //The method calls the viewCart from Cart class, which iterates through the Cart Array and lists the coffee and size of the item
    //It also lists the name of the person ordering the Order
    public void viewCart(){
        System.out.println("|"+name +"|");
        System.out.println("|"+number+"|");
        System.out.println("+++++++++++++++++++++++");
        c.viewCart();
    }



}
