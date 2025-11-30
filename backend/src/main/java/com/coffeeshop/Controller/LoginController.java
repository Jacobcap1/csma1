package com.coffeeshop.Controller;

import com.coffeeshop.Classes.Admin;
import com.coffeeshop.Database.DBMGR;
import com.coffeeshop.GUI.AdminGUI;

import java.io.IOException;
import java.util.Objects;

public class LoginController {
    DBMGR dbmgr;
    private String password, email;

    public LoginController() throws IOException {
        System.out.println("New DBMGR object created");
        this.dbmgr = new DBMGR();
    }
    public String login(String password, String email) throws Exception {
        this.password = password;
        this.email = email;

        System.out.println("Calling db to see if user exists/ password is correct");
        if(Objects.equals(email, "Admin") && Objects.equals(password, "IAmTheAdmin")){
            Admin a = new Admin();
            AdminGUI ag = new AdminGUI(a);
            return "Welcome Admin: You can now view the OrderQueue";
        }
        else if (Objects.equals(dbmgr.verifyUser(email, password), "Correct Password")){//This means that the account has been made
           // System.out.println("Hooray");
            return "Logged in and Account Object created"; //If this happens, pass to LoginGUI
        } else
            return "Invalid input either username or password is wrong";
    }
}


