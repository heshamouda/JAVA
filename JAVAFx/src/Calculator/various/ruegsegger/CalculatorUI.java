package Calculator.various.ruegsegger;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.effect.BlendMode;
import javafx.scene.effect.BoxBlur;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.RowConstraints;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.util.ArrayList;

import static java.lang.Math.random;

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

    private Group circles = createCircles();
    private Rectangle colors = createRectangle();

    public CalculatorUI() {
        initializeSelf();
        initializeControls();
        layoutControls();
    }

    public Group getCircles() {
        return circles;
    }

    private void initializeSelf() {
        String stylesheet = getClass().getResource("style.css").toExternalForm();
        getStylesheets().add(stylesheet);
    }

    private void initializeControls() {
        for (int i = 0; i < 10; i++) {
            Button b = createButton(String.valueOf(i));
            b.getStyleClass().add("button--number");
            numberButtons.add(b);
        }

        dot = createButton(".");
        plus = createButton("+");
        minus = createButton("-");
        multiply = createButton("*");
        divide = createButton("/");

        plusminus = createButton("±");
        equal = createButton("=");
        ac = createButton("C");

        display = new Label("0");
        display.setMaxWidth(Double.MAX_VALUE);

    }

    private Group createCircles() {
        Group circles = new Group();
        for (int i = 0; i < 60; i++) {
            Circle circle = new Circle((40));
            circle.getStyleClass().add("circle");
            circles.getChildren().add(circle);
        }

        circles.setEffect(new BoxBlur(10, 10, 3));
        return circles;
    }

    public void createCircleAnimation(Stage stage) {
        Timeline timeline = new Timeline();

        for (Node circle : circles.getChildren()) {
            Circle c = (Circle) circle;
            double radius = c.getRadius();
            var StartPosX = random() * stage.getWidth();
            var StartPosY = random() * stage.getHeight();
            System.out.println(StartPosX);
            timeline.getKeyFrames().addAll(
                    new KeyFrame(Duration.ZERO,
                            new KeyValue(circle.translateXProperty(), StartPosX),
                            new KeyValue(circle.translateYProperty(), StartPosY)),
                    new KeyFrame(new Duration(15000),
                            new KeyValue(circle.translateXProperty(), random() * stage.getWidth()),
                            new KeyValue(circle.translateYProperty(), random() * stage.getHeight())),
                    new KeyFrame(new Duration(30000),
                            new KeyValue(circle.translateXProperty(), StartPosX),
                            new KeyValue(circle.translateYProperty(), StartPosY)));
        }
        timeline.setCycleCount(Animation.INDEFINITE);
        timeline.play();
        System.out.println(stage.getWidth());

    }

    private Rectangle createRectangle() {
        Rectangle rectangle = new Rectangle(200, 300);
        rectangle.getStyleClass().add("rectangle");
        return rectangle;
    }

    private Button createButton(String text) {
        Button button = new Button(text);
        button.setMaxWidth(Double.MAX_VALUE);
        button.setMaxHeight(Double.MAX_VALUE);
        button.setPrefSize(48, 48);

        return button;
    }

    private void layoutControls() {
        setHgap(3);
        setVgap(3);
        setPadding(new Insets(6));

        ColumnConstraints cc = new ColumnConstraints();
        cc.setHgrow(Priority.ALWAYS);
        getColumnConstraints().addAll(cc, cc, cc, cc);

        RowConstraints rc = new RowConstraints();
        rc.setVgrow(Priority.ALWAYS);
        getRowConstraints().addAll(new RowConstraints(), rc, rc, rc, rc, rc);

        colors.widthProperty().bind(widthProperty());
        colors.heightProperty().bind(heightProperty());
        colors.setBlendMode(BlendMode.OVERLAY);
        add(circles, 0, 0, 4, 6);
        add(colors, 0, 0, 4, 6);

        add(display, 0, 0, 4, 1);

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