module com.example.sistemaabc {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires postgresql;


    opens com.example.sistemaabc to javafx.fxml;
    exports com.example.sistemaabc;

    exports POJO;
    opens POJO to javafx.fxml;
}