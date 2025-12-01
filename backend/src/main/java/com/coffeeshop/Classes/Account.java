package com.coffeeshop.Classes;



public class Account {
    private String fName;
    private String lName;
    private String password;
    private double points;
    private String email;

    public Account(String fName, String lName, String password, double points, String email){
        this.email = email;
        this.points =  points;
        this.password = password;
        this.fName = fName;
        this.lName = lName;}
        //getAccountInfo();    }
    public double getPoints(){
        return points;
    }
   /* public void changePassword(String newPassword){
        this.password = newPassword;
    }*/
    public void getAccountInfo(){
        System.out.println("First Name : "+ fName);
        System.out.println("Last Name : "+ lName);
        System.out.println("Password : "+password);
        System.out.println("Email : "+ email);
        System.out.println("Points : "+ points);
    }

}
