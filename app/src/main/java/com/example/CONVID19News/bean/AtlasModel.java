package com.example.CONVID19News.bean;

import java.util.List;
import com.example.CONVID19News.bean.Properties;

public class AtlasModel {
    private String data_url;
    private String label;
    private String enwiki;
    private String  baidu;
    private String  zhwiki;
    private List<Relations> relations;
//   private String property;
   private List<Properties> properties;
    private String img;

    public String getBaidu() {
        return baidu;
    }
    public void setBaidu(String baidu) {
        this.baidu = baidu;
    }

    public String getEnwiki() {
        return enwiki;
    }

    public void setEnwiki(String enwiki) {
        this.enwiki = enwiki;
    }


    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

//    public String getProperty() {
//        return property;
//    }

//    public void setProperty(String property) {
//        this.property = property;
//    }


    public String getData_url() {
        return data_url;
    }

    public void setData_url(String data_url) {
        this.data_url = data_url;
    }

    public String getZhwiki() {
        return zhwiki;
    }

    public void setZhwiki(String zhwiki) {
        this.zhwiki = zhwiki;
    }

    public List<Relations> getRelations() {
        return relations;
    }

    public void setRelations(List<Relations> relations) {
        this.relations = relations;
    }

    public List<Properties> getProperties() {
        return properties;
    }

    public void setProperties(List<Properties> properties) {
        this.properties = properties;
    }

    public  String toString(){

        String xx= data_url+"           " +label+"         "+data_url+"     "+enwiki+"   "+baidu+"    "+zhwiki+"      ";

        for (int j = 0; j <properties.size() ; j++) {
            xx+=properties.get(j).getSxmc()+"   "+properties.get(j).getSxz()+"    ";
        }
        for (int i = 0; i <relations.size() ; i++) {
            xx+=relations.get(i).getRelation()+"       "+relations.get(i).getDt_url()+"      "+relations.get(i).getDt_label()+"    "+relations.get(i).getForward()+"    ";
            xx+= "      ";
        }
        return xx;
    }
}
