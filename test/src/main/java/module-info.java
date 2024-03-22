module com.test {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;

    opens com.test to javafx.fxml ;
    exports com.test;
}
