package pizzaManager;

import java.util.ArrayList;
import java.util.Arrays;

public class BBQ_Chicken extends Pizza{
    public BBQ_Chicken (PizzaFactory pizzaFactory){
        if (pizzaFactory instanceof NYPizza){
            crust = Crust.THIN;
        }
        else if (pizzaFactory instanceof ChicagoPizza){
            crust = Crust.PAN;
        }
        else {
            crust = null;
        }
        size = Size.SMALL;
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
                return 13.99;
            }
            case MEDIUM -> {
                return 15.99;
            }
            case LARGE -> {
                return 17.99;
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

    @Override
    public String toString() {
        String toReturn = "BBQ Chicken (";
        if (crust == Crust.THIN){
            toReturn = toReturn + "New York Style - Thin), ";
        }
        else {
            toReturn = toReturn + "Chicago Style - Pan), ";
        }
        for (Topping topping: toppings){
            toReturn = toReturn + (topping.name() + ", ");
        }
        toReturn = toReturn + (size.name()) + ", $" + (price());
        return toReturn;
    }
}
