module com.example.project4 {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;
    requires org.testng;
    requires junit;


    opens com.example.project4 to javafx.fxml;

    exports com.example.project4;
}