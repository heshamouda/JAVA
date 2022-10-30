package Calculator.various.halloween;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.RowConstraints;

import java.util.ArrayList;

import static javafx.scene.paint.Color.rgb;

/*
 * created by @Hesham Ouda
 * on 30.10.2022
 */

public class CalculatorUI extends GridPane {

    private ArrayList<Button> numberButtons = new ArrayList<>();

    private Button dot;

    private Button plus;
    private Button minus;
    private Button multiply;
    private Button divide;

    private Button plusminus;

    private Button equal;
    private Button ac;

    private Label display;

    private Button netz;

    public CalculatorUI() {
        initializeSelf();
        initializeControls();
        layoutControls();
    }

    private void initializeSelf() {
        String stylesheet = getClass().getResource("style.css").toExternalForm();
        getStylesheets().add(stylesheet);

        getStyleClass().add("calc");
    }

    private void initializeControls() {

        for (int i = 0; i < 10; i++) {
            numberButtons.add(createButton(String.valueOf(i)));
        }

        dot = createButton2(".");
        plus = createButton2("+");
        minus = createButton2("-");
        multiply = createButton2("*");
        divide = createButton2("/");

        plusminus = createButton2("+/-");
        equal = createButton3("=");
        ac = createButton2("C");

        netz = createButton4("");

        display = new Label(" 0");
        display.setId("Zahl");
        display.setTextFill(rgb(255, 255, 255));
        display.setMaxWidth(Double.MAX_VALUE);

    }

    private Button createButton(String text) {
        Button button = new Button(text);
        button.setId("Numbers");
        button.setMaxWidth(90);
        button.setMaxHeight(90);
        return button;
    }

    private Button createButton2(String text) {
        Button button = new Button(text);
        button.setId("NotNumbers");
        button.setMaxWidth(90);
        button.setMaxHeight(70);

        return button;
    }

    private Button createButton3(String text) {
        Button button = new Button(text);
        button.setId("Equal");
        button.setMaxWidth(90);
        button.setMaxHeight(190);

        return button;
    }

    private Button createButton4(String text) {
        Button button = new Button(text);
        button.setId("Netz");
        button.setMaxWidth(90);
        button.setMaxHeight(90);

        return button;
    }

    private void layoutControls() {

        setGridLinesVisible(false);

        ColumnConstraints cc = new ColumnConstraints();
        cc.setHgrow(Priority.ALWAYS);
        getColumnConstraints().addAll(cc, cc, cc, cc);

        RowConstraints rc = new RowConstraints();
        rc.setVgrow(Priority.SOMETIMES);
        getRowConstraints().addAll(new RowConstraints(), rc, rc, rc, rc, rc);

        add(display, 0, 0, 1, 1);
        add(netz, 3, 0);

        add(ac, 0, 1);
        add(plusminus, 1, 1);
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

}
