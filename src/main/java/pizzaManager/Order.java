package pizzaManager;

import java.util.ArrayList;
import java.text.DecimalFormat;

public class Order implements Customizable{
    private int serialNumber;
    private static final double TAX_RATE = 0.06625;
    private ArrayList <Pizza> pizzaList;
    private static final DecimalFormat df = new DecimalFormat("0.00");

    public Order (int serialNumber){
        this.serialNumber = serialNumber;
        this.pizzaList = new ArrayList<Pizza>();
    }

    public double getSubtotal(){
        double subTotal = 0;
        for (Pizza pizza: pizzaList){
            subTotal += pizza.price();
        }
        return subTotal;
    }

    public double getTax(){
        double tax = getSubtotal() * TAX_RATE;
        return Double.parseDouble(df.format(tax));
    }

    public double getTotal(){
        return getTax() + getSubtotal();
    }

    @Override
    public boolean add(Object obj) {
        if (obj instanceof Pizza){
            return pizzaList.add((Pizza) obj);
        }
        return false;
    }

    @Override
    public boolean remove(Object obj) {
        if (obj instanceof Pizza){
            return pizzaList.remove((Pizza) obj);
        }
        return false;
    }

    public boolean isEmpty(){
        return pizzaList.isEmpty();
    }

    public ArrayList<Pizza> getPizzaList(){
        return pizzaList;
    }

    public int getSerialNumber() {
        return serialNumber;
    }
}
