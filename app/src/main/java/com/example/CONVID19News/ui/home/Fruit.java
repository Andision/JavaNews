package com.example.CONVID19News.ui.home;

import android.webkit.JavascriptInterface;

public class Fruit {

    private String title;
    private String date;
    private String ffrom;
    private String content;
    private int readornot;



    public Fruit(String name){
        this.title = name;
    }

    public Fruit(String s1,String s2,String s3,String s4,int s5){
        title=s1;
        date=s2;
        ffrom=s3;
        content=s4;
        readornot=s5;
    }

    public String getName() {
        return title;
    }

    public String getTitle() {
        return title;
    }
    public String getDate() {
        return date;
    }
    public String getFrom() {
        return ffrom;
    }
    public String getContent() {
        return content;
    }
    public boolean isRead(){
        if(readornot==1)return true;
        else return false;
    }public void setIsRead(){
        readornot=1;
    }

}