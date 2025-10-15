package multiframesprogramm;

import javafx.application.Application;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.time.LocalDate;

public class MultiFramesProgramm extends Application {

    static Stage stageMain;

    // Переменные для варианта 18
    static String choiceBoxAnswer = "";        // Для типа механизма
    static LocalDate datePickerAnswer = null;  // Для даты
    static String radioButtonAnswer = "";      // Для материала ремешка
    static double sliderAnswer = 5000;         // Для цены
    @Override
    public void start(Stage stage) throws Exception {
        stageMain = stage;
        // Вот эта строка отвечает за иконку
        stage.getIcons().add(new Image("/images/icon.png"));
        stage.setScene(new SceneBuilder().getScene("1"));
        stage.setResizable(false);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}