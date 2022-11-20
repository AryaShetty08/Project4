package com.example.project4;

import javafx.animation.PauseTransition;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.util.Duration;
import pizzaManager.Order;
import pizzaManager.Pizza;
import pizzaManager.StoreOrder;

import java.io.IOException;
import java.text.DecimalFormat;

/**
 * Controller class for Store Orders View
 * Connects GUI inputs to Pizza Factory class
 * So that User can view all orders and export them
 * @author Arya Shetty, John Greaney-Cheng
 */
public class StoreOrdersViewController {
    private StoreOrder storeOrder;
    private MainViewController mainViewController;
    private static final DecimalFormat df = new DecimalFormat("0.00");
    @FXML
    private TextField orderTotal;
    @FXML
    private ListView<Pizza> pizzaOrder;
    @FXML
    private ComboBox<Integer> orderNumber;
    @FXML
    private Label exportOutput;

    /**
     * Creates a StoreOrdersViewController object
     */
    public StoreOrdersViewController() {
        this.storeOrder = new StoreOrder();
    }

    /**
     * Allows this controller to access main view controller
     * @param mainViewController controller that connects all fxml controllers
     */
    public void setMainViewController (MainViewController mainViewController){
        this.mainViewController = mainViewController;
    }

    /**
     * Initializes Order Numbers ComboBox values and adds a listener
     * Initializes current Serial Number and displays order if an order was placed
     * otherwise everything sets to empty
     */
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

    /**
     * Adds Order from current order to Store Orders
     * Calls add from StoreOrder and then once added to ArrayList
     * It starts filling GUI units
     * Sets the List View, Serial Number, and the Order Total
     * User can then switch between order using ComboBox
     * @param order order that holds the values for order in current order view
     */
    public void addOrder(Order order){
        storeOrder.add(order);
        orderTotal.setText(df.format(order.getTotal()));
        pizzaOrder.getItems().clear();
        pizzaOrder.getItems().addAll(order.getPizzaList());
        orderNumber.getItems().add(order.getSerialNumber());
        orderNumber.getSelectionModel().selectLast();
    }

    /**
     * Exports Order from the order displayed on Store Orders View
     * If there is no order number then it doesn't export,
     * otherwise it calls export method from store order,
     * and it runs an animation displaying whether the document exported or not,
     * which is why there is an exception
     * @throws IOException throws IOException to check pause transition exceptions
     */
    public void exportStoreOrdersClick() throws IOException {
        if (orderNumber.getValue() == null){
            return;
        }
        exportOutput.setText("Exported to document!");
        PauseTransition pause = new PauseTransition(Duration.seconds(2));
        pause.setOnFinished(e -> exportOutput.setText(null));
        pause.play();
        storeOrder.export(orderNumber.getValue());
    }

    /**
     * Cancels the order and deletes it from Store Order View
     * If there is no selected order nothing happens
     * However if there is it deletes the serial number and erases the list view of the order,
     * and it will go to the remaining orders if there are any otherwise nothing is displayed
     */
    public void cancelOrderClick() {
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
