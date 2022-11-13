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
        chicagoPizzaImage.setImage(new Image("chicagopizzaimage.jpg", 285, 215, false, false));
        NYPizzaImage.setImage(new Image("NYPizzaImage.jpg", 285, 215, false, false));
        StoreOrdersImage.setImage(new Image("StoreOrdersImage.jpg", 285, 215, false, false));
        CurrentOrderImage.setImage(new Image("currentorderimage.jpg", 285, 215, false, false));
    }

    public void switchChicago(javafx.scene.input.MouseEvent mouseEvent) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Chicago-Style-Pizza-Ordering.fxml"));
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setTitle("Chicago Pizza Order View!");
        stage.setScene(scene);
        stage.initModality(Modality.NONE);
        stage.show();
    }

    public void switchNewYork(javafx.scene.input.MouseEvent mouseEvent) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("New-York-Style-Pizza-Ordering.fxml"));
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setTitle("New York Pizza Order View!");
        stage.setScene(scene);
        stage.initModality(Modality.NONE);
        stage.show();
    }

    public void switchCurrentOrder(javafx.scene.input.MouseEvent mouseEvent) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Current-Order-View.fxml"));
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setTitle("Current Order View!");
        stage.setScene(scene);
        stage.initModality(Modality.NONE);
        stage.show();
    }

    public void switchStoreOrders(javafx.scene.input.MouseEvent mouseEvent) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Store-Orders-View.fxml"));
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setTitle("Store Orders View!");
        stage.setScene(scene);
        stage.initModality(Modality.NONE);
        stage.show();
    }
}
