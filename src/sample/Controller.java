package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class Controller {

    @FXML
    private Button homeButton;

    @FXML
    private Button statisticsButton;

    @FXML
    private Button infoButton;

    @FXML
    private ScrollPane mainPane;

    @FXML
    void initialize() {
        assert mainPane != null : "fx:id=\"mainPane\" was not injected: check your FXML file 'main.fxml'.";
        assert homeButton != null : "fx:id=\"homeButton\" was not injected: check your FXML file 'main.fxml'.";
        assert statisticsButton != null : "fx:id=\"statisticsButton\" was not injected: check your FXML file 'main.fxml'.";
        assert infoButton != null : "fx:id=\"infoButton\" was not injected: check your FXML file 'main.fxml'.";
    }

    @FXML
    void homeButtonClick(ActionEvent event) {
        setPane("home.fxml");
    }

    @FXML
    void infoButtonClick(ActionEvent event) {
        setPane("info.fxml");
    }

    @FXML
    void statisticsButtonClick(ActionEvent event) {
        setPane("statistics.fxml");
    }

    public void setPane(String name) {
        try {
            AnchorPane pane = FXMLLoader.load(getClass().getResource(name));
            mainPane.setContent(pane);
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }
}
