package com.coffeeshop.GUI;

import com.coffeeshop.Controller.LoginController;

import java.io.IOException;

public class LoginGUI {
   LoginController lc;

    // User is on the main page
    //They click on the Login tab in from the main page
    //When they click this button, the LoginGUI is created

    public LoginGUI() throws IOException {
       // System.out.println("New LoginController Created");
        LoginController lc = new LoginController();
        this.lc = lc;
    }




    //Once they do this, they click the button "Create"
    //This will call this function which passes on the info to the controller

    public String onLoginClicked(String password, String email) throws Exception {
       // System.out.println("Passing to LoginController with username and password");
        String message = lc.login(password,email);
        return message;
    }


}
