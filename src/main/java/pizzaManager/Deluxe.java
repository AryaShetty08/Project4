package pizzaManager;

import java.util.ArrayList;
import java.util.Arrays;

public class Deluxe extends Pizza {
    public Deluxe (PizzaFactory pizzaFactory){
        if (pizzaFactory instanceof NYPizza){
            crust = Crust.BROOKLYN;
        }
        else if (pizzaFactory instanceof ChicagoPizza){
            crust = Crust.DEEP_DISH;
        }
        else {
            crust = null;
        }
        toppings = new ArrayList<Topping>(Arrays.asList(Topping.SAUSAGE, Topping.PEPPERONI, Topping.GREEN_PEPPER, Topping.ONION, Topping.MUSHROOM));
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
                return 14.99;
            }
            case MEDIUM -> {
                return 16.99;
            }
            case LARGE -> {
                return 18.99;
            }
            default -> {
                return 0;
            }
        }
    }

    @Override
    public void setSize(Size size) {
        this.size = size;
    }
}
