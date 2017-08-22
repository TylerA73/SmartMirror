/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package smartmirror;

import java.io.IOException;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

/**
 * Display for the current temperature. Extends the Text class.
 * 
 * @author Tyler
 */
public class TemperatureText extends Text{
    Locator loc;
    City cityWeather;
    String DEGREES;
    
    
    
    /**
     * Constructor for the TemperatureText class.
     * 
     * @throws IOException 
     */
    public TemperatureText() throws IOException{
        DEGREES = "\u00b0" + "C";
        loc = new Locator();
        setWeather(loc.getCity(), loc.getCountry());
        setText("\t\t" + Integer.toString((int)cityWeather.getTemperature()) + DEGREES);
        setFill(Color.WHITE);
        setFont(Font.font("arial", FontWeight.THIN, FontPosture.REGULAR, 50));
        
        
        
    }
    
    /**
     * Sets the weather.
     * 
     * @param city
     * @param country
     * @throws IOException 
     */
    public void setWeather(String city, String country) throws IOException{
        WeatherFetcher wf = new WeatherFetcher(city, country);
        cityWeather = wf.getData();
    }
    
}
