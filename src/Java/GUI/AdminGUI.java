package GUI;

import Classes.Admin;

public class AdminGUI {
    Admin a;
    public AdminGUI(Admin a){this.a=a;};

    public void viewPreorderQueue(){
        a.viewPreorderQueue();
    }
}
