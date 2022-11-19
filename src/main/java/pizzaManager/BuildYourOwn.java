package pizzaManager;

import java.util.ArrayList;
import java.util.Arrays;

public class BuildYourOwn extends Pizza{
    private int numToppings;
    private static final double pricePerTopping = 1.59;

    public BuildYourOwn (PizzaFactory pizzaFactory){
        if (pizzaFactory instanceof NYPizza){
            crust = Crust.HAND_TOSSED;
        }
        else if (pizzaFactory instanceof ChicagoPizza){
            crust = Crust.PAN;
        }
        else {
            crust = null;
        }
        size = Size.SMALL;
        toppings = new ArrayList<Topping>();
        numToppings = 0;
    }

    @Override
    public boolean add(Object obj) {
        if (numToppings == 7){
            return false;
        }
        if (!toppings.add((Topping) obj)){
            return false;
        }
        numToppings++;
        return true;
    }

    @Override
    public boolean remove(Object obj) {
        if (toppings.remove((Topping) obj)){
            numToppings--;
            return true;
        }
        return false;
    }

    @Override
    public double price() {
        switch (size) {
            case SMALL -> {
                return Double.parseDouble(df.format(8.99 + (pricePerTopping*numToppings)));
            }
            case MEDIUM -> {
                return Double.parseDouble(df.format(10.99 + (pricePerTopping*numToppings)));
            }
            case LARGE -> {
                return Double.parseDouble(df.format(12.99 + (pricePerTopping*numToppings)));
            }
            default -> {
                return 0;
            }
        }
    }

    @Override
    public String toString() {
        String toReturn = "Build Your Own (";
        if (crust == Crust.HAND_TOSSED){
            toReturn = toReturn + "New York Style - Hand Tossed), ";
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
