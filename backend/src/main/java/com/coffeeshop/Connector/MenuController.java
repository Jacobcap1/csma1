package com.coffeeshop.Connector;

import com.coffeeshop.Classes.*;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")

public class MenuController {
    private final DrinkFactory df = new DrinkFactory();
    
    @GetMapping("/menu")
    public List<Drink> getMenu(){
    DrinkFactory df = new DrinkFactory();
    return df.getAllDrinks();
    }

}
