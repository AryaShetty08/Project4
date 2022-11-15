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
import pizzaManager.StoreOrder;

public class StoreOrdersViewController {

    private StoreOrder storeOrder;
    private MainViewController mainViewController;
    @FXML
    private TextField orderTotal;
    @FXML
    private ListView pizzaOrder;
    @FXML
    private ChoiceBox<Integer> orderNumber;
    @FXML
    private Label exportOutput;

    public void setMainViewController (MainViewController mainViewController){
        this.mainViewController = mainViewController;
    }

    public void addOrder(Order order){
    }

    public void setPizzaOrder(){
    }

    public void setOrderTotal(){
    }

    public void exportStoreOrdersClick(ActionEvent actionEvent) {
        exportOutput.setText("Exported to document!");
        PauseTransition pause = new PauseTransition(Duration.seconds(2));
        pause.setOnFinished(e -> exportOutput.setText(null));
        pause.play();
    }

    public void cancelOrderClick(ActionEvent actionEvent) {
    }
}
