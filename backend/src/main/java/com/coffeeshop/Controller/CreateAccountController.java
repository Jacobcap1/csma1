package com.coffeeshop.Controller;

import com.coffeeshop.Database.*;

import java.io.IOException;

public class CreateAccountController {
    DBMGR dbmgr;
    private String password, email;//,fName, lName;

    public CreateAccountController() throws IOException {
        System.out.println("New DBMGR object created");
        DBMGR dbmgr = new DBMGR();
        this.dbmgr = dbmgr;
    }
    public String createAccount(String password, String email /*String fName, String lName*/) throws Exception {
        this.password = password;
        this.email = email;
        // this.fName = fName;
        // this.lName =lName;

        System.out.println("Calling db to see if user exists");
        if (!dbmgr.emailExists(email)){//This means that the account has been made
           // System.out.println(dbmgr.emailExists(email));
            return "Account Already Created"; //If this happens, pass to LoginGUI
        } else
            return dbmgr.storeAccountInDB(password,email);
    }
}
