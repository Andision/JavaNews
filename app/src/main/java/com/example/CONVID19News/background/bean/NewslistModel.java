package com.example.CONVID19News.background.bean;


public class NewslistModel {
private  String title;
private  String date;
private  String  From;
private  String  content;
public NewslistModel(){}

public  String getTitle(){return title;}
public void setTitle(String title1){this.title=title1;}

public  String getDate(){return date;}
public void setDate(String date1){this.date=date1;}

public  String getFrom(){return From;}
public void setFrom(String From1){this.From=From1;}

public  String getContent(){return content;}
public void setContent(String content1){this.content=content1;}

public  String toString(){
    return title+"" +
            "" +
            "" +
            "" +
            ""+date+""+From+"    " +
            "    " +
            "" +
            "" +
            "" +content;
}

}
