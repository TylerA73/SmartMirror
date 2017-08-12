/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package smartmirror;

import java.io.IOException;
import javafx.geometry.Pos;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

/**
 *
 * @author Tyler
 */
public class TemperatureText extends Text{
    Locator loc;
    City cityWeather;
    String DEGREE;
    
    
    
    
    public TemperatureText() throws IOException{
        DEGREE = "\u00b0" + "C";
        loc = new Locator();
        setWeather(loc.getCity(), loc.getCountry());
        setText("\t\t" + Integer.toString((int)cityWeather.getTemperature()) + DEGREE);
        setFill(Color.WHITE);
        setFont(Font.font("arial", FontWeight.THIN, FontPosture.REGULAR, 50));
        
        
        
    }
    
    public void setWeather(String city, String country) throws IOException{
        WeatherFetcher wf = new WeatherFetcher(city, country);
        cityWeather = wf.getData();
    }
    
}
