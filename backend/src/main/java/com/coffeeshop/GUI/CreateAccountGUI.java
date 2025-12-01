package com.coffeeshop.GUI;

import com.coffeeshop.Controller.CreateAccountController;

import java.io.IOException;

public class CreateAccountGUI {
    CreateAccountController cac;

    // User is on the main page
    //They click on the Create Account tab in from the main page
    //When they click this button, the CreateAccountGui is created

    public CreateAccountGUI() throws IOException {
        //System.out.println("New CreateAccountController Created");
        CreateAccountController cac =
        new CreateAccountController();
        this.cac = cac;
    }
    //Once they do this, they click the button "Create"
    //This will call this function which passes on the info to the controller

   public String onCreateAccountClicked(String password, String email) throws Exception {
      // System.out.println("Passing to CreateAccountController with username and password");
       String message = cac.createAccount(password,email);
       return message;
   }


}
