package com.example.project4;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Modality;
import javafx.stage.Stage;
import java.io.IOException;
import pizzaManager.*;

public class MainViewController {
    private ChicagoStylePizzaOrderingController chicagoPizzaController;
    private NewYorkStylePizzaOrderingController newYorkPizzaController;
    private CurrentOrderViewController orderViewController;
    private StoreOrdersViewController storeOrdersViewController;
    private Scene chicagoScene;
    private Scene newYorkScene;
    private Scene orderScene;
    private Scene storeOrderScene;
    @FXML
    private ImageView chicagoPizzaImage;
    @FXML
    private ImageView NYPizzaImage;
    @FXML
    private ImageView StoreOrdersImage;
    @FXML
    private ImageView CurrentOrderImage;

    /**
     * Controller class for Main View
     * Connects GUI inputs to Pizza Factory class
     * And makes sure all connections to other views is optimized
     * By creating stages, scenes, and parents from this class for the other views
     * @author Arya Shetty, John Greaney-Cheng
     */
    public MainViewController() throws IOException {
        FXMLLoader chicagoLoader = new FXMLLoader(getClass().getResource("Chicago-Style-Pizza-Ordering-View.fxml"));
        Parent chicagoRoot = chicagoLoader.load();
        chicagoPizzaController = chicagoLoader.getController();
        chicagoPizzaController.setMainViewController(this);
        chicagoScene = new Scene(chicagoRoot);

        FXMLLoader newYorkLoader = new FXMLLoader(getClass().getResource("New-York-Style-Pizza-Ordering-View.fxml"));
        Parent newYorkRoot = newYorkLoader.load();
        newYorkPizzaController = newYorkLoader.getController();
        newYorkPizzaController.setMainViewController(this);
        newYorkScene = new Scene(newYorkRoot);

        FXMLLoader orderLoader = new FXMLLoader(getClass().getResource("Current-Order-View.fxml"));
        Parent orderRoot = orderLoader.load();
        orderViewController = orderLoader.getController();
        orderViewController.setMainViewController(this);
        orderScene = new Scene(orderRoot);

        FXMLLoader storeOrderLoader = new FXMLLoader(getClass().getResource("Store-Orders-View.fxml"));
        Parent storeOrderRoot = storeOrderLoader.load();
        storeOrdersViewController = storeOrderLoader.getController();
        storeOrdersViewController.setMainViewController(this);
        storeOrderScene = new Scene(storeOrderRoot);
    }

    /**
     * Initializes all Images User to be able to click and choose what scene to go to
     */
    @FXML
    public void initialize() {
        chicagoPizzaImage.setImage(new Image("chicagopizzaimage.jpg", 285, 215, false, false));
        NYPizzaImage.setImage(new Image("NYPizzaImage.jpg", 285, 215, false, false));
        StoreOrdersImage.setImage(new Image("StoreOrdersImage.jpg", 285, 215, false, false));
        CurrentOrderImage.setImage(new Image("currentorderimage.jpg", 285, 215, false, false));
    }

    /**
     * Creates new window for Chicago after the Chicago Image is clicked
     * The stage and scene are set for the Chicago View
     */
    public void switchChicago() {
        Stage stage = new Stage();
        stage.setTitle("Chicago Pizza Order View!");
        stage.setScene(chicagoScene);
        stage.initModality(Modality.NONE);
        stage.show();
    }

    /**
     * Creates new window for New York after the New York Image is clicked
     * The stage and scene are set for the New York View
     */
    public void switchNewYork() {
        Stage stage = new Stage();
        stage.setTitle("New York Pizza Order View!");
        stage.setScene(newYorkScene);
        stage.initModality(Modality.NONE);
        stage.show();
    }

    /**
     * Creates new window for Current Order after the Current Order Image is clicked
     * The stage and scene are set for the CurrentOrder View
     */
    public void switchCurrentOrder() {
        Stage stage = new Stage();
        stage.setTitle("Current Order View!");
        stage.setScene(orderScene);
        stage.initModality(Modality.NONE);
        stage.show();
    }

    /**
     * Creates new window for Store Orders after the Store Image is clicked
     * The stage and scene are set for the StoreOrders View
     */
    public void switchStoreOrders() {
        Stage stage = new Stage();
        stage.setTitle("Store Orders View!");
        stage.setScene(storeOrderScene);
        stage.initModality(Modality.NONE);
        stage.show();
    }

    /**
     * Method is used to translate data between the Chicago Pizza and New York Pizza scenes
     * to add a Pizza to Current Order List, which updates GUI elements in addOrder
     */
    public void addToOrderList(Pizza pizza){
        orderViewController.addOrder(pizza);
    }

    /**
     * Method is used to translate data between the Current Order Scene
     * to add an entire order to Store Order List, which updates GUI elements in addOrder
     */
    public void addToStoreOrder(Order order){
        storeOrdersViewController.addOrder(order);
    }

}
