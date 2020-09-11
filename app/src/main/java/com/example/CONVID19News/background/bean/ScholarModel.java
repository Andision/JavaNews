package com.example.CONVID19News.background.bean;

public class ScholarModel {
    private String name;//英文名
    private String name_zh;//中文名
    private String id;//id 唯一标识符
    private String avator;//学者头像的地址
    private String activity;//
    private String citations;
    private String diversity;
    private String gindex;
    private String hindex;
    private String newStar;
    private String risingStar;
    private String sociability;//好多是int   想知道有没有必要，，还有能不能全用String型，感觉可能会方便打印。
    private String is_passedaway;//boolean
    private String position;
    private String bio;
    private String edu;
    private String affiliation;

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

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }


    public boolean getIs_passedaway() {
        if(is_passedaway.equals("true"))
            return true;
        else return false;
    }

    public void setIs_passedaway(String is_passedaway) {
        this.is_passedaway = is_passedaway;
    }

    public String getRisingStar() {
        return risingStar;
    }

    public void setRisingStar(String risingStar) {
        this.risingStar = risingStar;
    }

    public String getSociability() {
        return sociability;
    }

    public void setSociability(String sociability) {
        this.sociability = sociability;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getAffiliation() {
        return affiliation;
    }

    public void setAffiliation(String affiliation) {
        this.affiliation = affiliation;
    }

    public String getEdu() {
        return edu;
    }

    public void setEdu(String edu) {
        this.edu = edu;
    }

    public  String toString(){

        String xx= avator+"           " +id+"         "+activity+"     "+citations+"   "+diversity+"    "+gindex+"      "+hindex+"     "+newStar+"    "+risingStar+"     "+sociability+"      "+name+"      "+name_zh+"     "+position+"       "+affiliation+"    "+bio+"     "+edu+"   "+is_passedaway+"       ";


        return xx;
    }
}
