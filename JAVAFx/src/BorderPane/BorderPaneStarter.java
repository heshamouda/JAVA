package BorderPane;

import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/*
 * created by @Hesham Ouda
 * on 30.10.2022
 */

public class BorderPaneStarter extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
		Parent rootPanel = new BorderPaneTemplate();

		Scene scene = new Scene(rootPanel);

		primaryStage.setTitle("");
		primaryStage.setScene(scene);

		primaryStage.centerOnScreen();
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}
