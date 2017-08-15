/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package smartmirror;

/**
 * Weather Enumerated data type
 * 
 * @author Tyler Arseneault
 */
public enum Weather {
    THUNDERSTORM(200, "Thunderstorms"), DRIZZLE(300, "Drizzle"), RAIN(500, "Rain"),
    SNOW(600, "Snow"), CLEAR(800, "Clear Sky"),CLOUDS(801, "Few Clouds"),
    OVERCAST(804, "Overcast");
    
    private int id;
    private String name;
    
    /**
     * Constructor for the Weather enum.
     * 
     * @param id    An int intended as the ID of the weather type.
     * @param name  String as the name of the weather type (will also add an icon later)
     */
    Weather(int id, String name){
        this.id = id;
        this.name = name;
    }
    
    /**
     * Override of the toString method of the Object class. Returns the name of the
     * Weather type.
     * @return  Returns the String name.
     */
    @Override
    public String toString(){
        return name;
    }
    
    /**
     * Method intended to return the ID of a weather type.
     * 
     * @return Returns the ID of the Weather type.
     */
    public int getID(){
        return id;
    }
    
    /**
     * Check equivalence of the weather IDs.
     * 
     * @param id    Weather ID
     * @return      True if weather IDs are in the same class, false otherwise.
     */
    public boolean isEqual(int id){
        return (id/this.id) == 1;
    }
}
