package com.example.CONVID19News.background.bean;

import java.util.List;

public class CountryModel {
    private String area;
    private String begintime;
    private List<timedata> timedataList;
    public CountryModel(){}

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getBegintime() {
        return begintime;
    }

    public void setBegintime(String begintime) {
        this.begintime = begintime;
    }

    public List<timedata> getTimedataList() {
        return timedataList;
    }

    public void setTimedataList(List<timedata> timedataList) {
        this.timedataList = timedataList;
    }
    public  String toString(){

        String xx= area+"           " +
                "" +
                "" +
                "" +
                ""+begintime+"         ";
        for (int i = 0; i <timedataList.size() ; i++) {
            xx+=timedataList.get(i).getConfirmed()+"   "+timedataList.get(i).getSuspected()+"  "+timedataList.get(i).getCured()+"  "+timedataList.get(i).getDead();
            xx+= "      ";
        }
return xx;
    }
}
