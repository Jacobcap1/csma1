package com.coffeeshop.DTO;

public class RegisterData {
    private String password;
    private String email;
    // private String fName;
    // private String lName;

    RegisterData(String password, String email) {
        this.email = email;
        this.password = email;
        // this.fName = fName;
        // this.lName = lName;
    }
    public String getEmail(){
        return email;
    }

    public String getPassword() {
        return password;
    }

    // public String getfName() {
    //     return fName;
    // }

    // public String getlName() {
    //     return lName;
    // }
}
