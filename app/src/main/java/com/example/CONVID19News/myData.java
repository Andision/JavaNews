package com.example.CONVID19News;

import androidx.fragment.app.Fragment;

import java.util.ArrayList;
import java.util.List;

public class myData{

    private static List<String> tabStrings = new ArrayList<String>();
    private static List<String> unactiveTabStrings = new ArrayList<String>();

    private static myData instance = new myData();

    private myData(){
        tabStrings.add("A");
        tabStrings.add("B");
        tabStrings.add("C");
        tabStrings.add("D");
        unactiveTabStrings.add("X");
        unactiveTabStrings.add("Y");


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

}
