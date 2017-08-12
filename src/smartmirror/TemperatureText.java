/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package smartmirror;

import java.io.IOException;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;

/**
 *
 * @author Tyler
 */
public class TemperatureText extends Text{
    Locator loc;
    
    City cityWeather;
    
    
    
    
    public TemperatureText() throws IOException{
        
        loc = new Locator();
        setWeather(loc.getCity(), loc.getCountry());
        setText(Double.toString(cityWeather.getTemperature()));
        setFill(Color.WHITE);
        
        
        
    }
    
    public void setWeather(String city, String country) throws IOException{
        WeatherFetcher wf = new WeatherFetcher(city, country);
        cityWeather = wf.getData();
    }
    
}
