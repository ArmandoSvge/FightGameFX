package com.example.fightgamefx;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;
import java.net.URL;
import java.util.Objects;
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
    private Button btnRestart;

    @FXML
    private TableView<Personaje> tbStadistics;


    @FXML
    private void replayInterface(MouseEvent event) {
        try {

            Stage currentStage = (Stage) tableLabel.getScene().getWindow();


            FXMLLoader loader = new FXMLLoader(getClass().getResource("SelectionView.fxml"));
            Parent root = loader.load();


            SelectionController controller = loader.getController();


            Image icon = new Image(Objects.requireNonNull(getClass().getResourceAsStream("logo.png")));
            Scene scene = new Scene(root);
            scene.getStylesheets().add(getClass().getResource("styles.css").toExternalForm());


            currentStage.hide();


            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setScene(scene);
            stage.setWidth(1055);
            stage.setHeight(580);
            stage.getIcons().add(icon);
            stage.setTitle("SPEC OPS");
            stage.showAndWait();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        personajes = FXCollections.observableArrayList();
        ObservableList<Personaje> results = ResultTable.getCombatResults();
        this.colJug1.setCellValueFactory(new PropertyValueFactory("nombre"));
        this.colJug2.setCellValueFactory(new PropertyValueFactory("personaje2"));
        this.colWinner.setCellValueFactory(new PropertyValueFactory("winner"));
        tbStadistics.setItems(results);

    }
}


