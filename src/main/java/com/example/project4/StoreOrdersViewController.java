package com.example.project4;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

public class StoreOrdersViewController {

    private MainViewController mainViewController;
    @FXML
    private TextField orderTotal;
    @FXML
    private ListView pizzaOrder;
    @FXML
    private ChoiceBox<Integer> orderNumber;

    public void setMainViewController (MainViewController mainViewController){
        this.mainViewController = mainViewController;
    }

    public void setPizzaOrder(){
    }

    public void setOrderTotal(){
    }

    public void exportStoreOrdersClick(ActionEvent actionEvent) {
    }

    public void cancelOrderClick(ActionEvent actionEvent) {
    }
}
