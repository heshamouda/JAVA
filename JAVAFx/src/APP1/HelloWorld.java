package APP1;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/*
 * created by @Hesham Ouda
 * on 30.10.2022
 */

public class HelloWorld extends Application {

    @Override
    public void start(Stage primaryStage) {
        Button btn1 = new Button("Hello World");

        StackPane rootPane = new StackPane();
        rootPane.getChildren().add(btn1);

        Scene myScene = new Scene(rootPane);

        primaryStage.setTitle("JavaFX App1");
        primaryStage.setScene(myScene);
        primaryStage.setWidth(400);
        primaryStage.setHeight(300);
        primaryStage.show();

    }

    public static void main(String[] args) {
        launch(args);
    }

}
