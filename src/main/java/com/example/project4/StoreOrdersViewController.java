package com.example.project4;

import javafx.animation.PauseTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.util.Duration;
import pizzaManager.Order;
import pizzaManager.Pizza;
import pizzaManager.StoreOrder;

import java.io.*;
import java.text.DecimalFormat;

public class StoreOrdersViewController {
    private StoreOrder storeOrder;
    private MainViewController mainViewController;
    private static final DecimalFormat df = new DecimalFormat("0.00");
    @FXML
    private TextField orderTotal;
    @FXML
    private ListView<Pizza> pizzaOrder;
    @FXML
    private ChoiceBox<Integer> orderNumber;
    @FXML
    private Label exportOutput;

    public StoreOrdersViewController() {
        this.storeOrder = new StoreOrder();
    }

    public void setMainViewController (MainViewController mainViewController){
        this.mainViewController = mainViewController;
    }
    @FXML
    public void initialize() {
        orderNumber.setOnAction((actionEvent) ->{
            int currentSerialNumber;
            if (orderNumber.getItems().isEmpty()){
                currentSerialNumber = -1;
            }
            else {
                currentSerialNumber = orderNumber.getValue();

            }
            Order currentOrder = null;
            pizzaOrder.getItems().clear();
            for (Order order : storeOrder.getOrderList()){
                if (currentSerialNumber == order.getSerialNumber()){
                    currentOrder = order;
                    break;
                }
            }
            if (currentOrder == null){
                orderTotal.setText("");
                return;
            }
            orderTotal.setText(df.format(currentOrder.getTotal()));
            pizzaOrder.getItems().addAll(currentOrder.getPizzaList());
        });
    }


    public void addOrder(Order order){
        storeOrder.add(order);
        orderTotal.setText(df.format(order.getTotal()));
        pizzaOrder.getItems().clear();
        pizzaOrder.getItems().addAll(order.getPizzaList());
        orderNumber.getItems().add(order.getSerialNumber());
        orderNumber.getSelectionModel().selectLast();
    }

    public void exportStoreOrdersClick(ActionEvent actionEvent) throws IOException {
        exportOutput.setText("Exported to document!");
        PauseTransition pause = new PauseTransition(Duration.seconds(2));
        pause.setOnFinished(e -> exportOutput.setText(null));
        pause.play();
        storeOrder.export(orderNumber.getValue());
    }

    public void cancelOrderClick(ActionEvent actionEvent) {
        if (orderNumber.getItems().isEmpty()){
            return;
        }
        int currentSerialNumber = orderNumber.getValue();
        for (int i = 0; i < orderNumber.getItems().size(); i++) {
            if (orderNumber.getItems().get(i) == currentSerialNumber) {
                orderNumber.getItems().remove(i);
                break;
            }
        }
        Order currentOrder = null;
        for (Order order : storeOrder.getOrderList()) {
            if (currentSerialNumber == order.getSerialNumber()) {
                currentOrder = order;
                break;
            }
        }
        if (currentOrder == null) {
            orderTotal.setText("");
            return;
        }
        storeOrder.remove(currentOrder);
        if (orderNumber.getItems().isEmpty()) {
            pizzaOrder.getItems().clear();
            orderTotal.setText("");
        } else {
            orderNumber.getSelectionModel().selectFirst();
        }
    }
}
