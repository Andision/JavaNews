package com.example.CONVID19News;

import androidx.fragment.app.Fragment;

import com.example.CONVID19News.bean.AtlasModel;
import com.example.CONVID19News.bean.CountryModel;

import java.util.ArrayList;
import java.util.List;

public class myData{

    private static List<String> tabStrings = new ArrayList<String>();
    private static List<String> unactiveTabStrings = new ArrayList<String>();
    private static int newspage=0;
    private static int paperpage=0;
    private static List<CountryModel>provinceModels;
    private static List<CountryModel>ChinaModels;

    private List<AtlasModel> amlist = new ArrayList<>();

    private static myData instance = new myData();


    private myData(){
        tabStrings.add("NEWS");
        tabStrings.add("PAPER");
//        tabStrings.add("C");
//        tabStrings.add("D");
//        unactiveTabStrings.add("X");
//        unactiveTabStrings.add("Y");


    }

    public static myData getInstance(){
        return instance;
    }

    public static List<String> getTabStrings(){
        return tabStrings;
    }

    public static List<String> getUnactiveTabStrings(){
        return unactiveTabStrings;
    }

    public static void deleteTabStringsItem(int i){
        tabStrings.remove(i);
    }

    public static int getNewsURLPage(){
        if(newspage>50)
            newspage=0;

        newspage++;
        return newspage;
    }

    public static int getPaperURLPage(){
        if(paperpage>50)
            paperpage=0;

        paperpage++;
        return paperpage;
    }

    public static List<CountryModel> getCountry(){
        return provinceModels;
    }
    public static void setCountry(List<CountryModel> prov){
        provinceModels=prov;
    }

    public static List<CountryModel> getChina(){
        return ChinaModels;
    }
    public static void setChina(List<CountryModel> prov){
        ChinaModels=prov;
    }

}
