package com.coffeeshop.GUI;

import com.coffeeshop.Classes.Admin;

public class AdminGUI {
    Admin a;
    public AdminGUI(Admin a){this.a=a;};

    public void viewPreorderQueue(){
        a.viewPreorderQueue();
    }
}
