package Connector;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cart ")

public class CartController {

private final OrderGUI og = new OrderGUI();
private final Cart cart;

@GetMapping
    public CartDTO getCart() {
        List<DrinkDTO> items = cart.getCart().stream()
            .map(d -> new DrinkDTO(d.getName(), d.getSize(), d.getPrice(), d.getDescription()))
            .collect(Collectors.toList());
        double totalPrice = cart.getCartPrice();
        return new CartDTO(items,totalPrice);
    }

    // DTO classes
    public record DrinkDTO(String name, char size, double price) {}
    public record CartDTO(List<DrinkDTO> items, double totalPrice) {}


    @PostMapping("/add")
    public String addToCart(@RequestBody DrinkDTO dto) {
        Drink drink = new Drink(dto.getName(), dto.getPrice(), dto.getDescription(),dto.getSize());
        return cart.addToCart(drink);
    }

   
}
