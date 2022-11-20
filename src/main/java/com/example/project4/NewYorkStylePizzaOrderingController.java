package com.example.project4;

import javafx.animation.PauseTransition;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.util.Duration;
import pizzaManager.*;
import java.util.ArrayList;

/**
 * Controller class for New York Style Pizza Ordering View
 * Connects GUI inputs to Pizza Factory class
 * @author Arya Shetty, John Greaney-Cheng
 */
public class NewYorkStylePizzaOrderingController {
    private MainViewController mainViewController;
    private PizzaFactory pizzaFactory;
    private Pizza orderInProgress;

    @FXML
    private ImageView NewYorkStyleTemp;
    @FXML
    private ComboBox<String> pizzaFlavor;
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
    private Label addOutput;

    /**
     * Creates a NewYorkStylePizzaOrderingController object
     */
    public NewYorkStylePizzaOrderingController(){
        this.pizzaFactory = new NYPizza();
    }

    /**
     * Initializes Pizza Flavors ComboBox values and adds a listener
     * Initializes size radio button, and chosen pizza flavor ComboBox value
     */
    @FXML
    public void initialize() {
        pizzaFlavor.getItems().addAll("Build Your Own!", "Deluxe!", "BBQ Chicken!", "Meatzza");
        pizzaFlavor.setOnAction((actionEvent) ->{
            pizzaSize.selectToggle(smallPizza);
            switch (pizzaFlavor.getSelectionModel().getSelectedItem()) {
                case "Deluxe!" -> initializeDeluxe();
                case "BBQ Chicken!" -> initializeBBQ();
                case "Meatzza" -> initializeMeatzza();
                case "Build Your Own!" -> initializeBuildYourOwn();
            }
        });
        pizzaFlavor.getSelectionModel().select(0);
        pizzaSize.selectToggle(smallPizza);
        initializeBuildYourOwn();
    }

    /**
     * Allows this controller to access main view controller
     * @param mainViewController controller that connects all fxml controllers
     */
    public void setMainViewController (MainViewController mainViewController){
        this.mainViewController = mainViewController;
    }

    /**
     * Updates size of pizza based off of size radio buttons
     */
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

    /**
     * Adds Topping to pizza
     * First checks that pizza is build your own pizza
     * If topping can be added to pizza, adds topping and
     * moves topping from available toppings to selected toppings
     */
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

    /**
     * Removes Topping from pizza
     * First checks that pizza is build your own pizza
     * If topping can be removed from pizza, removes topping and
     * moves topping from selected toppings to available toppings
     */
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

    /**
     * Private helper method to reset everything and go to a new Deluxe Pizza
     * Edits image, toppings, resets size, and edits crust and price text boxes
     */
    private void initializeDeluxe(){
        NewYorkStyleTemp.setImage(new Image("deluxepizzaNewYork.png", 285, 215, false, false));
        orderInProgress = pizzaFactory.createDeluxe();
        crustType.setText(orderInProgress.getCrust().name());
        selectedTop.getItems().clear();
        selectedTop.getItems().addAll(orderInProgress.getToppings());
        selectedTop.setDisable(true);
        availableTop.getItems().clear();
        availableTop.getItems().addAll(getAvailableToppings(orderInProgress.getToppings()));
        availableTop.setDisable(true);
        pizzaPrice.setText(String.valueOf(orderInProgress.price()));
    }

    /**
     * Private helper method to reset everything and go to a new BBQ Chicken Pizza
     * Edits image, toppings, resets size, and edits crust and price text boxes
     */
    private void initializeBBQ(){
        NewYorkStyleTemp.setImage(new Image("BBQChickenNewYork.jpg", 285, 215, false, false));
        orderInProgress = pizzaFactory.createBBQChicken();
        crustType.setText(orderInProgress.getCrust().name());
        selectedTop.getItems().clear();
        selectedTop.getItems().addAll(orderInProgress.getToppings());
        selectedTop.setDisable(true);
        availableTop.getItems().clear();
        availableTop.getItems().addAll(getAvailableToppings(orderInProgress.getToppings()));
        availableTop.setDisable(true);
        pizzaPrice.setText(String.valueOf(orderInProgress.price()));
    }

    /**
     * Private helper method to reset everything and go to a new Meatzza Pizza
     * Edits image, toppings, resets size, and edits crust and price text boxes
     */
    private void initializeMeatzza(){
        NewYorkStyleTemp.setImage(new Image("meatzzaNewYork.jpg", 285, 215, false, false));
        orderInProgress = pizzaFactory.createMeatzza();
        crustType.setText(orderInProgress.getCrust().name());
        selectedTop.getItems().clear();
        selectedTop.getItems().addAll(orderInProgress.getToppings());
        selectedTop.setDisable(true);
        availableTop.getItems().clear();
        availableTop.getItems().addAll(getAvailableToppings(orderInProgress.getToppings()));
        availableTop.setDisable(true);
        pizzaPrice.setText(String.valueOf(orderInProgress.price()));
    }

    /**
     * Private helper method to reset everything and go to a new Build Your Own Pizza
     * Edits image, toppings, resets size, and edits crust and price text boxes
     */
    private void initializeBuildYourOwn(){
        NewYorkStyleTemp.setImage(new Image("newyorkbuildyourown.jpg", 285, 215, false, false));
        orderInProgress = pizzaFactory.createBuildYourOwn();
        crustType.setText(orderInProgress.getCrust().name());
        selectedTop.getItems().clear();
        selectedTop.getItems().addAll(orderInProgress.getToppings());
        selectedTop.setDisable(false);
        availableTop.getItems().clear();
        availableTop.getItems().addAll(getAvailableToppings(orderInProgress.getToppings()));
        availableTop.setDisable(false);
        pizzaPrice.setText(String.valueOf(orderInProgress.price()));
    }

    /**
     * Private helper method to determine available toppings from selected toppings
     * Essentially adds every topping from enum that isn't in selected toppings
     * @param selectedToppings selected toppings list (should not be in available)
     * @return available toppings
     */
    private ArrayList<Topping> getAvailableToppings (ArrayList<Topping> selectedToppings){
        ArrayList<Topping> availableToppings = new ArrayList<Topping>();
        for (Topping topping: Topping.values()){
            if (!selectedToppings.contains(topping)){
                availableToppings.add(topping);
            }
        }
        return availableToppings;
    }

    /**
     * Takes current pizzaInProgress and adds it to Order
     * Resets everything and sends pizza to CurrentOrderViewController
     */
    @FXML
    public void addToOrderClick(){
        addOutput.setText("Added pizza!");
        PauseTransition pause = new PauseTransition(Duration.seconds(2));
        pause.setOnFinished(e -> addOutput.setText(null));
        pause.play();
        mainViewController.addToOrderList(orderInProgress);
        pizzaSize.selectToggle(smallPizza);
        pizzaFlavor.getSelectionModel().select(0);
        initializeBuildYourOwn();
    }
}