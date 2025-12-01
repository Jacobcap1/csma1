package com.coffeeshop.Connector;
import com.coffeeshop.DTO.*;
import com.coffeeshop.Database.DBMGR;
import com. coffeeshop.Controller.OrderController;
  
import com.coffeeshop.Classes.*;

import java.io.IOException;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.CrossOrigin; 

@RestController

@CrossOrigin(origins = "*")
@RequestMapping("/api/orders")
public class OrderRestController {

 private final OrderController oc;

    public OrderRestController() throws IOException  {
        this.oc = new OrderController();
    }

    @PostMapping("/create")
    public ResponseEntity<String> placeOrder(@RequestBody OrderDTO orderDTO) throws IOException {
        Cart c = Cart.getInstance();
        // System.out.println("Cart gotten in OrderRestController");
        // DrinkFactory df = new DrinkFactory();
        // for (DrinkDTO drinkDTO : orderDTO.getCart()) {
        //     Drink drink = df.createDrink(drinkDTO.getName());
        //     c.addToCart(drink);
        // }
        Order order = new Order(
            c,
            orderDTO.getName(),
            orderDTO.getPhone(),
            orderDTO.getCardNumber(),
            orderDTO.getCvc(),
            orderDTO.getExpDate() // or expiration date if you have it
        );
        System.out.println("New order created");
        String result = oc.placeOrder(order);
        System.out.println(result);
        DBMGR dbmgr = new DBMGR();
        dbmgr.storeOrderInDB(order);
        return ResponseEntity.ok(result);
    }
}
