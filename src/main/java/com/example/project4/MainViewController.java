package com.example.project4;

import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class MainViewController {
    @FXML
    private ImageView chicagoPizzaImage;
    @FXML
    private ImageView NYPizzaImage;
    @FXML
    private ImageView StoreOrdersImage;
    @FXML
    private ImageView CurrentOrderImage;

    @FXML
    public void initialize() {
        chicagoPizzaImage.setImage(new Image("chicagopizzaimage.jpg"));
        NYPizzaImage.setImage(new Image("NYPizzaImage.jpg"));
        StoreOrdersImage.setImage(new Image("StoreOrdersImage.jpg"));
        CurrentOrderImage.setImage(new Image("currentorderimage.jpg"));
    }

}
