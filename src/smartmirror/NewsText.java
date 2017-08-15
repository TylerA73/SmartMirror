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
 *
 * @author Zachary Shaw
 */
public class NewsText extends Text{
    DailyNews news;
    String author;
    String description;
    String article;
    String combined;
    
    
    
    public NewsText(){
        try{
            
            setNews();
            author = news.getAuthor();
            description = news.getDesc();
            article = news.getArticle();
            combined = article + "\n" + description;
            setText(combined);
            setFill(Color.WHITE);
            setFont(Font.font("arial", FontWeight.THIN, FontPosture.REGULAR, 12));
    }
        catch(IOException e){
            e.printStackTrace();
        }
    
    
    }
    
    
    
    public void setNews() throws IOException{
        NewsFetcher nf = new NewsFetcher();
        news = nf.getData();
        
    }
}
