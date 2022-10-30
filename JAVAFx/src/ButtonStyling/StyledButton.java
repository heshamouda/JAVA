package ButtonStyling;

import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;

/*
 * created by @Hesham Ouda
 * on 30.10.2022
 */

public class StyledButton extends StackPane {
	private Button button;

	public StyledButton() {
        initializeSelf();
		initializeControls();
		layoutControls();
	}

	private void initializeSelf(){
        String stylesheet = getClass().getResource("style.css").toExternalForm();
 		getStylesheets().add(stylesheet);
    }

	private void initializeControls() {
		button = new Button("Hello World");
	}

	private void layoutControls() {
		getChildren().add(button);
	}

}
