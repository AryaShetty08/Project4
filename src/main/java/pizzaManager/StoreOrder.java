package pizzaManager;

import java.util.ArrayList;

public class StoreOrder implements  Customizable{
    private ArrayList<Order> orderList;
    public StoreOrder(){
        this.orderList = new ArrayList<Order>();
    }

    @Override
    public boolean add(Object obj) {
        if (obj instanceof Order){
            return orderList.add((Order) obj);
        }
        return false;
    }

    @Override
    public boolean remove(Object obj) {
        if (obj instanceof Order){
            return orderList.remove((Order) obj);
        }
        return false;
    }

    public ArrayList<Order> getOrderList() {
        return orderList;
    }
}
