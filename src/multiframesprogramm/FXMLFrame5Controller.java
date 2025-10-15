package multiframesprogramm;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;

import static multiframesprogramm.MultiFramesProgramm.sliderAnswer;
import static multiframesprogramm.MultiFramesProgramm.stageMain;

public class FXMLFrame5Controller implements Initializable {

    @FXML
    private Label sliderLabel;
    @FXML
    private Slider slider;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        stageMain.setTitle("Цена");
        slider.setValue(sliderAnswer);
        updateLabel(sliderAnswer);

        slider.valueProperty().addListener((ObservableValue<? extends Number> observable, Number oldValue, Number newValue) -> {
            updateLabel(newValue.doubleValue());
        });
    }

    private void updateLabel(double value) {
        sliderAnswer = value;
        sliderLabel.setText(String.format("Выбрано: %.0f тг.", value));
    }

    @FXML
    private void frame5backbutton_action(ActionEvent event) throws IOException {
        stageMain.setScene(new SceneBuilder().getScene("4"));
    }

    @FXML
    private void frame5nextbutton_action(ActionEvent event) throws IOException {
        stageMain.setScene(new SceneBuilder().getScene("6"));
    }
}