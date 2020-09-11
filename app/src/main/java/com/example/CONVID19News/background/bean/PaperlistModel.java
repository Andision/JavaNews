package com.example.CONVID19News.background.bean;

public class PaperlistModel {
    private  String title;
    private  String date;
    private  String  authors;
    private  String  content;
    public PaperlistModel(){}
    public  String getTitle(){return title;}
    public void setTitle(String title1){this.title=title1;}

    public  String getDate(){return date;}
    public void setDate(String date1){this.date=date1;}

    public  String getAuthors(){return authors;}
    public void setAuthors(String authors1){this.authors=authors1;}

    public  String getContent(){return content;}
    public void setContent(String content1){this.content=content1;}

    public  String toString(){
        return title+"           " +
                "" +
                "" +
                "" +
                ""+date+"         "+authors+"    " +
                "" +
                "" +
                "" +
                "" +content;
    }
}
