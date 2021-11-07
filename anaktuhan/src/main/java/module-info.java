module anaktuhan {
    requires javafx.controls;
    requires javafx.fxml;
    requires transitive javafx.graphics;
    requires java.sql;
    requires sqlite.jdbc;

    opens com.example.anaktuhan to javafx.fxml;
    exports com.example.anaktuhan;
    exports com.example.anaktuhan.modal;
    exports com.example.anaktuhan.database;
}
