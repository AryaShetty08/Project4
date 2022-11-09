package pizzaManager;

import java.util.ArrayList;

public abstract class Pizza implements Customizable{
    protected ArrayList<Topping> toppings;
    protected Crust crust;
    protected Size size;
    public abstract double price();
}
