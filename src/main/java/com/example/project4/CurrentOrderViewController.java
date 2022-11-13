package com.example.project4;

import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import pizzaManager.ChicagoPizza;

public class CurrentOrderViewController {

    @FXML
    private TextField orderNumber;
    @FXML
    private ListView pizzaOrder;
    @FXML
    private TextField subtotal;
    @FXML
    private TextField salesTax;
    @FXML
    private TextField orderTotal;

    public CurrentOrderViewController(){}

    @FXML
    public void initialize() {
        ChicagoStylePizzaOrderingController chicagoController = new ChicagoStylePizzaOrderingController();
        NewYorkStylePizzaOrderingController newYorkController = new NewYorkStylePizzaOrderingController();

    }
    
    public void setOrderNumber(int orderNum){
        orderNumber.setText(Integer.valueOf(orderNum).toString());
    }
}
