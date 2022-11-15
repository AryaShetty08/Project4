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
        size = Size.SMALL;
        toppings = new ArrayList<Topping>(Arrays.asList(Topping.SAUSAGE, Topping.PEPPERONI, Topping.BEEF, Topping.HAM));
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
            default -> {
                return 0;
            }
        }
    }

    @Override
    public void setSize(Size size) {
        this.size = size;
    }

    public ArrayList<Topping> getToppings(){
        return toppings;
    }

    @Override
    public String toString() {
        String toReturn = "Meatzza (";
        if (crust == Crust.HAND_TOSSED){
            toReturn = toReturn + "New York Style - Hand Tossed), ";
        }
        else {
            toReturn = toReturn + "Chicago Style - Stuffed), ";
        }
        for (Topping topping: toppings){
            toReturn = toReturn + (topping.name() + ", ");
        }
        toReturn = toReturn + (size.name()) + ", $" + (price());
        return toReturn;
    }

}
