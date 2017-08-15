/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package smartmirror;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

/**
 * Checks current location based on IP address.
 * 
 * @author Tyler
 */
public class Locator {
    
    private final String URL = "http://freegeoip.net/json/";
    private String ip;
    private String city;
    private String country;
    private String latitude;
    private String longitude;
    
    
    /**
     * Constructor for the Locator class.
     * 
     * @throws IOException 
     */
    public Locator() throws IOException{
        
        JsonParser parser = new JsonParser();
        
        
        try{
            
            URL url = new URL(URL);

            URLConnection conn = url.openConnection();
            InputStreamReader isr = new InputStreamReader(conn.getInputStream());
            BufferedReader reader = new BufferedReader(isr);
            
            String input = reader.readLine();
            JsonObject jo = (JsonObject) parser.parse(input);
            reader.close();
            
            setIp(jo.get("ip").toString().replaceAll("\"", ""));
            setCity(jo.get("city").toString().replaceAll("\"", ""));
            setCountry(jo.get("country_code").toString().replaceAll("\"", ""));
            setLatitude(jo.get("latitude").toString().replaceAll("\"", ""));
            setLongitude(jo.get("longitude").toString().replaceAll("\"", ""));
            
            
            
            
        }catch(IOException ioe){
            
        }
        
        
    }
    
    public void setIp(String ip){
        this.ip = ip;
    }
    
    public void setCity(String city){
        this.city = city;
    }
    
    public void setCountry(String country){
        this.country = country;
    }
    
    public void setLatitude(String latitude){
        this.latitude = latitude;
    }
    
    public void setLongitude(String longitude){
        this.longitude = longitude;
    }
    
    public String getIp(){
        return ip;
    }
    
    public String getCity(){
        return city;
    }
    
    public String getCountry(){
       return country;
    }
    
    public String getLatitude(){
        return latitude;
    }
    
    public String getLongitude(){
        return longitude;
    }
    
}
