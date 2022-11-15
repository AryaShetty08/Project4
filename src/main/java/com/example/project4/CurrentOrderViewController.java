package com.example.project4;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import pizzaManager.*;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class CurrentOrderViewController {
    private MainViewController mainViewController;
    private Order currentOrder;
    private int serialNumber;
    private static final DecimalFormat df = new DecimalFormat("0.00");
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

    public CurrentOrderViewController(){
        this.serialNumber = 1;
    }

    public void setMainViewController (MainViewController mainViewController){
        this.mainViewController = mainViewController;
    }

    @FXML
    public void initialize() {
        orderNumber.setText(String.valueOf(serialNumber));
        subtotal.setText("0");
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
        if (currentOrder == null){
            currentOrder = new Order(this.serialNumber);
        }
        currentOrder.add(pizza);
        subtotal.setText(df.format(currentOrder.getSubtotal()));
    }

    @FXML
    public void placeOrderClick(ActionEvent actionEvent) {
    }

    @FXML
    public void removePizzaClick(ActionEvent actionEvent) {
    }

    @FXML
    public void clearOrderClick(ActionEvent actionEvent) {

    }
}
