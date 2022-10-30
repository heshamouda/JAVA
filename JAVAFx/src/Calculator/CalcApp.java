package Calculator;

import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/*
 * created by @Hesham Ouda
 * on 30.10.2022
 */

public class CalcApp extends Application {

    @Override
    public void start(Stage primaryStage) {
        Parent rootPanel = new ClacUi();

        Scene scene = new Scene(rootPanel);

        primaryStage.setTitle("Calculator");
        primaryStage.setScene(scene);

        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}
