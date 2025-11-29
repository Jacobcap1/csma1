package GUI;

import Classes.Drink;
import Classes.DrinkFactory;
import Classes.DripCoffee;
import Controller.OrderController;

import java.io.IOException;

public class OrderGUI {
    private final OrderController oc;
   private final DrinkFactory df;

    public OrderGUI() throws IOException {
        OrderController oc = new OrderController();
        DrinkFactory df = new DrinkFactory();
        this.oc = oc;
        this.df= df;
    }

    //On the front end, User will click a drink and a size and hit "add to cart"
    
    //That will call this function which creates a Drink Object using drinkFactory and passes that drink and the size to OrderController addToCart Method
    
    public String onAddToCart(String drinkName, char size){
        System.out.println("Sending a Drink object to OrderController from the OrderGui Class via the addToCartMethod");
        return oc.addToCart(df.createDrink(drinkName,size));
    }

    //Once a cart has been created, the user can hit "order coffee"
    //This will pass the Cart Object to the OrderController PlaceOrder method
    //This method will take the Cart and ask for the name for that order and pass the cart + name to the OrderQueue
    public String onOrderCoffee(Order o){
        System.out.println("Calling the OrderController PlaceOrder Method from the OrderGui Class");
        return oc.placeOrder(o);
    }
    public String onOrderCompleted(){
        System.out.println("Calling the OrderController orderHasBeenServed Method from the OrderGUI class");
        return oc.orderHasBeenServed();
    }
}
