package multiframesprogramm;

import java.io.IOException;
import java.net.URL;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableView;

import static multiframesprogramm.MultiFramesProgramm.*;

public class FXMLFrame6Controller implements Initializable {

    @FXML
    private TableView<String[]> table;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        stageMain.setTitle("Результаты");
        Utils.buildTable(table, 4, 2, 35, 399, false, new String[]{"Вопрос", "Ответ"});

        table.getItems().get(0)[0] = "Тип механизма:";
        table.getItems().get(0)[1] = choiceBoxAnswer;

        table.getItems().get(1)[0] = "Дата доставки:";
        if (datePickerAnswer != null) {
            table.getItems().get(1)[1] = datePickerAnswer.format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));
        } else {
            table.getItems().get(1)[1] = "Не выбрана";
        }

        table.getItems().get(2)[0] = "Материал ремешка:";
        table.getItems().get(2)[1] = radioButtonAnswer;

        table.getItems().get(3)[0] = "Желаемая цена:";
        table.getItems().get(3)[1] = String.format("%.0f тг.", sliderAnswer);
    }

    @FXML
    private void frame6backbutton_action(ActionEvent event) throws IOException {
        stageMain.setScene(new SceneBuilder().getScene("5"));
    }

    @FXML
    private void frame6exitbutton_action(ActionEvent event) {
        stageMain.close();
    }
}