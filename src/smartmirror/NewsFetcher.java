/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package smartmirror;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

/**
 *
 * @author Zachary Shaw
 */
public class NewsFetcher {

    String NEWS_API_URL;
    String NEWS_API_KEY;
    
    NewsFetcher(){
        NEWS_API_URL = "https://newsapi.org/v1/articles?source=techcrunch&apiKey=";
        NEWS_API_KEY = "33937cfedc4c431a8cf24997372dece4";
    }
    



    public DailyNews getData() throws MalformedURLException, IOException{
            JsonParser parser = new JsonParser();
            DailyNews dailyNews = new DailyNews();
            
            try{
                URL url = new URL(NEWS_API_URL + NEWS_API_KEY);
                URLConnection conn = url.openConnection();
                BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
                
                String api_in;
                
                while ((api_in = br.readLine()) != null){
                    JsonObject news_j = (JsonObject)parser.parse(api_in);
                    String articles = news_j.getAsJsonArray("articles").toString().replaceAll(":", "");
                    
                    
                    
                    String[] newsArray = articles.split(",");
                    String author = new String();
                    String title = new String();
                    String desc = new String();
                    
                    //System.out.println(newsArray.length);
                    //System.out.println(articles);
                    
                    for(int i = 0; i < 3; i++){
                        //System.out.println(newsArray[i]);
                        
                        if (newsArray[i].contains("description")){
                            desc = newsArray[i];
                            desc = desc.replaceAll("description", "");
                            desc = desc.replaceAll("\"", "");
                        }
                        
                        else if (newsArray[i].contains("title")){
                            title = newsArray[i];
                            title = title.replaceAll("title", "");
                            title = title.replaceAll("\"", "");
                            
                            
                        }
                        else if (newsArray[i].contains("author")){
                            author = newsArray[i];
                            author = author.replaceAll("author", "");
                            author = author.replaceAll("\"", "");
                            author = author.replaceAll("\\[", "").replaceAll("\\{", "");
                            
                            
                            
                        }
                    }

                        
                dailyNews.setAuthor(author);
                dailyNews.setDescription(desc);
                dailyNews.setArticle(title);
                    
                }
            }
            catch (IOException e) {
            e.printStackTrace();
    }
           
            return dailyNews;
            
            
    
    }

}
