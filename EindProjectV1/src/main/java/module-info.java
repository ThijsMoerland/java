module com.example.eindprojectv1 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.eindprojectv1 to javafx.fxml;
    exports com.example.eindprojectv1;
}