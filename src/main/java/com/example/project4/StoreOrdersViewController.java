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
    }

    public void setMainViewController (MainViewController mainViewController){
        this.mainViewController = mainViewController;
    }

    public void addOrder(Order order){
        orderTotal.setText(df.format(order.getTotal()));
        pizzaOrder.getItems().addAll(order.getPizzaList());
        orderNumber.getItems().add(order.getSerialNumber());
        orderNumber.getSelectionModel().select(order.getSerialNumber()-1);
    }

    public void exportStoreOrdersClick(ActionEvent actionEvent) throws FileNotFoundException {
        exportOutput.setText("Exported to document!");
        PauseTransition pause = new PauseTransition(Duration.seconds(2));
        pause.setOnFinished(e -> exportOutput.setText(null));
        pause.play();
        File export = new File("ExportOrders.txt");
        PrintWriter pw = new PrintWriter(export);
        pw.println(pizzaOrder.getItems().toString());
        pw.close();
    }

    public void cancelOrderClick(ActionEvent actionEvent) {
        orderNumber.getSelectionModel().clearSelection();
        orderTotal.setText("");
        orderNumber.getItems().remove(orderNumber.getSelectionModel().getSelectedIndex());
    }
}
