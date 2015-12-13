package modules;

import java.awt.event.ItemEvent;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.ToggleButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
import javafx.util.Duration;

public class Stopwatch extends StackPane {

    private Button modes;
    private ToggleButton startStop;
    private Button restart;
    private Stopwatch that;
    private Text display;
    private Core core;
    private LocalTime time;
    // private Duration time = Duration.ZERO, splitTime = Duration.ZERO;

    public Stopwatch(Pane clock) {
	initialize();
	initializeStopwatchButtons();

	// ********Modes management*****//
	modes = core.getModes();

	// ******Stopwatch  type********//
	display = core.getDisplay(display);

	// ********Time format**********//
	DateTimeFormatter format = core.getStopwatchTimeFormat();

	// ***Stopwatch functionality***//
	StringProperty hour = new SimpleStringProperty();
	time = LocalTime.MIDNIGHT;
	hour.setValue(time.format(format));
	Timeline timeline = new Timeline(new KeyFrame(Duration.millis(10), new EventHandler<ActionEvent>() {
	    @Override
	    public void handle(ActionEvent t) {
		Duration duration = ((KeyFrame) t.getSource()).getTime();
		time = time.plus((long) (duration.toMillis()), ChronoUnit.MILLIS);
		hour.setValue(time.format(format));
	    }
	}));
	timeline.setCycleCount(Animation.INDEFINITE);
	display.textProperty().bind(hour);

	// ********Buttons*************//
	startStop.setOnMouseClicked(new EventHandler<MouseEvent>() {
	    public void handle(MouseEvent event) {
		if (event.getSource() instanceof ToggleButton) {
		    ToggleButton source = (ToggleButton) event.getSource();
		    if (source.isSelected()) {
			startStop.setText("Stop");
			timeline.play();
		    } else {
			startStop.setText("Start");
			timeline.pause();
		    }
		}
	    }
	});

	restart.setOnMouseClicked(new EventHandler<MouseEvent>() {
	    public void handle(MouseEvent event) {
		timeline.stop();
		time = LocalTime.MIDNIGHT;
		hour.setValue(time.format(format));
		startStop.setSelected(false);
		startStop.setText("Start");
	    }
	});

	modes.setOnMouseClicked(new EventHandler<MouseEvent>() {
	    public void handle(MouseEvent event) {
		that.setVisible(false);
		clock.setVisible(true);
	    }
	});

	this.getChildren().addAll(display, modes, startStop, restart);
    }

    private void initialize() {
	this.that = this;
	core = new Core();
	display = new Text();
	display.setId("text");
	this.setId("background");
    }

    private void initializeStopwatchButtons() {
	int height = core.getHeight();
	int width = core.getWidth();
	
	startStop = new ToggleButton("Start");
	startStop.setManaged(true);
	startStop.setPrefWidth(50);
	startStop.setPrefHeight(25);
	startStop.setTranslateX(30);
	startStop.setTranslateY(+height/2-startStop.getPrefHeight()/2-30);
	
	restart = new Button("Reset");
	restart.setManaged(true);
	restart.setPrefWidth(50);
	restart.setPrefHeight(25);
	restart.setTranslateX(-30);
	restart.setTranslateY(+height/2-startStop.getPrefHeight()/2-30);
    }
}
