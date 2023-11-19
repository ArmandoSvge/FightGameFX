package com.example.fightgamefx;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.util.Duration;

import java.net.URL;
import java.util.ResourceBundle;

public class tableController implements Initializable {
    @FXML
    private TableColumn colJug1;
    private ObservableList<Personaje> personajes;
    @FXML
    private TableColumn colJug2;

    @FXML
    private TableColumn colWinner;

    @FXML
    private Label tableLabel;

    @FXML
    private TableView<Personaje> tbStadistics;

public void addPlayers(){
    String Per1 = null;
    String Per2 = null;
    String Winner = fightController.Realwinner;
    System.out.println(fightController.Realwinner);
    switch (Personaje.image2Path) {
        case "raider.gif":
Per2 = "Raider";
            break;
        case "lobo.png":

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
        case "lobo.png":

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
    personajes.add(playStatistic);
    tbStadistics.setItems(personajes);

    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        personajes = FXCollections.observableArrayList();
        this.colJug1.setCellValueFactory(new PropertyValueFactory("nombre"));
        this.colJug2.setCellValueFactory(new PropertyValueFactory("personaje2"));
        this.colWinner.setCellValueFactory(new PropertyValueFactory("winner"));
        addPlayers();
    }
}


