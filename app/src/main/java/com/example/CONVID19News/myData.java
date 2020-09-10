package com.example.CONVID19News;

import androidx.fragment.app.Fragment;

import java.util.ArrayList;
import java.util.List;

public class myData{

    private static List<String> tabStrings = new ArrayList<String>();
    private static List<String> unactiveTabStrings = new ArrayList<String>();
    private static int newspage=1;

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
        if(newspage>99)
            newspage=0;

        newspage++;
        return newspage;
    }

}
