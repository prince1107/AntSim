module com.example.spaceporttycoon {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.spaceporttycoon to javafx.fxml;
    exports com.example.spaceporttycoon;
}
