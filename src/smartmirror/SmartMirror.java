/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package smartmirror;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
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
        TemperatureText temp = new TemperatureText();
        
        FlowPane dt = new FlowPane();
        dt.setOrientation(Orientation.VERTICAL);
        
        
        
        BorderPane root = new BorderPane();
        
        root.setStyle("-fx-background-color: black;");
        
        dt.getChildren().add(timeText);
        dt.getChildren().add(dateText);
        
        root.setTop(dt);
        
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
