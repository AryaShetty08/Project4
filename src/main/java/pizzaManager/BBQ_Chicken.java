package pizzaManager;

import java.util.ArrayList;
import java.util.Arrays;

public class BBQ_Chicken extends Pizza{
    public BBQ_Chicken (PizzaFactory pizzaFactory, Size size){
        if (pizzaFactory instanceof NYPizza){
            crust = Crust.THIN;
        }
        else if (pizzaFactory instanceof ChicagoPizza){
            crust = Crust.PAN;
        }
        else {
            crust = null;
        }
        toppings = new ArrayList<Topping>(Arrays.asList(Topping.BBQ_CHICKEN, Topping.GREEN_PEPPER, Topping.PROVOLONE, Topping.CHEDDAR));
        this.size = size;
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
        }
        return 0;
    }
}
