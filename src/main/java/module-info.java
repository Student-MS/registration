module com.example.firstguiapp {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.firstguiapp to javafx.fxml;
    exports com.example.firstguiapp;
}