package com.coffeeshop.Classes;

public class Admin {

        public void viewPreorderQueue(){
            OrderQueue oq = OrderQueue.getInstance();
            oq.viewQueue();
        }

        //Update prices logic for another time
        /*public void UpdatePrices(Admin a) throws Exception {
            System.out.println("What would you like to update: ");
            Scanner s = new Scanner(System.in);
            String coffeeToUpdate = s.nextLine();
            System.out.println("What size would you like to change the price of: ");
            char size = s.nextLine().charAt(0);
            System.out.println("What would you like to change the price to?: ");
            double priceChange = s.nextDouble();

            Field f = clazz.getDeclaredField("price")
            Class<?> clazz = Class.forName("Classes."+coffeeToUpdate);
            Constructor<?> ctor = clazz.getDeclaredConstructor(char.class);
            Object instance = ctor.newInstance(size);

            Method m = clazz.getMethod("updatePrice", Admin.class, double.class);
            m.invoke(instance,a,priceChange);

        }*/

}
