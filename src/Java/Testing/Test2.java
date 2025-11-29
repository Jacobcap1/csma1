package Testing;

import GUI.OrderGUI;

import java.util.Scanner;

public class Test2 {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        OrderGUI og = new OrderGUI();
        OrderGUI og1 = new OrderGUI();
        OrderGUI og2 = new OrderGUI();


        og.onAddToCart("Drip Coffee", 's');
        og.onAddToCart("Latte", 'm');
        og.onAddToCart("Drip Coffee", 'l');
        og.onOrderCoffee();

        og1.onAddToCart("Latte", 's');
        og1.onAddToCart("Latte", 'm');
        og1.onAddToCart("Drip Coffee", 'l');
        og1.onOrderCoffee();

        og2.onAddToCart("Latte", 's');
        og2.onAddToCart("Latte", 'm');
        og2.onAddToCart("Latte", 'l');
        og2.onOrderCoffee();




        og.onOrderCompleted();
        og1.onOrderCompleted();
        og2.onOrderCompleted();


    }
}
