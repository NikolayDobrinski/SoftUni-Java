package softuni.OOP.encapsulation.PizzaCalories;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        String[] pizzaInfo = scan.nextLine ().split ("\\s+");
        try {
            Pizza    pizza     = new Pizza (pizzaInfo[1], Integer.parseInt (pizzaInfo[2]));
            String[] doughInfo = scan.nextLine ().split ("\\s+");
            Dough    dough     = new Dough (doughInfo[1], doughInfo[2], Double.parseDouble (doughInfo[3]));
            pizza.setDough (dough);
            String   input     = scan.nextLine ();
            while (!"END".equals (input)) {
                String[] toppingInfo = input.split ("\\s+");
                Topping  topping     = new Topping (toppingInfo[1], Double.parseDouble (toppingInfo[2]));
                pizza.addTopping (topping);
                input = scan.nextLine ();
            }
            System.out.println (pizza.toString ());
        }catch (IllegalArgumentException ex){
            System.out.println (ex.getMessage ());
        }
    }
}

