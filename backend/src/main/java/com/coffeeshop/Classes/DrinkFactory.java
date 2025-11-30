package com.coffeeshop.Classes;
import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;

public class DrinkFactory {
        private HashMap<String, Class> drinks = new HashMap<>();
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


        public List<Drink> getAllDrinks(){
            List<Drink> drinkList = new ArrayList<>();
            for (Class<? extends Drink> cls : drinks.values()) {
            try {
             Drink d = cls.getConstructor(char.class).newInstance('s'); // example: default size 'M'
            drinkList.add(d);
            } catch (Exception e) {
                e.printStackTrace();
                }
}
            return drinkList;

        }
       

    };
