package com.example.project4;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class ChicagoStylePizzaOrderingController {
    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }
}