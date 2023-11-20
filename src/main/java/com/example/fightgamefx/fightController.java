package com.example.fightgamefx;

import javafx.animation.KeyFrame;
import javafx.animation.PauseTransition;
import javafx.animation.Timeline;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.text.Font;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;
import java.net.URL;
import java.util.EventObject;
import java.util.Objects;
import java.util.Random;
import java.util.ResourceBundle;


public class fightController implements Initializable {

        @FXML
        private Button btnattack1;

        @FXML
        private Button btnattack2;
        @FXML
        private Label winnerLabel;



        @FXML
        private ImageView btnReplay;


        @FXML
        private Button btnspecial1;

        @FXML
        private Button btnspecial2;

        @FXML
        private ImageView personaje1;

        @FXML
        private ImageView personaje2;

        @FXML
        private ProgressBar progressBar1;

        @FXML
        private Button btnStart;

        @FXML
        private ImageView imgStart;
        @FXML
        private ImageView btnAttack;

        @FXML
        private ImageView btnAttack2;

        @FXML
        private ImageView btnSpecial;

        @FXML
        private ImageView btnSpecial2;

        @FXML
        private ProgressBar progressBar2;
        ResultTable resultTable;

        private boolean player1Turn = true;
        private boolean player2Turn = false;

        private MediaPlayer audioPlayer;

        static String Realwinner;
        private SelectionController selectionController;
        private boolean defenseActive = false;
        public fightController(SelectionController selectionController) {
                this.selectionController = selectionController;
        }
        public fightController() {
                // Default constructor
        }


        Personaje Lobo = new Personaje(100,"Lobo","WerewolfAttack.gif","WerewolfSpecial.gif","WerewolfShield.png");
        Personaje Raider = new Personaje(100,"Raider","RaiderHit.gif","RaiderSpecial.gif","RaiderShieldpng.png");
        Personaje Soldier = new Personaje(100,"Soldier","SoldierAttack.gif","SoldierShot_2.gif","SoldierShield.png");
        Personaje Vampire = new Personaje(100,"Vampire","VampireAttack.gif","VampireSpecial.gif","Vampireshield.png");
        Personaje Knight = new Personaje(100,"Knight","KnightAttack.gif","KnightSpecial.gif","KnightShield.png");
        @FXML
        private void handleAttack1() {
                if (player1Turn && progressBar2.getProgress() > 0 && !defenseActive) {
                        Image imgAtack;
                        Image imgEst;
                        Timeline timeline;
                        switch (Personaje.image1Path) {
                                case "raider.gif":
                                         imgAtack = new Image(Raider.pathAttack);
                                         imgEst = new Image(Personaje.image1Path);
                                        personaje1.setImage(imgAtack);

                                       timeline = new Timeline(new KeyFrame(
                                                Duration.seconds(1),
                                                event -> personaje1.setImage(imgEst)
                                        ));
                                        timeline.play();
                                        break;
                                case "lobo.gif":
                                        imgAtack = new Image(Lobo.pathAttack);
                                        imgEst = new Image(Personaje.image1Path);
                                        personaje1.setImage(imgAtack);

                                        timeline = new Timeline(new KeyFrame(
                                                Duration.seconds(1),
                                                event -> personaje1.setImage(imgEst)
                                        ));
                                        timeline.play();

                                        break;
                                case "soldier.gif":
                                       imgAtack = new Image(Soldier.pathAttack);
                                       imgEst = new Image(Personaje.image1Path);
                                        personaje1.setImage(imgAtack);

                                         timeline = new Timeline(new KeyFrame(
                                                Duration.seconds(1),
                                                event -> personaje1.setImage(imgEst)
                                        ));
                                        timeline.play();

                                        break;
                                case "vampire.gif":
                                        imgAtack = new Image(Vampire.pathAttack);
                                        imgEst = new Image(Personaje.image1Path);
                                        personaje1.setImage(imgAtack);

                                       timeline = new Timeline(new KeyFrame(
                                                Duration.seconds(1),
                                                event -> personaje1.setImage(imgEst)
                                        ));
                                        timeline.play();

                                        break;
                                case "knight.png":
                                       imgAtack = new Image(Knight.pathAttack);
                                        imgEst = new Image(Personaje.image1Path);
                                        personaje1.setImage(imgAtack);

                                       timeline = new Timeline(new KeyFrame(
                                                Duration.seconds(1),
                                                event -> personaje1.setImage(imgEst)
                                        ));
                                        timeline.play();

                                        break;

                        }


                        double randomDecrement = (new Random().nextDouble() * 0.2 + 0.1);
                        double newValue = progressBar2.getProgress() - randomDecrement;
                        progressBar2.setProgress(Math.max(0, newValue));

                        if (newValue >= 3) {
                                progressBar2.setProgress(0);
                        } else {
                                progressBar2.setProgress(newValue);
                        }

                        if (progressBar1.getProgress() <= 0 || progressBar2.getProgress() <= 0) {
                                checkGameStatus();
                        } else {
                                switchTurn();
                        }
                }
        }


        @FXML
        private void handleAttack2() {
                if (player2Turn && progressBar1.getProgress() > 0 && !defenseActive) {

                        Image imgAtack;
                        Image imgEst;
                        Timeline timeline;
                        switch (Personaje.image2Path) {
                                case "raider.gif":
                                        imgAtack = new Image(Raider.pathAttack);
                                        imgEst = new Image(Personaje.image2Path);
                                        personaje2.setImage(imgAtack);

                                        timeline = new Timeline(new KeyFrame(
                                                Duration.seconds(1),
                                                event -> personaje2.setImage(imgEst)
                                        ));
                                        timeline.play();
                                        break;
                                case "lobo.gif":
                                        imgAtack = new Image(Lobo.pathAttack);
                                        imgEst = new Image(Personaje.image2Path);
                                        personaje2.setImage(imgAtack);

                                        timeline = new Timeline(new KeyFrame(
                                                Duration.seconds(1),
                                                event -> personaje2.setImage(imgEst)
                                        ));
                                        timeline.play();

                                        break;
                                case "soldier.gif":
                                        imgAtack = new Image(Soldier.pathAttack);
                                        imgEst = new Image(Personaje.image2Path);
                                        personaje2.setImage(imgAtack);

                                        timeline = new Timeline(new KeyFrame(
                                                Duration.seconds(1),
                                                event -> personaje2.setImage(imgEst)
                                        ));
                                        timeline.play();

                                        break;
                                case "vampire.gif":
                                        imgAtack = new Image(Vampire.pathAttack);
                                        imgEst = new Image(Personaje.image2Path);
                                        personaje2.setImage(imgAtack);

                                        timeline = new Timeline(new KeyFrame(
                                                Duration.seconds(1),
                                                event -> personaje2.setImage(imgEst)
                                        ));
                                        timeline.play();

                                        break;
                                case "knight.png":
                                        imgAtack = new Image(Knight.pathAttack);
                                        imgEst = new Image(Personaje.image2Path);
                                        personaje2.setImage(imgAtack);

                                        timeline = new Timeline(new KeyFrame(
                                                Duration.seconds(1),
                                                event -> personaje2.setImage(imgEst)
                                        ));
                                        timeline.play();

                                        break;

                        }



                        double randomDecrement = (new Random().nextDouble() * 0.2 + 0.1);
                        double newValue = progressBar1.getProgress() - randomDecrement;
                        progressBar1.setProgress(Math.max(0, newValue));
                        if (newValue >= 3) {
                                progressBar2.setProgress(0);
                        } else {
                                progressBar2.setProgress(newValue);
                        }
                        if (progressBar1.getProgress() <= 0 || progressBar2.getProgress() <= 0) {
                                checkGameStatus();
                        } else {
                                switchTurn();
                        }

                }
        }

        @FXML
        private void handleSpecial1() {
                if (player1Turn && progressBar2.getProgress() > 0 && !defenseActive) {
                        Image imgAtack;
                        Image imgEst;
                        Timeline timeline;
                        switch (Personaje.image1Path) {
                                case "raider.gif":
                                        imgAtack = new Image(Raider.pathSpecial);
                                        imgEst = new Image(Personaje.image1Path);
                                        personaje1.setImage(imgAtack);

                                        timeline = new Timeline(new KeyFrame(
                                                Duration.seconds(1),
                                                event -> personaje1.setImage(imgEst)
                                        ));
                                        timeline.play();
                                        break;
                                case "lobo.gif":
                                        imgAtack = new Image(Lobo.pathSpecial);
                                        imgEst = new Image(Personaje.image1Path);
                                        personaje1.setImage(imgAtack);

                                        timeline = new Timeline(new KeyFrame(
                                                Duration.seconds(1),
                                                event -> personaje1.setImage(imgEst)
                                        ));
                                        timeline.play();

                                        break;
                                case "soldier.gif":
                                        imgAtack = new Image(Soldier.pathSpecial);
                                        imgEst = new Image(Personaje.image1Path);
                                        personaje1.setImage(imgAtack);

                                        timeline = new Timeline(new KeyFrame(
                                                Duration.seconds(1),
                                                event -> personaje1.setImage(imgEst)
                                        ));
                                        timeline.play();

                                        break;
                                case "vampire.gif":
                                        imgAtack = new Image(Vampire.pathSpecial);
                                        imgEst = new Image(Personaje.image1Path);
                                        personaje1.setImage(imgAtack);

                                        timeline = new Timeline(new KeyFrame(
                                                Duration.seconds(1),
                                                event -> personaje1.setImage(imgEst)
                                        ));
                                        timeline.play();

                                        break;
                                case "knight.png":
                                        imgAtack = new Image(Knight.pathSpecial);
                                        imgEst = new Image(Personaje.image1Path);
                                        personaje1.setImage(imgAtack);

                                        timeline = new Timeline(new KeyFrame(
                                                Duration.seconds(1),
                                                event -> personaje1.setImage(imgEst)
                                        ));
                                        timeline.play();

                                        break;

                        }

                        double randomDecrement = (new Random().nextDouble() * 0.05 + 0.4);
                        double newValue = progressBar2.getProgress() - randomDecrement;
                        progressBar2.setProgress(Math.max(0, newValue));

                        if (newValue >= 3) {
                                progressBar2.setProgress(0);
                        } else {
                                progressBar2.setProgress(newValue);
                        }
                        if (progressBar1.getProgress() <= 0 || progressBar2.getProgress() <= 0) {
                                checkGameStatus();
                        } else {
                                switchTurn();
                        }
                }
        }

        @FXML
        private void handleSpecial2() {
                if (player2Turn && progressBar1.getProgress() > 0 && !defenseActive) {
                        Image imgAtack;
                        Image imgEst;
                        Timeline timeline;
                        switch (Personaje.image2Path) {
                                case "raider.gif":
                                        imgAtack = new Image(Raider.pathSpecial);
                                        imgEst = new Image(Personaje.image2Path);
                                        personaje2.setImage(imgAtack);

                                        timeline = new Timeline(new KeyFrame(
                                                Duration.seconds(1),
                                                event -> personaje2.setImage(imgEst)
                                        ));
                                        timeline.play();
                                        break;
                                case "lobo.gif":
                                        imgAtack = new Image(Lobo.pathSpecial);
                                        imgEst = new Image(Personaje.image2Path);
                                        personaje2.setImage(imgAtack);

                                        timeline = new Timeline(new KeyFrame(
                                                Duration.seconds(1),
                                                event -> personaje2.setImage(imgEst)
                                        ));
                                        timeline.play();

                                        break;
                                case "soldier.gif":
                                        imgAtack = new Image(Soldier.pathSpecial);
                                        imgEst = new Image(Personaje.image2Path);
                                        personaje2.setImage(imgAtack);

                                        timeline = new Timeline(new KeyFrame(
                                                Duration.seconds(1),
                                                event -> personaje2.setImage(imgEst)
                                        ));
                                        timeline.play();

                                        break;
                                case "vampire.gif":
                                        imgAtack = new Image(Vampire.pathSpecial);
                                        imgEst = new Image(Personaje.image2Path);
                                        personaje2.setImage(imgAtack);

                                        timeline = new Timeline(new KeyFrame(
                                                Duration.seconds(1),
                                                event -> personaje2.setImage(imgEst)
                                        ));
                                        timeline.play();

                                        break;
                                case "knight.png":
                                        imgAtack = new Image(Knight.pathSpecial);
                                        imgEst = new Image(Personaje.image2Path);
                                        personaje2.setImage(imgAtack);

                                        timeline = new Timeline(new KeyFrame(
                                                Duration.seconds(1),
                                                event -> personaje2.setImage(imgEst)
                                        ));
                                        timeline.play();

                                        break;

                        }

                        double randomDecrement = (new Random().nextDouble() * 0.05 + 0.4);
                        double newValue = progressBar1.getProgress() - randomDecrement;
                        progressBar1.setProgress(Math.max(0, newValue));
                        if (newValue >= 3) {
                                progressBar2.setProgress(0);
                        } else {
                                progressBar2.setProgress(newValue);
                        }
                        if (progressBar1.getProgress() <= 0 || progressBar2.getProgress() <= 0) {
                                checkGameStatus();
                        } else {
                                switchTurn();
                        }
                }
        }


        private void switchTurn() {

                player1Turn = !player1Turn;
                player2Turn = !player2Turn;
        }
        private void checkGameStatus() {
                if (progressBar1.getProgress() <= 0 || progressBar2.getProgress() <= 0) {

                        btnattack1.setDisable(true);
                        btnattack2.setDisable(true);
                        btnspecial1.setDisable(true);
                        btnspecial2.setDisable(true);


                        if (progressBar1.getProgress() <= 0) {
                                showWinner("Personaje 2");
                        } else {
                                showWinner("Personaje 1");
                        }


                }
        }

        private void showWinner(String winner) {
                Font customFont = Font.loadFont(getClass().getResource("blood.ttf").toExternalForm(), 140);
                winnerLabel.setFont(customFont);
                winnerLabel.setText("¡El ganador es " + winner + "!");
                winnerLabel.setVisible(true);
                Realwinner = winner;
                addPlayers();

                openNewInterface();
        }
        public void addPlayers(){
                String Per1 = null;
                String Per2 = null;
                String Winner = fightController.Realwinner;
                System.out.println(fightController.Realwinner);
                switch (Personaje.image2Path) {
                        case "raider.gif":
                                Per2 = "Raider";
                                break;
                        case "lobo.gif":

                                Per2 = "Lobo";
                                break;
                        case "soldier.gif":
                                Per2 = "Soldier";
                                break;
                        case "vampire.gif":
                                Per2 = "Vampire";

                                break;
                        case "knight.png":
                                Per2 = "Knight";

                                break;

                }
                switch (Personaje.image1Path) {
                        case "raider.gif":
                                Per1 = "Raider";
                                break;
                        case "lobo.gif":

                                Per1 = "Lobo";
                                break;
                        case "soldier.gif":
                                Per1 = "Soldier";
                                break;
                        case "vampire.gif":
                                Per1 = "Vampire";

                                break;
                        case "knight.png":
                                Per1 = "Knight";

                                break;


                }
                Personaje playStatistic = new Personaje(Per1,Per2,Winner);
                ResultTable.addCombatResult(playStatistic);

        }
        @FXML
        private void openNewInterface() {
                try {
                        Stage currentStage = (Stage) winnerLabel.getScene().getWindow();
                        FXMLLoader loader = new FXMLLoader(getClass().getResource("TableView.fxml"));
                        Parent root = loader.load();
                        tableController controller = loader.getController();

                        Scene scene = new Scene(root);

                        currentStage.hide();
                        Image icon = new Image(Objects.requireNonNull(getClass().getResourceAsStream("logo.png")));
                        Stage stage = new Stage();
                        stage.initModality(Modality.APPLICATION_MODAL);
                        stage.setScene(scene);
                        stage.setWidth(700);
                        stage.setHeight(450);
                        stage.getIcons().add(icon);
                        stage.setTitle("SPEC OPS");
                        stage.show();
                } catch (IOException e) {
                        e.printStackTrace();
                }
        }


        private void updateGameStatus() {
                checkGameStatus();
        }
        @FXML
        private void Start(MouseEvent event) throws InterruptedException {
                reproducirAudioOnce("EscenaFight.wav");
                btnStart.setVisible(false);
                imgStart.setVisible(false);
                btnattack1.setVisible(true);
                btnattack2.setVisible(true);
                btnspecial1.setVisible(true);
                btnspecial2.setVisible(true);
                progressBar1.setVisible(true);
                progressBar2.setVisible(true);

                initializeImageControls();
                reproducirAudioLoop("battle_sound.wav");
        }

        private void reproducirAudioOnce(String song) {
                URL resource = getClass().getResource(song);
                if (resource != null) {
                        Media media = new Media(resource.toExternalForm());
                        MediaPlayer mediaPlayer = new MediaPlayer(media);
                        mediaPlayer.setOnError(() -> {
                                System.err.println("Error al reproducir el audio: " + mediaPlayer.getError());
                        });
                        mediaPlayer.setOnEndOfMedia(() -> {
                                mediaPlayer.dispose();
                        });
                        mediaPlayer.play();
                        System.out.println("Reproduciendo");
                } else {
                        System.err.println("Archivo de audio no encontrado: " + song);
                }
        }

        private void reproducirAudioLoop(String song) throws InterruptedException {
                Thread.sleep(1000);
                URL resource = getClass().getResource(song);
                if (resource != null) {
                        Media media = new Media(resource.toExternalForm());
                        if (audioPlayer != null) {
                                audioPlayer.stop();
                        }
                        audioPlayer = new MediaPlayer(media);
                        audioPlayer.setVolume(0.3);
                        audioPlayer.setOnError(() -> {
                                System.err.println("Error al reproducir el audio: " + audioPlayer.getError());
                        });
                        audioPlayer.setOnEndOfMedia(() -> {
                                audioPlayer.seek(Duration.ZERO);
                        });
                        audioPlayer.setCycleCount(MediaPlayer.INDEFINITE);
                        audioPlayer.play();
                        System.out.println("Reproduciendo");
                } else {
                        System.err.println("Archivo de audio no encontrado: " + song);
                }
        }

        public void setImagePaths(String image1Path, String image2Path) {
                Personaje.image1Path = image1Path;
                Personaje.image2Path = image2Path;

                System.out.println("Ruta de imagen 1: " + Personaje.image1Path);
                System.out.println("Ruta de imagen 2: " + Personaje.image2Path);
        }

        public void initializeImageControls() {
                setImagePaths(Personaje.image1Path, Personaje.image2Path);
                System.out.println("Ruta de imagen 1111: " + Personaje.image1Path);
                System.out.println("Ruta de imagen 2111: " + Personaje.image2Path);
                if (Personaje.image1Path != null && Personaje.image2Path != null) {
                        Image image1 = new Image(Personaje.image1Path);
                        Image image2 = new Image(Personaje.image2Path);

                        personaje1.setImage(image1);
                        personaje2.setImage(image2);
                }




        }

        @Override
        public void initialize(URL url, ResourceBundle resourceBundle) {
                btnStart.setGraphic(imgStart);
                btnattack1.setVisible(false);
                btnattack2.setVisible(false);
                btnspecial1.setVisible(false);
                btnspecial2.setVisible(false);
                progressBar1.setVisible(false);
                progressBar2.setVisible(false);
                btnattack1.setGraphic(btnAttack);
                btnattack2.setGraphic(btnAttack2);
                btnspecial1.setGraphic(btnSpecial);
                btnspecial2.setGraphic(btnSpecial2);




        }


}



