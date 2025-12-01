package com.coffeeshop.Classes;
import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;

public class DrinkFactory {
        private HashMap<String, Class> drinks = new HashMap<>();
        public DrinkFactory()
        {
            drinks.put("Small Drip Coffee", SmallDripCoffee.class);
            drinks.put("Medium Drip Coffee", MediumDripCoffee.class);
            drinks.put("Large Drip Coffee", LargeDripCoffee.class);

            drinks.put("Latte", Latte.class);


        }
        public void displayDrinks(){
            int i = 3;
            for(String s : drinks.keySet())
                System.out.println(s +" "+ i++);
        }
        public Drink createDrink(String type) {
            Drink d = null;
            try {
                      System.out.println("Available keys: "+ drinks.keySet());
                      System.out.println("Requested key "+ type);

                d = (Drink)drinks.get(type).getConstructor().newInstance();
            }
            catch(Exception e){ System.out.println(e +"I knew it");}

            return d;
        }


        public List<Drink> getAllDrinks(){
            List<Drink> drinkList = new ArrayList<>();
            for (Class<? extends Drink> cls : drinks.values()) {
            try {
             Drink d = cls.getConstructor().newInstance(); 
            drinkList.add(d);
            } catch (Exception e) {
                e.printStackTrace();
                }
}
            return drinkList;

        }
       

    };
