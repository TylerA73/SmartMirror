package smartmirror;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Zachary Shaw
 */
public class DailyNews {
    private String description;
    private String author;
    private String article;
    
    
    public void setDescription(String description){
    this.description = description;
    
}
    
    public void setAuthor(String author){
        this.author = author;
    }
    
    public void setArticle(String article){
        this.article = article;
        
    }
    
    public String getDesc() {
        return description;
    
}
    public String getAuthor(){
        return author;
    }
    
    public String getArticle(){
        return article;
    }
    
}
