package Scaling;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Slider;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;

/*
 * created by Hesham Ouda
 * on 30.10.2022
 */

public class Scaling extends VBox {
	private RadioButton button;
	private Slider      slider;

	public Scaling() {
		initializeControls();
		layoutControls();
		setupBindings();
	}

	private void initializeControls() {
		button = new RadioButton("Scaled Button");
		slider = new Slider(1.0, 5.0, 1.0);
	}

	private void layoutControls() {
		setPadding(new Insets(10));
		setSpacing(10);
		setAlignment(Pos.CENTER);

		Node spacer = new Region();
		setVgrow(spacer, Priority.ALWAYS);

		VBox.setMargin(button, new Insets(140, 140, 140, 140));


		getChildren().addAll(button, spacer, slider);
	}

	private void setupBindings() {
		button.scaleXProperty().bind(slider.valueProperty());
		button.scaleYProperty().bind(slider.valueProperty());
	}

}
