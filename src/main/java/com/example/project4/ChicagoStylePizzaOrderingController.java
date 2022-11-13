package com.example.project4;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import pizzaManager.*;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;


public class ChicagoStylePizzaOrderingController {
    private PizzaFactory pizzaFactory;
    private Pizza orderInProgress;

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
    private ToggleGroup pizzaSize;
    @FXML
    private TextField crustType;
    @FXML
    private ListView<Topping> availableTop;
    @FXML
    private ListView<Topping> selectedTop;
    @FXML
    private TextField pizzaPrice;
    @FXML
    private Button addTop;
    @FXML
    private Button removeTop;
    @FXML
    private Button addToOrder;




    public ChicagoStylePizzaOrderingController(){this.pizzaFactory = new ChicagoPizza();}

    @FXML
    public void initialize() {
        pizzaFlavor.getItems().addAll("Build Your Own!", "Deluxe!", "BBQ Chicken!", "Meatzza");
        pizzaFlavor.setOnAction((actionEvent) ->{
            pizzaSize.selectToggle(smallPizza);
            switch (pizzaFlavor.getSelectionModel().getSelectedItem()){
                case "Deluxe!":
                    initializeDeluxe();
                    break;
                case "BBQ Chicken!":
                    initializeBBQ();
                    break;
                case "Meatzza":
                    initializeMeatzza();
                    break;
                case "Build Your Own!":
                    initializeBuildYourOwn();
            }
        });
        pizzaFlavor.getSelectionModel().select(0);
    }

    @FXML
    public void sizeClick() {
        if (smallPizza.isSelected()){
            orderInProgress.setSize(Size.SMALL);
        } else if (mediumPizza.isSelected()){
            orderInProgress.setSize(Size.MEDIUM);
        } else if (largePizza.isSelected()){
            orderInProgress.setSize(Size.LARGE);
        }
        pizzaPrice.setText(String.valueOf(orderInProgress.price()));
    }

    @FXML
    public void addTopping(){
        if (!(availableTop.getSelectionModel().getSelectedItem() == null) && orderInProgress instanceof BuildYourOwn){
            Topping topping = availableTop.getSelectionModel().getSelectedItem();
            if (!orderInProgress.add(topping)){
                return;
            }
            selectedTop.getItems().add(topping);
            availableTop.getItems().remove(topping);
            pizzaPrice.setText(String.valueOf(orderInProgress.price()));
        }
    }

    @FXML
    public void removeTopping(){
        if (!(selectedTop.getSelectionModel().getSelectedItem() == null) && orderInProgress instanceof BuildYourOwn){
            Topping topping = selectedTop.getSelectionModel().getSelectedItem();
            if (!orderInProgress.remove(topping)){
                return;
            }
            availableTop.getItems().add(topping);
            selectedTop.getItems().remove(topping);
            pizzaPrice.setText(String.valueOf(orderInProgress.price()));
        }
    }

    private void initializeDeluxe(){
        ChicagoStyleTemp.setImage(new Image("deluxepizzaChicago.jpg", 285, 215, false, false));
        orderInProgress = pizzaFactory.createDeluxe();
        crustType.setText(orderInProgress.getCrust().name());
        selectedTop.getItems().clear();
        selectedTop.getItems().addAll(orderInProgress.getToppings());
        selectedTop.setDisable(true);
        availableTop.getItems().clear();
        availableTop.getItems().addAll(getSelectedToppings(orderInProgress.getToppings()));
        availableTop.setDisable(true);
        pizzaPrice.setText(String.valueOf(orderInProgress.price()));
    }

    private void initializeBBQ(){
        ChicagoStyleTemp.setImage(new Image("BBQChickenChicago.jpg", 285, 215, false, false));
        orderInProgress = pizzaFactory.createBBQChicken();
        crustType.setText(orderInProgress.getCrust().name());
        selectedTop.getItems().clear();
        selectedTop.getItems().addAll(orderInProgress.getToppings());
        selectedTop.setDisable(true);
        availableTop.getItems().clear();
        availableTop.getItems().addAll(getSelectedToppings(orderInProgress.getToppings()));
        availableTop.setDisable(true);
        pizzaPrice.setText(String.valueOf(orderInProgress.price()));
    }

    private void initializeMeatzza(){
        ChicagoStyleTemp.setImage(new Image("meatzzaChicago.jpg", 285, 215, false, false));
        orderInProgress = pizzaFactory.createMeatzza();
        crustType.setText(orderInProgress.getCrust().name());
        selectedTop.getItems().clear();
        selectedTop.getItems().addAll(orderInProgress.getToppings());
        selectedTop.setDisable(true);
        availableTop.getItems().clear();
        availableTop.getItems().addAll(getSelectedToppings(orderInProgress.getToppings()));
        availableTop.setDisable(true);
        pizzaPrice.setText(String.valueOf(orderInProgress.price()));
    }

    private void initializeBuildYourOwn(){
        ChicagoStyleTemp.setImage(new Image("chicagopizzaimagebuildyourown.jpg", 285, 215, false, false));
        orderInProgress = pizzaFactory.createBuildYourOwn();
        crustType.setText(orderInProgress.getCrust().name());
        selectedTop.getItems().clear();
        selectedTop.getItems().addAll(orderInProgress.getToppings());
        selectedTop.setDisable(false);
        availableTop.getItems().clear();
        availableTop.getItems().addAll(getSelectedToppings(orderInProgress.getToppings()));
        availableTop.setDisable(false);
        pizzaPrice.setText(String.valueOf(orderInProgress.price()));
    }

    private ArrayList<Topping> getSelectedToppings (ArrayList<Topping> availableToppings){
        ArrayList<Topping> selectedToppings = new ArrayList<Topping>();
        for (Topping topping: Topping.values()){
            if (!availableToppings.contains(topping)){
                selectedToppings.add(topping);
            }
        }
        return selectedToppings;
    }

    @FXML
    public void addToOrderClick(){
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Current-Order-View.fxml"));
        CurrentOrderViewController currentController = loader.getController();
        currentController.setOrderNumber(1);
    }
}