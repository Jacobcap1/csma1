package com.coffeeshop.DTO;

public class LoginData {

    private String password;
    private String email;


    LoginData(String password, String email){
        this.email = email;
        this.password = email;

    }
    public String getEmail(){
        return email;
    }

    public String getPassword() {
        return password;
    }

}
