
package Testing;

import java.util.Scanner;

import Classes.Admin;
import Classes.DrinkFactory;
import Controller.OrderController;
import GUI.CreateAccountGUI;
import GUI.LoginGUI;
import GUI.OrderGUI;
import java.util.Scanner;
public class Test4 {
    public static void main(String[] args) throws Exception {

        //First, create account
       /* CreateAccountGUI cag = new CreateAccountGUI();
        cag.onCreateAccountClicked("123","Account1","Fred","Harrison");

        CreateAccountGUI cag2 = new CreateAccountGUI();
        cag2.onCreateAccountClicked("12322","Account2","Fred2", "Harrison2");
*/
        //Next Login to that new Account
        LoginGUI lg = new LoginGUI();
        lg.onLoginClicked("123","Account1");

        //Next, pick 4 drinks to add to cart
        OrderController oc = new OrderController();
        DrinkFactory df = new DrinkFactory();
        oc.addToCart(df.createDrink("Drip Coffee", 's'));
        oc.addToCart(df.createDrink("Latte",'m'));
        oc.addToCart(df.createDrink("Latte",'l'));
        oc.addToCart(df.createDrink("Drip Coffee",'l'));

        //User then views cart
        oc.viewCart();

        //User then wants to buy his cart
        oc.placeOrder();

        System.out.println("ADMIN VIEWS |||||||||||||||||||||||");
        Admin a = new Admin();
        a.viewPreorderQueue(a);
        System.out.println("ADMIN VIEWS ^^^^^^^^^^^^^^^^^");
        //User then goes to store and picks up his order
        oc.orderHasBeenServed();









    }
}
