module com.example.fightgamefx {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.media;


    opens com.example.fightgamefx to javafx.fxml;
    exports com.example.fightgamefx;
}