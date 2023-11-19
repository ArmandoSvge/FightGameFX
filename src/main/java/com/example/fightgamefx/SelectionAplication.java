package com.example.fightgamefx;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.util.Objects;

public class SelectionAplication extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(SelectionAplication.class.getResource("SelectionView.fxml"));
        Image icon = new Image(Objects.requireNonNull(getClass().getResourceAsStream("logo.png")));
        Scene scene = new Scene(fxmlLoader.load(),1000 , 580);

        scene.getStylesheets().add(getClass().getResource("styles.css").toExternalForm());
        stage.getIcons().add(icon);
        stage.setTitle("SPEC OPS");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}


