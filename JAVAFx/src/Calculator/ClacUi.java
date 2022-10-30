package Calculator;

import java.util.ArrayList;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.RowConstraints;

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
        ColumnConstraints cc = new ColumnConstraints();
        cc.setHgrow(Priority.ALWAYS);
        getColumnConstraints().addAll(cc, cc, cc, cc);

        RowConstraints rc = new RowConstraints();
        rc.setVgrow(Priority.ALWAYS);
        getRowConstraints().addAll(new RowConstraints(), rc, rc, rc, rc, rc);

        add(display, 0, 0, 4, 1);

        add(ac, 0, 1);
        add(plusMinus, 1, 1);
        add(divide, 2, 1);
        add(multiply, 3, 1);

        add(numberButtons.get(7), 0, 2);
        add(numberButtons.get(8), 1, 2);
        add(numberButtons.get(9), 2, 2);
        add(minus, 3, 2);

        add(numberButtons.get(4), 0, 3);
        add(numberButtons.get(5), 1, 3);
        add(numberButtons.get(6), 2, 3);
        add(plus, 3, 3);

        add(numberButtons.get(1), 0, 4);
        add(numberButtons.get(2), 1, 4);
        add(numberButtons.get(3), 2, 4);
        add(equal, 3, 4, 1, 2);

        add(numberButtons.get(0), 0, 5, 2, 1);
        add(dot, 2, 5);

    }

    private Button createButton(String textString) {
        Button btn = new Button(textString);
        btn.setMaxWidth(Double.MAX_VALUE);
        btn.setMaxHeight(Double.MAX_VALUE);

        return btn;
    }

}
