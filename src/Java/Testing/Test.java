package Testing;

import Classes.DrinkFactory;
import GUI.CreateAccountGUI;
import GUI.OrderGUI;

import java.util.Scanner;

  public class Test {
      public static void main(String[] args) throws Exception {
          Scanner scanner = new Scanner(System.in);

          int input = 0;
          while (input != 10) {
              System.out.println("Pick options: ");
              System.out.println("Create Account (1)");
              System.out.println("View Coffee Items (2)");
              System.out.println("Exit = 10");

              input = Integer.parseInt(scanner.nextLine());
              //Create Account Option
              if (input == 1) {
                  CreateAccountGUI cac = new CreateAccountGUI();
                  System.out.println("Enter email: ");
                  String email = scanner.nextLine();

                  System.out.println("Enter password: ");
                  String password = scanner.nextLine();

                  System.out.println("Enter First Name: ");
                  String fName = scanner.nextLine();

                  System.out.println("Enter Last Name:");
                  String lName = scanner.nextLine();

                  System.out.println(cac.onCreateAccountClicked(password, email, fName, lName));

              }
              else if (input == 2) {
                  int loops = 1;
                  OrderGUI og = new OrderGUI();
                  DrinkFactory df = new DrinkFactory();

                  while (loops <= 2) {
                      System.out.println("Add Coffee To Cart: ");
                      df.displayDrinks();
                      input = scanner.nextInt();

                      if (input == 3) {
                          System.out.println("What size? s,m,l");
                          System.out.println("---");
                          og.onAddToCart("Drip Coffee", 's');
                          loops = loops + 1;
                      } else if (input == 4) {
                          System.out.println("What size? s,m,l");
                          System.out.println("---");
                          og.onAddToCart("Latte", 'm');
                          loops = loops + 1;
                      } else
                          System.out.println("Invalid entry");
                  }
                  System.out.println("Would you like to order yes (1) no (2)?");
                  int ans = scanner.nextInt();
                  if(ans == 1){
                      og.onOrderCoffee();
                      System.out.println("Order Completed");
                        //og.onOrderCompleted();
                  }
                  else
                      System.out.println("You suck");

                  }
            else
                  System.out.println("Invalid Entry");

              }
          }
      }





