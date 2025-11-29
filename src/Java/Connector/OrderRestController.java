package Connector;

@RestController
@RequestMapping("/api/orders")
public class OrderRestController {

    private final OrderGui og;

    public OrderRestController(OrderGUI og) {
        this.og = og;
    }

    @PostMapping("/create")
    public String placeOrder(@RequestBody OrderDTO orderDTO) {
        Cart c = new Cart();
        for (DrinkDTO drinkDTO : orderDTO.getCart()) {
            Drink drink = new Drink(drinkDTO.getName(), drinkDTO.getSize(),drinkDTO.getPrice(), drinkDTO.getDescription());
            cart.addToCart(drink);
        }
        Order order = new Order(
            cart,
            orderDTO.getName(),
            orderDTO.getPhone(),
            orderDTO.getCardNumber(),
            orderDTO.getCvc(),
            orderDTO.getExpDate() // or expiration date if you have it
        );
        
        String result = og.onOrderCoffee(order);
        return ResponseEntity.ok(result);
    }
}
