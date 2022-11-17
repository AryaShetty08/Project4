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
            int currentSerialNumber = orderNumber.getValue();
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

    public void exportStoreOrdersClick(ActionEvent actionEvent) throws FileNotFoundException {
        exportOutput.setText("Exported to document!");
        PauseTransition pause = new PauseTransition(Duration.seconds(2));
        pause.setOnFinished(e -> exportOutput.setText(null));
        pause.play();
        File export = new File("ExportOrders.txt");
        PrintWriter pw = new PrintWriter(export);
        pw.println("Order " + orderNumber.getValue() + ":");
        for (Pizza pizza: pizzaOrder.getItems()){
            pw.println(pizza.toString());
        }
        pw.println("Order Total: $" + orderTotal.getText());
        pw.close();
    }

    public void cancelOrderClick(ActionEvent actionEvent) {
        int currentSerialNumber = orderNumber.getValue();
        orderTotal.setText("");
        for (int i = 0; i < orderNumber.getItems().size(); i++){
            if (orderNumber.getItems().get(i) == currentSerialNumber){
                orderNumber.getItems().remove(i);
                orderNumber.getSelectionModel().clearSelection();
                break;
            }
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
        storeOrder.remove(currentOrder);
    }
}
