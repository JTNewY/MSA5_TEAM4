module com.team4 {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.team4 to javafx.fxml;
    exports com.team4;
}
