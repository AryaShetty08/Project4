package com.example.project4;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;

/**
 * Driver class to run Project 4
 * @author Arya Shetty, John Greaney-Cheng
 */
public class MainApplication extends Application {

    /**
     * Initializes stage and scene for Pizza Main View GUI
     * Defines stage qualities such as:
     *  - size of window
     *  - title
     * @param stage the window that contains Pizza Main View GUI scene
     * @throws IOException throws IOException to check fxmlLoader exceptions
     */
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("Main-View.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 891, 656);
        stage.setTitle("Mr.Pizza Main View!");
        stage.setScene(scene);
        stage.show();
    }

    /**
     * Launches JavaFX Application
     * @param args Standard main parameter
     */
    public static void main(String[] args) {
        launch();
    }
}