package Testing;

import java.util.Scanner;

import GUI.LoginGUI;
import GUI.OrderGUI;
import java.util.Scanner;
public class Test3 {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        LoginGUI lg = new LoginGUI();

        lg.onLoginClicked("2332","jjj");
        lg.onLoginClicked("1","AaronCapone@gmail.com");

    }
}
