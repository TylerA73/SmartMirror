/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package smartmirror;

import java.io.IOException;
import javafx.application.Application;
import javafx.geometry.Orientation;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 *
 * @author Tyler
 */
public class SmartMirror extends Application {
    
    @Override
    public void start(Stage primaryStage) throws IOException {
        
        
        DigitalClock timeText = new DigitalClock();
        DateDisplay dateText = new DateDisplay();
        TemperatureText tempText = new TemperatureText();
        WeatherText weatherText = new WeatherText();
        NewsText news = new NewsText();
        
        
        VBox top = new VBox();
        FlowPane right = new FlowPane();
        right.setOrientation(Orientation.VERTICAL);
        
        top.getChildren().addAll(timeText, dateText, new Text("\n"), tempText, weatherText);
        
        
        
        BorderPane root = new BorderPane();
        
        root.setStyle("-fx-background-color: black;");
        
        
        right.getChildren().add(news);
        
        root.setTop(top);
        root.setRight(right);
        
        
        Scene scene = new Scene(root, 500, 500);
        
        
        primaryStage.setTitle("Smart Mirror");
        primaryStage.setScene(scene);
        //primaryStage.setMaximized(true);
        primaryStage.setFullScreen(true);
        primaryStage.show();
        
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
