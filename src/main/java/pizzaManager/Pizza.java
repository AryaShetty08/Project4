package pizzaManager;

import java.text.DecimalFormat;
import java.util.ArrayList;

public abstract class Pizza implements Customizable{
    protected static final DecimalFormat df = new DecimalFormat("0.00");
    protected ArrayList<Topping> toppings;
    protected Crust crust;
    protected Size size;
    public abstract double price();
    public abstract void setSize(Size size);
    public ArrayList<Topping> getToppings(){
        return toppings;
    }
    public Crust getCrust(){
        return crust;
    }
    @Override
    public abstract String toString();
}
