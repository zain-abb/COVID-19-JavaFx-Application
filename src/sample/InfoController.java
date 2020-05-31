package sample;

import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.util.Duration;
import java.io.File;

public class InfoController {

    @FXML
    private AnchorPane firstVideoPane;

    @FXML
    private AnchorPane secondVideoPane;

    private static final String firstVideo = "C://Users/zaina/OneDrive/Desktop/Projects/Zain Abbas/1/src/sample/Covid19-howtoprotectyourself.mp4";
    private static final String secondVideo = "C://Users/zaina/OneDrive/Desktop/Projects/Zain Abbas/1/src/sample/Prevention of COVID-19 in the Workplace.mp4";

    @FXML
    void initialize() {
        assert firstVideoPane != null : "fx:id=\"firstVideoPane\" was not injected: check your FXML file 'info.fxml'.";
        assert secondVideoPane != null : "fx:id=\"secondVideoPane\" was not injected: check your FXML file 'info.fxml'.";

        media(firstVideo, firstVideoPane);
        media(secondVideo, secondVideoPane);
    }

    public void media(String filename, AnchorPane mainPane) {
        Media media = new Media(new File(filename).toURI().toString());
        MediaPlayer mediaPlayer = new MediaPlayer(media);
        MediaView mediaView = new MediaView(mediaPlayer);
        mediaView.fitWidthProperty().set(675);
        mediaView.fitHeightProperty().set(400);

        Button playButton = new Button("Play");
        playButton.setOnAction(e -> {
            if (playButton.getText().equals("Play")) {
                mediaPlayer.play();
                playButton.setText("Pause");
            } else {
                mediaPlayer.pause();
                playButton.setText("Pause");
            }
        });

        Button rewindButton = new Button("<<");
        rewindButton.setOnAction(e -> mediaPlayer.seek(Duration.ZERO));

        Slider slVolume = new Slider();
        slVolume.setPrefWidth(150);
        slVolume.setMaxWidth(Region.USE_PREF_SIZE);
        slVolume.setMinWidth(30);
        slVolume.setValue(50);
        mediaPlayer.volumeProperty().bind(
                slVolume.valueProperty().divide(100));

        HBox hBox = new HBox(10);
        hBox.setAlignment(Pos.CENTER);
        hBox.getChildren().addAll(playButton, rewindButton,
                new Label("Volume"), slVolume);

        BorderPane pane = new BorderPane();
        pane.setCenter(mediaView);
        pane.setBottom(hBox);
        pane.setMaxSize(675, 400);

        mainPane.getChildren().setAll(pane);
    }
}
