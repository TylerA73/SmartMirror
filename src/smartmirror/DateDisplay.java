/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package smartmirror;

import java.io.IOException;
import java.net.URL;
import java.text.DateFormatSymbols;
import javafx.animation.*;
import javafx.event.*;
import javafx.scene.control.Label;
import javafx.util.Duration;

import java.util.Calendar;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

/**
 *
 * @author Tyler
 */
class DateDisplay extends Text {
  public DateDisplay() {
    bindToTime();
    setFill(Color.WHITE);
    setFont(Font.font("arial", FontWeight.THIN, FontPosture.REGULAR, 25));
  }

  // the digital clock updates once a second.
  private void bindToTime() {
    Timeline timeline = new Timeline(
      new KeyFrame(Duration.seconds(0),
        new EventHandler<ActionEvent>() {
          @Override public void handle(ActionEvent actionEvent) {
            Calendar date = Calendar.getInstance();
            DateFormatSymbols dfs = new DateFormatSymbols();
            String[] months = dfs.getMonths();
            
            String month = months[date.getTime().getMonth()] + " ";
            
            String day = date.getTime().getDay() + ", ";
            
            String year = (date.getTime().getYear()+ 1900) + "";
     
            setText("\t" + month + day + year);
          }
        }
      ),
      new KeyFrame(Duration.seconds(1))
    );
    timeline.setCycleCount(Animation.INDEFINITE);
    timeline.play();
  }
}
