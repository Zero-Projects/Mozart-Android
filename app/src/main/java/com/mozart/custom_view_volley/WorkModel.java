package com.mozart.custom_view_volley;
//This model class will be used to provide work objects data to list view after parsing the json.
import java.util.ArrayList;

public class WorkModel {
    private String title,date,category,coverURL,autor;

    public WorkModel() {
    }

    public WorkModel(String title, String date, String category,
                     String coverURL, String autor) {
        this.title = title;
        this.date = date;
        this.category = category;
        this.coverURL = coverURL;
        this.autor = autor;
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
    public String getAutor(){
        return autor;
    }
    public void setAutor(String user){
        this.autor = user;
    }
}