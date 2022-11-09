package pizzaManager;

public class Deluxe extends Pizza {
    public Deluxe (PizzaFactory pizzaFactory){
        if (pizzaFactory instanceof NYPizza){
            crust = Cru
        }
        else if (pizzaFactory instanceof ChicagoPizza){

        }
        toppings = null;
        crust = null;
        size = null;
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
        return 0;
    }
}
