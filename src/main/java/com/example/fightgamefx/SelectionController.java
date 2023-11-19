package com.example.fightgamefx;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.scene.text.Font;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.util.Duration;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class SelectionController implements Initializable {

    @FXML
    private ImageView imgKnight;
    @FXML
    private MediaView mediaView;

    @FXML
    private ImageView imgLobo;

    @FXML
    private ImageView imgRaider;

    @FXML
    private ImageView imgSoldier;

    @FXML
    private ImageView imgVampiro;

    @FXML
    private Label selectPnj;
    @FXML
    private Stage primaryStage;
    private MouseEvent storedMouseEvent;

    private ImageView firstClickedImage = null;
    private ImageView secondClickedImage = null;
    private String selectedImage1Path;
    private String selectedImage2Path;

    public SelectionController() {
    }

    @FXML
    private void abrirNuevaInterfaz(MouseEvent event) {
        ImageView clickedImage = (ImageView) event.getSource();

        if (firstClickedImage == null) {
            firstClickedImage = clickedImage;
            firstClickedImage.setOpacity(0.5);
            selectedImage1Path = getImagePathForImageView(clickedImage);
        } else if (secondClickedImage == null && firstClickedImage != clickedImage) {
            secondClickedImage = clickedImage;
            secondClickedImage.setOpacity(0.5);
            selectedImage2Path = getImagePathForImageView(clickedImage);


            cargarFightController();
        }
    }

    private void cargarFightController() {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("fight.fxml"));
        Parent root;
        try {
            root = loader.load();
            fightController fightController = loader.getController();
            fightController.setImagePaths(selectedImage1Path, selectedImage2Path);

            // Configura la escena y la nueva ventana
            Scene scene = new Scene(root);
            Stage newStage = new Stage();
            newStage.initModality(Modality.APPLICATION_MODAL);
            newStage.setScene(scene);
            newStage.setWidth(1655);
            newStage.setHeight(850);

            // Obtiene la referencia de la ventana actual
            Stage currentStage = (Stage) imgKnight.getScene().getWindow();

            // Oculta y cierra la ventana actual al mostrar la nueva ventana
            currentStage.hide();
            newStage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private String getImagePathForImageView(ImageView imageView) {
        String id = imageView.getId();

        if ("imgRaider".equals(id)) {
            return "raider.gif";
        } else if ("imgLobo".equals(id)) {
            return "lobo.gif";
        } else if ("imgSoldier".equals(id)) {
            return "soldier.gif";
        } else if ("imgVampiro".equals(id)) {
            return "vampire.gif";
        } else if ("imgKnight".equals(id)) {
            return "knight.png";
        } else {
            return null;
        }
    }



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Font customFont = Font.loadFont(getClass().getResource("blood.ttf").toExternalForm(), 88);
        selectPnj.setFont(customFont);
    }
}
