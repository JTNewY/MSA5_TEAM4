module com.team4 {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;

    opens com.team4 to  javafx.graphics, javafx.fxml;
    exports com.team4;
}
