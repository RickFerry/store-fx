module com.example.storefx {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;


    opens com.example.storefx to javafx.fxml;
    exports com.example.storefx;
}