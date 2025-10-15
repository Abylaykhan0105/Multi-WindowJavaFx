package multiframesprogramm;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;

import static multiframesprogramm.MultiFramesProgramm.datePickerAnswer;
import static multiframesprogramm.MultiFramesProgramm.stageMain;

public class FXMLFrame3Controller implements Initializable {

    @FXML
    private Label dateLabel;
    @FXML
    private DatePicker datePicker;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        stageMain.setTitle("Дата доставки");

        datePicker.setValue(datePickerAnswer != null ? datePickerAnswer : LocalDate.now());
        updateLabel();

        datePicker.valueProperty().addListener((observable, oldValue, newValue) -> {
            updateLabel();
        });
    }

    private void updateLabel() {
        datePickerAnswer = datePicker.getValue();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        dateLabel.setText("Выбрано: " + datePickerAnswer.format(formatter));
    }

    @FXML
    private void frame3backbutton_action(ActionEvent event) throws IOException {
        stageMain.setScene(new SceneBuilder().getScene("2"));
    }

    @FXML
    private void frame3nextbutton_action(ActionEvent event) throws IOException {
        stageMain.setScene(new SceneBuilder().getScene("4"));
    }
}