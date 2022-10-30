package Calculator.various.hostettler;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.effect.BlurType;
import javafx.scene.effect.DropShadow;
import javafx.scene.effect.InnerShadow;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.RowConstraints;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

import java.util.ArrayList;

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
    private Button modulo;

    private Button mc;

    private Button equal;
    private Button ac;

    private Label display;

    public CalculatorUI() {
        initializeControls();
        initializeSelf();
        layoutControls();
    }

    private void initializeSelf() {
        String stylesheet = getClass().getResource("style.css").toExternalForm();
        getStylesheets().add(stylesheet);
        getStylesheets().add("https://fonts.googleapis.com/css?family=Montserrat&display=swap");

    }

    private void initializeControls() {

        for (int i = 0; i < 10; i++) {
            numberButtons.add(createButton(String.valueOf(i)));
        }
        dot = createButton(".");
        plus = createButton("+");
        minus = createButton("-");
        multiply = createButton("*");
        divide = createButton("/");
        modulo = createButton("%");

        mc = createButton("MC");
        equal = createButton("=");
        ac = createButton("AC");

        display = new Label("0");
        display.setMaxWidth(Double.MAX_VALUE);

    }

    private Button createButton(String text) {

        // Shadows (as you can't add two dropshadows in the CSS//

        // Create DropShadow dark//
        DropShadow shadow = new DropShadow();
        shadow.setBlurType(BlurType.THREE_PASS_BOX);
        shadow.setColor(Color.rgb(209, 205, 199, 0.5));
        shadow.setRadius(16);
        shadow.setSpread(0);
        shadow.setOffsetX(6);
        shadow.setOffsetY(6);

        // Create DropShadow light//
        DropShadow lightShadow = new DropShadow();
        lightShadow.setBlurType(BlurType.THREE_PASS_BOX);
        lightShadow.setColor(Color.rgb(255, 255, 255, 0.5));
        lightShadow.setRadius(16);
        lightShadow.setSpread(0);
        lightShadow.setOffsetX(-6);
        lightShadow.setOffsetY(-6);

        // Chain the shadows together//
        shadow.setInput(lightShadow);

        //

        InnerShadow clickShadow = new InnerShadow();
        clickShadow.setBlurType(BlurType.THREE_PASS_BOX);
        clickShadow.setColor(Color.rgb(209, 205, 199, 0.5));
        clickShadow.setRadius(16);
        clickShadow.setOffsetX(6);
        clickShadow.setOffsetY(6);

        InnerShadow clickShadowLight = new InnerShadow();
        clickShadowLight.setBlurType(BlurType.THREE_PASS_BOX);
        clickShadowLight.setColor(Color.rgb(255, 255, 255, 0.5));
        clickShadowLight.setRadius(16);
        clickShadowLight.setOffsetX(-6);
        clickShadowLight.setOffsetY(-6);

        // Chain the shadows together//
        clickShadow.setInput(clickShadowLight);

        Button button = new Button(text);
        button.setMaxWidth(Double.MAX_VALUE);
        button.setMaxHeight(Double.MAX_VALUE);
        button.setEffect(shadow);

        // change shadow on click
        button.addEventHandler(MouseEvent.MOUSE_PRESSED,
                (event) -> button.setEffect(clickShadow));

        // restore shadow on release
        button.addEventHandler(MouseEvent.MOUSE_RELEASED,
                (event) -> button.setEffect(shadow));

        return button;
    }

    private void layoutControls() {
        ColumnConstraints cc = new ColumnConstraints();
        cc.setHgrow(Priority.ALWAYS);
        getColumnConstraints().addAll(cc, cc, cc, cc);

        RowConstraints rc = new RowConstraints();
        rc.setVgrow(Priority.ALWAYS);
        getRowConstraints().addAll(new RowConstraints(), rc, rc, rc, rc, rc);

        add(display, 3, 0, 4, 1);

        add(ac, 0, 1);

        add(mc, 1, 1);
        add(divide, 3, 1);
        add(multiply, 3, 2);
        add(modulo, 2, 1);

        add(numberButtons.get(7), 0, 2);
        add(numberButtons.get(8), 1, 2);
        add(numberButtons.get(9), 2, 2);
        add(minus, 3, 3);

        add(numberButtons.get(4), 0, 3);
        add(numberButtons.get(5), 1, 3);
        add(numberButtons.get(6), 2, 3);
        add(plus, 3, 4);

        add(numberButtons.get(1), 0, 4);
        add(numberButtons.get(2), 1, 4);
        add(numberButtons.get(3), 2, 4);
        add(equal, 3, 5, 1, 1);

        add(numberButtons.get(0), 0, 5, 2, 1);
        add(dot, 2, 5);

        // set ID for different keys
        numberButtons.get(0).setId("zero-button");

        divide.setId("orange-button");
        multiply.setId("orange-button");
        minus.setId("orange-button");
        plus.setId("orange-button");
        equal.setId("orange-button");

        ac.setId("action-button");
        mc.setId("action-button");
        modulo.setId("action-button");

        // set FontWeight to Bold as JavaFX wont accept it in the stylesheet.//
        divide.setFont(Font.font("Montserrat", FontWeight.MEDIUM, 16));
        multiply.setFont(Font.font("Montserrat", FontWeight.MEDIUM, 16));
        minus.setFont(Font.font("Montserrat", FontWeight.MEDIUM, 16));
        plus.setFont(Font.font("Montserrat", FontWeight.MEDIUM, 16));
        equal.setFont(Font.font("Montserrat", FontWeight.MEDIUM, 16));

    }

}
