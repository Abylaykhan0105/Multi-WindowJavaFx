package multiframesprogramm;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;

import static multiframesprogramm.MultiFramesProgramm.radioButtonAnswer;
import static multiframesprogramm.MultiFramesProgramm.stageMain;

public class FXMLFrame4Controller implements Initializable {

    @FXML
    private Label radioButtonLabel;
    @FXML
    private ToggleGroup strapGroup;
    @FXML
    private RadioButton rb1; // Кожа

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        stageMain.setTitle("Материал ремешка");

        if (radioButtonAnswer.isEmpty()) {
            strapGroup.selectToggle(rb1);
        } else {
            // Используем 'toggle' вместо 'rb', чтобы не было конфликта
            strapGroup.getToggles().forEach(toggle -> {
                RadioButton button = (RadioButton) toggle;
                if (button.getText().equals(radioButtonAnswer)) {
                    strapGroup.selectToggle(button);
                }
            });
        }
        updateLabel();

        strapGroup.selectedToggleProperty().addListener((observable, oldValue, newValue) -> {
            updateLabel();
        });
    }

    private void updateLabel() {
        RadioButton selected = (RadioButton) strapGroup.getSelectedToggle();
        if (selected != null) {
            radioButtonAnswer = selected.getText();
            radioButtonLabel.setText("Выбрано: " + radioButtonAnswer);
        }
    }

    @FXML
    private void frame4backbutton_action(ActionEvent event) throws IOException {
        stageMain.setScene(new SceneBuilder().getScene("3"));
    }

    @FXML
    private void frame4nextbutton_action(ActionEvent event) throws IOException {
        stageMain.setScene(new SceneBuilder().getScene("5"));
    }
}