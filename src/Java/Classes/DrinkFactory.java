package Classes;

import java.util.HashMap;

public class DrinkFactory {
        private HashMap<String, Class> drinks = new HashMap();
        public DrinkFactory()
        {
            drinks.put("Drip Coffee", DripCoffee.class);
            drinks.put("Latte", Latte.class);

        }
        public void displayDrinks(){
            int i = 3;
            for(String s : drinks.keySet())
                System.out.println(s +" "+ i++);
        }
        public Drink createDrink(String type,char size) {
            Drink d = null;
            try {
                d = (Drink)drinks.get(type).getConstructor(char.class).newInstance(size);
            }
            catch(Exception e){ System.out.println(e +"I knew it");}

            return d;
        }

        public void addNewDrink(String type)
        {
            try {
                String pizzaClassName = type.substring(0,1).toUpperCase()+type.substring(1)+"Coffee";
                drinks.put(type, Class.forName(pizzaClassName));
            } catch (ClassNotFoundException e) {System.out.println(e);}
        }

        public List<> getAllDrinks(){
            return drinks;
        }
    }


