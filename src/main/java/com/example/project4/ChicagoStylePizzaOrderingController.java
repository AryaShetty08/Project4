package com.example.project4;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class ChicagoStylePizzaOrderingController {

    @FXML
    private ImageView ChicagoStyleTemp;
    @FXML
    private ChoiceBox<String> pizzaFlavor;
    @FXML
    private RadioButton smallPizza;
    @FXML
    private RadioButton mediumPizza;
    @FXML
    private RadioButton largePizza;
    @FXML
    private TextField crustType;
    @FXML
    private ListView availableTop;
    @FXML
    private ListView selectedTop;
    @FXML
    private TextField pizzaPrice;
    @FXML
    private Button addTop;
    @FXML
    private Button removeTop;
    @FXML
    private Button addToOrder;




    @FXML
    public void initialize() {
        pizzaFlavor.getItems().addAll("Build Your Own!", "Deluxe!", "BBQ Chicken!", "Meatzza");

        pizzaFlavor.setOnAction((actionEvent) ->{
            switch (pizzaFlavor.getSelectionModel().getSelectedItem()){
                case "Deluxe!":
                    crustType.setText("Deluxe Hi");
                    break;
                case "BBQ Chicken!":
                    crustType.setText("BBQ Hi");
                    break;
                case "Meatzza":
                    crustType.setText("Meatzza Hi");
                    break;
                case "Build Your Own!":
                    crustType.setText("Build Your Own Hi");
            }
        });
        pizzaFlavor.getSelectionModel().select(1);
        //ChicagoStyleTemp.setImage(new Image("chicagopizzaimage.jpg"));

    }

    @FXML
    public void mouseClick() {
        switch (pizzaFlavor.getSelectionModel().getSelectedItem()) {
            case "Deluxe!":
                crustType.setText("balls!");
            case "BBQ Chicken!":
                crustType.setText("balls1!");
            case "Meatzza!":
                crustType.setText("balls2!");
            case "Build Your Own!":
                crustType.setText("balls3!");
                break;
            default:
                crustType.setText("not Balls!");
        }

    }
}