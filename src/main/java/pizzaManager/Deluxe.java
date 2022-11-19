package pizzaManager;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Deluxe class is a blueprint for Deluxe Pizza objects
 * Subclass of Pizza Class
 * @author Arya Shetty, John Greaney-Cheng
 */
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
        size = Size.SMALL;
        toppings = new ArrayList<Topping>(Arrays.asList(Topping.SAUSAGE, Topping.PEPPERONI, Topping.GREEN_PEPPER, Topping.ONION, Topping.MUSHROOM));
    }

    /**
     * No need to add/remove toppings, so method always returns false
     * @param obj topping to add to Topping List (can't in this class)
     * @return false
     */
    @Override
    public boolean add(Object obj) {
        return false;
    }

    /**
     * No need to add/remove toppings, so method always returns false
     * @param obj topping to add to Topping List (can't in this class)
     * @return false
     */
    @Override
    public boolean remove(Object obj) {
        return false;
    }

    /**
     * Method to calculate and return this Deluxe pizza price
     * Price is based solely off of size (see below)
     * @return price of pizza
     */
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

    /**
     * Returns String representation of this Deluxe pizza
     * @return String representation of this Deluxe pizza
     */
    @Override
    public String toString() {
        String toReturn = "Deluxe (";
        if (crust == Crust.BROOKLYN){
            toReturn = toReturn + "New York Style - Brooklyn), ";
        }
        else {
            toReturn = toReturn + "Chicago Style - Deep Dish), ";
        }
        for (Topping topping: toppings){
            toReturn = toReturn + (topping.name() + ", ");
        }
        toReturn = toReturn + (size.name()) + ", $" + (price());
        return toReturn;
    }
}
