package pizzaManager;

import java.util.ArrayList;

public class StoreOrder implements  Customizable{
    private ArrayList<Order> orderList;
    private int idToAssign;
    public StoreOrder(){
        this.orderList = new ArrayList<Order>();
        idToAssign = 1;
    }

    @Override
    public boolean add(Object obj) {
        return false;
    }

    @Override
    public boolean remove(Object obj) {
        return false;
    }
}
