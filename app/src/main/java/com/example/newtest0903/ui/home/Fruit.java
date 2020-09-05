package com.example.newtest0903.ui.home;

import android.webkit.JavascriptInterface;

public class Fruit {

    private String name;

    public Fruit(String name){
        this.name = name;

    }

    @JavascriptInterface
    public String getName() {
        return name;
    }

}