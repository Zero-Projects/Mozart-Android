package com.mozart.custom_view_volley;
//This model class will be used to provide work objects data to list view after parsing the json.
import java.util.ArrayList;

public class ModelWork {
    private String title,date,category,coverURL,user;

    public ModelWork() {
    }

    public ModelWork(String title, String date,String category,
                     String coverURL,String user) {
        this.title = title;
        this.date = date;
        this.category = category;
        this.coverURL = coverURL;
        this.user = user;
    }

    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getCoverURL() {
        return coverURL;
    }
    public void setCoverURL(String coverURL) {
        this.coverURL = coverURL;
    }
    public String getDate(){
        return date;
    }
    public void setDate(String date){
        this.date = date;
    }
    public String getCategory(){
        return category;
    }
    public void setCategory(String category){
        this.category = category;
    }
    public String getUser(){
        return user;
    }
    public void setUser(String user){
        this.user = user;
    }
}