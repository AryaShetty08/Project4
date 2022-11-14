package com.example.project4;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import pizzaManager.*;

import java.util.ArrayList;

public class CurrentOrderViewController {
    private MainViewController mainViewController;
    private ArrayList<Pizza> orderList;
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

    private ChicagoStylePizzaOrderingController chicagoController;

    public void setCurrentController(ChicagoStylePizzaOrderingController controller){
        chicagoController = controller;
    }

    public CurrentOrderViewController(){
        this.orderList = new ArrayList<Pizza>();
//        this.orderNumber = 0;
    }

    public void setMainViewController (MainViewController mainViewController){
        this.mainViewController = mainViewController;
    }

    @FXML
    public void initialize() {
        ChicagoStylePizzaOrderingController chicagoController = new ChicagoStylePizzaOrderingController();
        NewYorkStylePizzaOrderingController newYorkController = new NewYorkStylePizzaOrderingController();

    }

    public void setOrderNumber(int orderNum){
        orderNumber.setText(Integer.valueOf(orderNum).toString());
    }
    public void setPizzaOrder(){
    }

    public void setSubtotal(){
    }

    public void setSalesTax(){
    }

    public void setOrderTotal(){
    }

    public void addOrder(Pizza pizza){

    }

    public void placeOrderClick(ActionEvent actionEvent) {
    }

    public void removePizzaClick(ActionEvent actionEvent) {
    }

    public void clearOrderClick(ActionEvent actionEvent) {
    }
}
