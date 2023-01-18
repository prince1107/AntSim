module com.example.antsim {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.antsim to javafx.fxml;
    exports com.example.antsim;
}
