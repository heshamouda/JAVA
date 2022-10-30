package Calculator;

import java.util.ArrayList;

import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class ClacUi extends GridPane {

    private ArrayList<Button> numberButtons = new ArrayList<>();

    private Button dot;
    private Button minus;
    private Button plus;
    private Button divide;
    private Button multiply;

    private Button plusMinus;
    private Button equal;
    private Button ac;

    private Label display;

    public ClacUi() {
        intializeControls();
        layoutControls();
    }

    private void intializeControls() {
        for (int i = 0; i < 10; i++) {
            numberButtons.add(createButton(String.valueOf(i)));

            dot = createButton(".");
            plus = createButton("+");
            minus = createButton("-");
            multiply = createButton("*");
            divide = createButton("/");

            plusMinus = createButton("+/-");
            equal = createButton("=");
            ac = createButton("C");

            display = new Label("0");
            display.setMaxWidth(Double.MAX_VALUE);
        }
    }

    private void layoutControls() {

    }

    private Button createButton(String textString) {
        Button btn = new Button(textString);
        btn.setMaxWidth(Double.MAX_VALUE);
        btn.setMaxHeight(Double.MAX_VALUE);

        return btn;
    }

}
