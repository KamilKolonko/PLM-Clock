package clock;

import javax.swing.JButton;

import clock.utils.CSSParser;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import modules.Core;
import modules.Stopwatch;

public class Clock extends Application {

    public double xOffset = 0;
    public double yOffset = 0;

    private CSSParser cssParser;
    private Core core;
    private Text display;
    private Pane background;
    private Scene scene;
    private Button modes;
    private Pane stopwatch;
    private Pane rootPane;

    @Override
    public void start(final Stage primaryStage) {
	initializeObjects();
	initializeScene();
	
	// ********Clock colors*********//
	cssParser.updateStylesheet();

	// ********Clock type***********//
	display = core.getDisplay(display);

	// ********Time format**********//
	display.textProperty().bind(core.getTimeFormat());

	// ********Shape****************//
	background.setClip(core.getBackgroundShape());
	scene = core.getSceneShape(rootPane);
	
	// ****Clock functionalities****//
	if(core.getStopwatch()){
	    stopwatch = new Stopwatch(background);
	    rootPane.getChildren().add(stopwatch);
	}

	// ********Modes management*****//
	modes = core.getModes();

	rootPane.setOnMousePressed(new EventHandler<MouseEvent>() {
	    @Override
	    public void handle(MouseEvent event) {
		xOffset = event.getSceneX();
		yOffset = event.getSceneY();
	    }
	});
	rootPane.setOnMouseDragged(new EventHandler<MouseEvent>() {
	    @Override
	    public void handle(MouseEvent event) {
		primaryStage.setX(event.getScreenX() - xOffset);
		primaryStage.setY(event.getScreenY() - yOffset);
	    }
	});
	modes.setOnMouseClicked(new EventHandler<MouseEvent>(){
	    public void handle(MouseEvent event){
		background.setVisible(false);
		stopwatch.setVisible(true);
	    }
	});

	background.getChildren().add(display);
	background.getChildren().add(modes);
	rootPane.getChildren().add(background);
	primaryStage.initStyle(StageStyle.TRANSPARENT);
	scene.setFill(Color.TRANSPARENT);
	primaryStage.setScene(scene);
	primaryStage.getScene().getStylesheets().setAll(Clock.class.getResource("../style.css").toString());
	primaryStage.show();
    }

    private void initializeObjects() {
	cssParser = new CSSParser("Clock.properties");
	core = new Core();
    }

    private void initializeScene() {
	display = new Text();
	display.setId("text");
	rootPane = new StackPane();
	rootPane.setId("background");
	background = new StackPane();
	background.setId("background");
    }

    public static void main(String[] args) {
	launch(args);
    }
}
