package com.coffeeshop.Connector;
import com.coffeeshop.DTO.*;

import com.coffeeshop.GUI.*;   



import org.springframework.web.bind.annotation.*;


import java.io.IOException;
import org.springframework.web.bind.annotation.CrossOrigin;


@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/auth")

public class AuthController {

    private final LoginGUI loginGUI = new LoginGUI();
    private final CreateAccountGUI cag = new CreateAccountGUI();

    public AuthController() throws IOException {};

    @PostMapping("/login")
    public String login(@RequestBody LoginData data) throws Exception {
        return loginGUI.onLoginClicked(data.getPassword(), data.getEmail());
    }
    @PostMapping("/register")
    public String createAccount(@RequestBody RegisterData data) throws Exception {
        return cag.onCreateAccountClicked(data.getPassword(), data.getEmail());//, data.getfName(),data.getlName());
    }
}
