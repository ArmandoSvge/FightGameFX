package com.example.fightgamefx;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Font;
import javafx.stage.Modality;
import javafx.stage.Stage;


import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

public class HelloController implements Initializable {
    @FXML
    private Label SpecialOps;
    private SelectionController selectionController;

    @FXML
    private Label theGame;


    @FXML
    private Button btnPlay;

    @FXML
    private ImageView imagen1;




    @FXML
    private void openNewInterface(ActionEvent event) {
        try {

            Stage currentStage = (Stage) ((Node) event.getSource()).getScene().getWindow();

            FXMLLoader loader = new FXMLLoader(getClass().getResource("SelectionView.fxml"));
            Parent root = loader.load();
            SelectionController controller = loader.getController();
            Image icon = new Image(Objects.requireNonNull(getClass().getResourceAsStream("logo.png")));

            Scene scene = new Scene(root);
            scene.getStylesheets().add(getClass().getResource("stylesSelection.css").toExternalForm());


            currentStage.hide();


            Stage stage = new Stage();
            stage.getIcons().add(icon);
            stage.setTitle("SPEC OPS");
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setScene(scene);
            stage.setWidth(1055);
            stage.setHeight(580);
            stage.showAndWait();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {


            Font customFont = Font.loadFont(getClass().getResource("blood.ttf").toExternalForm(), 140);
            Font customFont2 = Font.loadFont(getClass().getResource("blood.ttf").toExternalForm(), 88);
            SpecialOps.setFont(customFont);
            SpecialOps.setText("Special Ops");
            theGame.setFont(customFont2);
            btnPlay.setGraphic(imagen1);
            selectionController = new SelectionController();




        }
    }






