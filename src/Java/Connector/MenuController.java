package Connector;

import org.apache.naming.factory.DataSourceLinkFactory;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:3000")

public class MenuController {
    private final DrinkFactory df = new DrinkFactory();
    
    @GetMapping("/menu")
    public List<Drink> getMenu(){
    return new ArrayList<>(df.getAllDrinks().values());
    }

}
