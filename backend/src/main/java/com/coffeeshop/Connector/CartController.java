package com.coffeeshop.Connector;

import com.coffeeshop.GUI.*;   
import com.coffeeshop.Classes.*;
import com.coffeeshop.DTO.*;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;

import java.util.stream.Collectors;

import java.util.List;
@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/cart ")

public class CartController {

private final OrderGUI og;
private final Cart cart;

public CartController(){
    Cart tempCart;
    OrderGUI tempOG;
    try{
        tempCart = new Cart();
    } catch (Exception e){
        e.printStackTrace();
        tempCart = null;
    }
    try{
        tempOG = new OrderGUI();
    } catch (Exception e){
        e.printStackTrace();  
        tempOG = null;
    }
    this.og = tempOG;
    this.cart = tempCart;
}
@GetMapping
    public CartDTO getCart() {
        List<DrinkDTO> items = cart.getCart().stream()
            .map(d -> new DrinkDTO(d.getName(), d.getSize(), d.getPrice(), d.getDescription()))
            .collect(Collectors.toList());
        double totalPrice = cart.getCartPrice();
        return new CartDTO(items,totalPrice);
    }

    // DTO classes
    //public record DrinkDTO(String name, char size, double price, String description) {}
    //public record CartDTO(List<DrinkDTO> items, double totalPrice) {}


    @PostMapping("/add")
    public String addToCart(@RequestBody DrinkDTO dto) {
      
        return og.onAddToCart(dto.getName(), dto.getSize());
    //     Drink drink = df.createDrink(dto.getName(), dto.getSize());
    //     return cart.addToCart(drink);
    // }
    }
   
}
