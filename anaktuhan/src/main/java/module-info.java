module anaktuhan {
    requires javafx.controls;
    requires javafx.fxml;
    requires transitive javafx.graphics;

    opens com.example.anaktuhan to javafx.fxml;
    exports com.example.anaktuhan;
}
