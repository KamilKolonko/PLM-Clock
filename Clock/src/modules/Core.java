package modules;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Properties;

import clock.Clock;
import clock.utils.CSSParser;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;
import javafx.scene.text.Text;
import javafx.util.Duration;

public class Core {

    private Properties properties;

    public Core() {
	properties = CSSParser.getProperties();
    }

    public StringProperty getTimeFormat() {
	DateTimeFormatter format = DateTimeFormatter.ofPattern(properties.getProperty("-hour-format"));
	StringProperty hour = new SimpleStringProperty();
	LocalTime time = LocalTime.now();
	hour.setValue(time.format(format));

	Timeline timeline = new Timeline(
		new KeyFrame(Duration.seconds(0), event -> hour.setValue(LocalTime.now().format(format))),
		new KeyFrame(Duration.millis(10)));

	timeline.setCycleCount(Animation.INDEFINITE);
	timeline.play();
	return hour;
    }
    
    public DateTimeFormatter getStopwatchTimeFormat() {
	return DateTimeFormatter.ofPattern(properties.getProperty("-stopwatch-format"));
    }

    public Text getDisplay(Text display) {
	return display;
    }

    public Shape getBackgroundShape() {
	String shape = properties.getProperty("-shape");
	int borderRadius = Integer.parseInt(properties.getProperty("-fx-border-radius"));
	double width = Integer.parseInt(properties.getProperty("-width"));
	double height = Integer.parseInt(properties.getProperty("-height"));
	int radius = Integer.parseInt(properties.getProperty("-fx-background-radius"));
	
	switch (shape) {
	case "rectangle":
	    Rectangle rect = new Rectangle(width, height);
	    rect.setArcHeight(borderRadius);
	    rect.setArcWidth(borderRadius);
	    return rect;
	case "circle":
	    Rectangle circle = new Rectangle(radius*2, radius*2);
	    circle.setArcHeight(radius*2);
	    circle.setArcWidth(radius*2);
	    return circle;
	case "triangle":
	    Polygon polygon = new Polygon();
	    polygon.getPoints().addAll(new Double[]{
	        width/2, 0.0,
	        width, height,
	        0.0, height });
	    return polygon;
	default:
	    Rectangle rect1 = new Rectangle(width, height);
	    rect1.setArcHeight(borderRadius);
	    rect1.setArcWidth(borderRadius);
	    return rect1;
	}
    }
    
    public Scene getSceneShape(Pane pane){
	String shape = properties.getProperty("-shape");
	int borderRadius = Integer.parseInt(properties.getProperty("-fx-border-radius"));
	int width = Integer.parseInt(properties.getProperty("-width"));
	int height = Integer.parseInt(properties.getProperty("-height"));
	int radius = Integer.parseInt(properties.getProperty("-fx-background-radius"));
	switch (shape) {
	case "rectangle":
	    return new Scene(pane, width, height);
	case "circle":
	    return new Scene(pane, radius*2, radius*2);
	case "triangle":
	    return new Scene(pane, width, height);
	default:
	    return new Scene(pane, width, height);
	}
    }
    
    public Button getModes(){
	int width = Integer.parseInt(properties.getProperty("-width"));
	int height = Integer.parseInt(properties.getProperty("-height"));
	Button modes = new Button("mode");
	modes.setManaged(true);
	modes.setPrefWidth(50);
	if (!getStopwatch()){
	    modes.setVisible(false);
	}
	modes.setPrefHeight(25);
	modes.setTranslateY(-height/2+modes.getPrefHeight()/2+20);
	return modes;
    }
    
    
    public int getHeight(){
	return Integer.parseInt(properties.getProperty("-height"));
    }
    
    public int getWidth(){
	return Integer.parseInt(properties.getProperty("-width"));
    }
    
    public boolean getStopwatch(){
	return Boolean.parseBoolean(properties.getProperty("-stopwatch"));
    }
}
