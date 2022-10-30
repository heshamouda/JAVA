package App2;

import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;

public class ApplicationUI extends StackPane {
    private Button btn1;

    public ApplicationUI() {
        initializeControls();
        layoutControls();
    }

    private void initializeControls() {

        btn1 = new Button("Hellow World");
    }

    private void layoutControls() {
        getChildren().add(btn1);
    }

}
