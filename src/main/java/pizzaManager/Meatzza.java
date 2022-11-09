package pizzaManager;

import java.util.ArrayList;
import java.util.Arrays;

public class Meatzza extends Pizza{
    public Meatzza (PizzaFactory pizzaFactory){
        if (pizzaFactory instanceof NYPizza){
            crust = Crust.HAND_TOSSED;
        }
        else if (pizzaFactory instanceof ChicagoPizza){
            crust = Crust.STUFFED;
        }
        else {
            crust = null;
        }
        toppings = new ArrayList<Topping>(Arrays.asList(Topping.BBQ_CHICKEN, Topping.GREEN_PEPPER, Topping.PROVOLONE, Topping.CHEDDAR));
    }

    @Override
    public boolean add(Object obj) {
        return false;
    }

    @Override
    public boolean remove(Object obj) {
        return false;
    }

    @Override
    public double price() {
        switch (size) {
            case SMALL -> {
                return 15.99;
            }
            case MEDIUM -> {
                return 17.99;
            }
            case LARGE -> {
                return 19.99;
            }
        }
        return 0;
    }
}
