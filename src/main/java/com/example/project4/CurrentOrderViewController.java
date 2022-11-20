package com.example.project4;

import javafx.animation.PauseTransition;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.util.Duration;
import pizzaManager.Order;
import pizzaManager.Pizza;

import java.text.DecimalFormat;

/**
 * Controller class for Current Order View
 * Connects GUI inputs to Pizza Factory class
 * And displays order that is being made
 * @author Arya Shetty, John Greaney-Cheng
 */
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
    @FXML
    private Label orderOutput;

    /**
     * Creates a CurrentOrderViewController object
     */
    public CurrentOrderViewController(){
        this.serialNumber = 1;
    }

    /**
     * Allows this controller to access main view controller
     * @param mainViewController controller that connects all fxml controllers
     */
    public void setMainViewController (MainViewController mainViewController){
        this.mainViewController = mainViewController;
    }

    /**
     * Adds pizza that is being made to order
     * If there is nothing added to order,
     * A new current order is made,
     * Otherwise the Listview, salestax, subtotal, and order total are all updated
     * @param pizza, pizza that is made and must be added to current order
     */
    public void addOrder(Pizza pizza){
        if (currentOrder == null){
            currentOrder = new Order(this.serialNumber);
            orderNumber.setText(String.valueOf(serialNumber));
        }
        currentOrder.add(pizza);
        subtotal.setText(df.format(currentOrder.getSubtotal()));
        salesTax.setText(df.format(currentOrder.getTax()));
        orderTotal.setText(df.format(currentOrder.getTotal()));
        pizzaOrder.getItems().add(pizza);
    }

    /**
     * Sends current order to Store Orders and removes everything from current screen
     * If there is nothing in the order nothing happens,
     * otherwise the serial number increases, and the order is sent to the store order
     * using the main view controller, then the list, tax, and totals are cleared
     */
    @FXML
    public void placeOrderClick() {
        if(!subtotal.getText().equals("")){
            orderOutput.setText("Added order!");
            PauseTransition pause = new PauseTransition(Duration.seconds(2));
            pause.setOnFinished(e -> orderOutput.setText(null));
            pause.play();
            serialNumber++;
            mainViewController.addToStoreOrder(currentOrder);
            currentOrder = null;
            pizzaOrder.getItems().clear();
            subtotal.clear();
            salesTax.clear();
            orderTotal.clear();
            orderNumber.clear();
        }
    }

    /**
     * Removes selected pizza from order updating GUI elements
     * A pizza has to be selected for method to run,
     * Then the List, tax, and totals will be adjusted accordingly to the removed pizza,
     * If it was the last pizza then those elements will be empty
     */
    @FXML
    public void removePizzaClick() {
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

    /**
     * Clears entire order of pizza list, tax, totals, and order number
     */
    @FXML
    public void clearOrderClick() {
        currentOrder = null;
        pizzaOrder.getItems().clear();
        subtotal.clear();
        salesTax.clear();
        orderTotal.clear();
        orderNumber.clear();
    }
}
