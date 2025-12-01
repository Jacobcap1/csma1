package com.coffeeshop.Classes;
import java.util.LinkedList;

import java.util.Queue;
public class OrderQueue {
    //This is a singleton class that holds Order objects
    private static OrderQueue oq = null;
    private static Queue<Order>queue;
    private OrderQueue(){
       // System.out.println("New LL created in OrderQueue class from constructor");
        queue = new LinkedList<>();
    }
    public static synchronized OrderQueue getInstance(){
        if(oq == null) {
            oq = new OrderQueue();}
        return oq;
    }
    public String addToOrderQueue(Order o){
       // System.out.println("Element added to queue");
        queue.add(o);
        for (Order i : queue){
            i.viewCart();
        }
        return "Added to Queue";
    }
    public String removeFromOrderQueue(Order o){
        //System.out.println("Element removed from queue");
        queue.remove(o);
       // System.out.println(queue.size());
        for (Order i : queue){
           // System.out.println("Unless it is empty");
            i.viewCart();
        }
        return "Order has been removed from queue";
    }
    public void viewQueue(){
        for (Order i : queue){
            //System.out.println("Unless it is empty");
            i.viewCart();}
    }
}
