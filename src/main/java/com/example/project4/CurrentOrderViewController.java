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
    private ListView<Pizza> pizzaOrder;
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
            orderNumber.setText(String.valueOf(serialNumber));
        }
        currentOrder.add(pizza);
        subtotal.setText(df.format(currentOrder.getSubtotal()));
        salesTax.setText(df.format(currentOrder.getTax()));
        orderTotal.setText(df.format(currentOrder.getTotal()));
        pizzaOrder.getItems().removeAll();
        pizzaOrder.getItems().addAll(currentOrder.getPizzaList());
    }

    @FXML
    public void placeOrderClick(ActionEvent actionEvent) {
        mainViewController.addToStoreOrder(currentOrder);
        serialNumber++;
        currentOrder = null;
        pizzaOrder.getItems().clear();
        subtotal.clear();
        salesTax.clear();
        orderTotal.clear();
        orderNumber.clear();
    }

    @FXML
    public void removePizzaClick(ActionEvent actionEvent) {
        if (!(pizzaOrder.getSelectionModel().getSelectedItem() == null)){
            Pizza pizza = pizzaOrder.getSelectionModel().getSelectedItem();
            if (!currentOrder.remove(pizza)){
                return;
            }
            pizzaOrder.getItems().remove(pizza);
            if (currentOrder.isEmpty()){
                subtotal.clear();
                salesTax.clear();
                orderTotal.clear();
                orderNumber.clear();
            }
            else {
                subtotal.setText(df.format(currentOrder.getSubtotal()));
                salesTax.setText(df.format(currentOrder.getTax()));
                orderTotal.setText(df.format(currentOrder.getTotal()));
            }
        }
    }

    @FXML
    public void clearOrderClick(ActionEvent actionEvent) {
        currentOrder = null;
        pizzaOrder.getItems().clear();
        subtotal.clear();
        salesTax.clear();
        orderTotal.clear();
        orderNumber.clear();
    }
}
