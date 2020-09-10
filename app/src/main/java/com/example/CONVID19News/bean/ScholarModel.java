package com.example.CONVID19News.bean;

public class ScholarModel {
    private String name;
    private String name_zh;
    private String id;
    private String avator;
    private String activity;
    private String citations;
    private String diversity;
    private String gindex;
    private String hindex;
    private String newStar;
    private String risingStar;
    private String sociability;//好多是int   想知道有没有必要，，还有能不能全用String型，感觉可能会方便打印。
    private String is_passedaway;//boolean

    public ScholarModel(){}

    public String getName(){
        return name;
    }
    public void setName(String name1){
        this.name=name1;
    }
    public String getName_zh(){
        return name_zh;
    }
    public void setName_zh(String name_zh1){
        this.name_zh=name_zh1;
    }
    public String getAvator() {
        return avator;
    }
    public void setAvator(String av){
        this.avator=av;
    }
    public String getId(){
        return id;
    }
    public void setId(String id1){
        this.id=id1;
    }
    public String getActivity(){
        return activity;
    }
    public void setActivity(String activity1){
        this.activity=activity1;
    }
    public String getCitations(){
        return citations;
    }
    public void setCitations(String citations1){
        this.citations=citations1;
    }
    public String getDiversity(){
        return diversity;
    }
    public void setDiversity(String diversity1){
        this.diversity=diversity1;
    }
    public String getGindex(){
        return gindex;
    }
    public void setGindex(String gindex1){
        this.gindex=gindex1;
    }
    public String getHindex(){
        return hindex;
    }
    public void setHindex(String hindex1){
        this.hindex=hindex1;
    }
    public String getNewStar(){
        return newStar;
    }
    public void setNewStar(String newStar1){
        this.newStar=newStar1;
    }
    public String getRisingStar(){
        return risingStar;
    }
    public void setRisingStar(String risingStar1){this.risingStar=risingStar1;}
    public String getSociability(){
        return sociability;
    }
    public void setSociability(String sociability1){this.sociability=sociability1;}
    public String getIs_passedaway(){
        return is_passedaway;
    }
    public void setIs_passedaway(String is_passedaway1){this.is_passedaway=is_passedaway1;}

}
