package App2;

import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;

public class ApplicationUI extends StackPane {
    private Button btn1;

    public ApplicationUI() {
        initializecontrols();
        layoutControls();
    }

    private void layoutControls() {
        btn1 = new Button("Hellow World");
    }

    private void initializecontrols() {
        getChildren().add(btn1);
    }

}
