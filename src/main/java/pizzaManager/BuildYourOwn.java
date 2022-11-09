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
        toppings = new ArrayList<Topping>();
        numToppings = 0;
    }

    @Override
    public boolean add(Object obj) {
        if (numToppings == 7){
            return false;
        }
        toppings.add((Topping) obj);
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
                return 8.99 + (pricePerTopping*numToppings);
            }
            case MEDIUM -> {
                return 10.99 + (pricePerTopping*numToppings);
            }
            case LARGE -> {
                return 12.99 + (pricePerTopping*numToppings);
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
