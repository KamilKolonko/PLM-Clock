package clock;

import clock.utils.CSSParser;
import clock.utils.VariationConsts;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Clock extends Application {

    private double xOffset = 0;
    private double yOffset = 0;
    private static DateTimeFormatter SHORT_TIME_FORMATTER = DateTimeFormatter.ofPattern("HH:mm:ss");

    @Override
    public void start(final Stage primaryStage) {
        primaryStage.initStyle(StageStyle.TRANSPARENT);
        StackPane background = new StackPane();
        background.setId("background");

        new CSSParser("Clock.properties").updateStylesheet();

        StringProperty hour = new SimpleStringProperty();
        LocalTime time = LocalTime.now();
        hour.setValue(time.format(SHORT_TIME_FORMATTER));

        Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(0),
                event -> hour.setValue(LocalTime.now().format(SHORT_TIME_FORMATTER))),
                new KeyFrame(Duration.seconds(1)));

        timeline.setCycleCount(Animation.INDEFINITE);
        timeline.play();

        Text display = new Text();
        display.setId("text");
        display.textProperty().bind(hour);
        background.getChildren().add(display);

        Rectangle rect = new Rectangle(300, 200);
        rect.setArcHeight(60.0);
        rect.setArcWidth(60.0);
        background.setClip(rect);

        background.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                xOffset = event.getSceneX();
                yOffset = event.getSceneY();
            }
        });
        background.setOnMouseDragged(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                primaryStage.setX(event.getScreenX() - xOffset);
                primaryStage.setY(event.getScreenY() - yOffset);
            }
        });

        Scene scene = new Scene(background, 300, 200);
        primaryStage.initStyle(StageStyle.TRANSPARENT);
        scene.setFill(Color.TRANSPARENT);
        primaryStage.setScene(scene);
        primaryStage.getScene().getStylesheets().setAll(Clock.class.getResource("../style.css").toString());
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
