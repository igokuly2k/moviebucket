module com.igokuly2k.favouritemovies {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;

    opens com.igokuly2k.favouritemovies to javafx.fxml;
    exports com.igokuly2k.favouritemovies;
}
